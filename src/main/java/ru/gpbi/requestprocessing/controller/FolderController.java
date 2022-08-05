package ru.gpbi.requestprocessing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("folders")
public class FolderController {

		@PostMapping("/create")
		public ResponseFolderDto create(String folderName) {
				return new ResponseFolderDto();
		}

		@PutMapping("/add/requests/{requestId}")
		public ResponseFolderDto addRequest(@PathVariable Long requestId) {
				return new ResponseFolderDto();
		}

		@GetMapping("/all")
		public List<ResponseFolderDto> getAll() {
				return new ArrayList<>();
		}

}
