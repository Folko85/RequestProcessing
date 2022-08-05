package ru.gpbi.requestprocessing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gpbi.requestprocessing.model.response.ResponseTagDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

		@PostMapping("/create")
		public ResponseTagDto create(String tagName) {
				return new ResponseTagDto();
		}

		@GetMapping("/all")
		public List<ResponseTagDto> getAll() {
				return new ArrayList<>();
		}

}
