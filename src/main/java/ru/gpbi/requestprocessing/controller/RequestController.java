package ru.gpbi.requestprocessing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.model.response.ResponseRequestDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {


		@PostMapping("/create")
		public ResponseRequestDto create(RequestRequestDto request) {
				return new ResponseRequestDto();
		}

		@PutMapping("/add/tags/{tagId}")
		public ResponseRequestDto addTag(@PathVariable Long tagId) {
				return new ResponseRequestDto();
		}

		@GetMapping("/all")
		public List<ResponseRequestDto> getAll() {
				return new ArrayList<>();
		}

		@GetMapping("/byTag/{tagId}")
		public List<ResponseRequestDto> getByTag(@PathVariable Long tagId) {
				return new ArrayList<>();
		}

		@GetMapping("/byFolder/{folderId}")
		public List<ResponseRequestDto> getByFolder(@PathVariable Long folderId) {
				return new ArrayList<>();
		}

}
