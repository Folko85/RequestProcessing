package ru.gpbi.requestprocessing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpbi.requestprocessing.entity.Tag;
import ru.gpbi.requestprocessing.mapper.TagMapper;
import ru.gpbi.requestprocessing.model.request.RequestTagDto;
import ru.gpbi.requestprocessing.model.response.ResponseTagDto;
import ru.gpbi.requestprocessing.repository.TagRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

		private final TagRepository tagRepository;
		private final TagMapper tagMapper;

		public ResponseTagDto save(RequestTagDto tagDto) {
				Tag tag = tagRepository.save(tagMapper.mapToDao(tagDto));
				return tagMapper.mapToDto(tag);
		}

		public List<ResponseTagDto> findAll() {
				return tagRepository.findAll().stream().map(tagMapper::mapToDto).toList();
		}
}
