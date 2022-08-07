package ru.gpbi.requestprocessing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.gpbi.requestprocessing.entity.Tag;
import ru.gpbi.requestprocessing.model.request.RequestTagDto;
import ru.gpbi.requestprocessing.repository.TagRepository;

import java.util.List;

@DirtiesContext
public class TagControllerTest extends ApplicationTest {

		@Autowired
		TagRepository tagRepository;

		@AfterEach
		void tearDown() {
				tagRepository.deleteAll();
		}

		@Test
		public void testGetAllTags() throws Exception {
				Tag tag = new Tag();
				tag.setTagName("tagname");
				tagRepository.save(tag);
				mockMvc.perform(MockMvcRequestBuilders
												.get("/tags/all")
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of(tag))));
		}

		@Test
		public void testCreateTag() throws Exception {
				RequestTagDto tagDto = new RequestTagDto();
				tagDto.setTagName("something");
				mockMvc.perform(MockMvcRequestBuilders
												.post("/tags/create")
												.content(mapper.writeValueAsString(tagDto))
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
				Assertions.assertEquals(1, tagRepository.findAll().size());
		}


}
