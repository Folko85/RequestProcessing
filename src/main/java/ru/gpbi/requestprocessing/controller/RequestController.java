package ru.gpbi.requestprocessing.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.model.request.RequestTagLinkDto;
import ru.gpbi.requestprocessing.model.response.ResponseRequestDto;
import ru.gpbi.requestprocessing.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/requests")
@AllArgsConstructor
@Tag(name = "Контроллер для работы с запросами")
public class RequestController {

		private final RequestService requestService;

		@PostMapping("/create")
		@Operation(summary = "Добавить запрос")
		public ResponseRequestDto create(@RequestBody RequestRequestDto requestDto) {
				return requestService.save(requestDto);
		}

		@PutMapping("/add/tags")
		@Operation(summary = "Добавить теги к запросу")
		public ResponseRequestDto addTag(@RequestBody RequestTagLinkDto tagLinkDto) {
				return requestService.updateRequest(tagLinkDto);
		}

		@GetMapping("/all")
		@Operation(summary = "Получить все запросы")
		public List<ResponseRequestDto> getAll() {
				return requestService.findAll();
		}

		@GetMapping("/byTag/{tagName}")
		@Operation(summary = "Получить все запросы по тегу")
		public List<ResponseRequestDto> getByTag(@PathVariable String tagName) {
				return requestService.findByTagName(tagName);
		}

		@GetMapping("/byFolder/{folderName}")
		@Operation(summary = "Получить все запросы по идентификатору папки")
		public List<ResponseRequestDto> getByFolder(@PathVariable String folderName) {
				return requestService.findByFolderName(folderName);
		}

}
