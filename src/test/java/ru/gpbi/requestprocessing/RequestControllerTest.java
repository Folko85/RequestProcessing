package ru.gpbi.requestprocessing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.gpbi.requestprocessing.entity.Request;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.repository.RequestRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DirtiesContext
public class RequestControllerTest extends ApplicationTest {

		@Autowired
		RequestRepository requestRepository;

		@AfterEach
		void tearDown() {
				requestRepository.deleteAll();
		}

		@Test
		public void testGetAllFolders() throws Exception {
				Request request = new Request();
				request.setLength(ThreadLocalRandom.current().nextLong());
				request.setText("random text");
				request.setModifiedDate(ThreadLocalRandom.current().nextLong());
				requestRepository.save(request);
				mockMvc.perform(MockMvcRequestBuilders
												.get("/requests/all")
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of(request))));
		}

		@Test
		public void testCreateFolder() throws Exception {
				RequestRequestDto requestDto = new RequestRequestDto();
				requestDto.setLength(ThreadLocalRandom.current().nextLong());
				requestDto.setText("random text");
				requestDto.setModifiedDate(ThreadLocalRandom.current().nextLong());
				mockMvc.perform(MockMvcRequestBuilders
												.post("/requests/create")
												.content(mapper.writeValueAsString(requestDto))
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
				Assertions.assertEquals(1, requestRepository.findAll().size());
		}
}
