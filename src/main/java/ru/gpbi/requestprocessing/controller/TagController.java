package ru.gpbi.requestprocessing.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.request.RequestTagDto;
import ru.gpbi.requestprocessing.model.response.ResponseTagDto;
import ru.gpbi.requestprocessing.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

		private final TagService tagService;

		@PostMapping("/create")
		public ResponseTagDto create(@RequestBody RequestTagDto tagDto) {
				return tagService.save(tagDto);
		}

		@GetMapping("/all")
		public List<ResponseTagDto> getAll() {
				return tagService.findAll();
		}

}
