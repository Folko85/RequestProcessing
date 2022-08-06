package ru.gpbi.requestprocessing.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;
import ru.gpbi.requestprocessing.service.FolderService;

import java.util.List;

@RestController
@RequestMapping("folders")
@AllArgsConstructor
public class FolderController {

		private final FolderService folderService;

		@PostMapping("/create")
		public ResponseFolderDto create(RequestFolderDto folderDto) {
				return folderService.save(folderDto);
		}

		@PutMapping("/add/requests/{requestId}")
		public ResponseFolderDto addRequest(@PathVariable Long requestId) {
				return new ResponseFolderDto();
		}

		@GetMapping("/all")
		public List<ResponseFolderDto> getAll() {
				return folderService.findAll();
		}

}
