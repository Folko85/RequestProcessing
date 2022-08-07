package ru.gpbi.requestprocessing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.gpbi.requestprocessing.entity.Folder;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.repository.FolderRepository;

import java.util.List;

@DirtiesContext
public class FolderControllerTest extends ApplicationTest {

		@Autowired
		FolderRepository folderRepository;

		@AfterEach
		void tearDown() {
				folderRepository.deleteAll();
		}

		@Test
		public void testGetAllFolders() throws Exception {
				Folder folder = new Folder();
				folder.setFolderName("folderName");
				folderRepository.save(folder);
				mockMvc.perform(MockMvcRequestBuilders
												.get("/folders/all")
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of(folder))));
		}

		@Test
		public void testCreateFolder() throws Exception {
				RequestFolderDto folderDto = new RequestFolderDto();
				folderDto.setFolderName("something");
				mockMvc.perform(MockMvcRequestBuilders
												.post("/folders/create")
												.content(mapper.writeValueAsString(folderDto))
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
				Assertions.assertEquals(1, folderRepository.findAll().size());
		}
}
