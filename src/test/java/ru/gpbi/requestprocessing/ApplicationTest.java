package ru.gpbi.requestprocessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoDriverInformation;
import com.mongodb.client.MongoClient;
import com.mongodb.client.internal.MongoClientImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootTest(classes = {RequestProcessingApplication.class, ApplicationTest.SpringMongoConfig.class},
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class ApplicationTest {

		@DynamicPropertySource
		static void mongoDbProperties(DynamicPropertyRegistry registry) {
				registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
		}

		@Container
		public static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.1.1"));

		/**
		 * Web application context.
		 */
		@Autowired
		protected WebApplicationContext ctx;

		/**
		 * Mock mvc.
		 */
		protected MockMvc mockMvc;

		/**
		 * Object mapper.
		 */
		@Autowired
		protected ObjectMapper mapper;

		/**
		 * Create mock mvc.
		 */
		@BeforeEach
		public void setup() {
				mockMvc = MockMvcBuilders
								.webAppContextSetup(ctx)
								.build();
		}

		@BeforeAll
		static void setUpAll() {
				mongoDBContainer.start();
		}

		@AfterAll
		static void tearDownAll() {
				mongoDBContainer.stop();
		}

		@Configuration
		public static class SpringMongoConfig {

				public String getDatabaseName() {
						return "test";
				}

				@Bean
				public MongoClient mongoClient() {
						MongoClientSettings settings = MongoClientSettings.builder()
										.applyConnectionString(new ConnectionString(mongoDBContainer.getReplicaSetUrl()))
										.build();
						MongoDriverInformation information = MongoDriverInformation.builder().build();
						return new MongoClientImpl(settings, information);
				}

				@Bean
				public SimpleMongoClientDatabaseFactory mongoDbFactory() {
						return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
				}

				@Bean
				public MongoTemplate mongoTemplate() {
						return new MongoTemplate(mongoDbFactory());
				}
		}

}
