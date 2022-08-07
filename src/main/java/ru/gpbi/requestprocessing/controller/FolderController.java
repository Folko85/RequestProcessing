package ru.gpbi.requestprocessing.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.model.request.RequestFolderLinkDto;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;
import ru.gpbi.requestprocessing.service.FolderService;

import java.util.List;

@RestController
@RequestMapping("folders")
@AllArgsConstructor
@Tag(name = "Контроллер для работы с папками")
public class FolderController {

		private final FolderService folderService;

		@PostMapping("/create")
		@Operation(summary = "Добавить папку")
		public ResponseFolderDto create(@RequestBody RequestFolderDto folderDto) {
				return folderService.save(folderDto);
		}

		@PutMapping("/add/requests")
		@Operation(summary = "Добавить в папку запросы")
		public ResponseFolderDto addRequest(@RequestBody RequestFolderLinkDto requestFolderLinkDto) {
				return folderService.updateFolder(requestFolderLinkDto);
		}

		@GetMapping("/all")
		@Operation(summary = "Получить все папки")
		public List<ResponseFolderDto> getAll() {
				return folderService.findAll();
		}

}
