package ru.gpbi.requestprocessing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpbi.requestprocessing.entity.Request;
import ru.gpbi.requestprocessing.mapper.RequestMapper;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.model.response.ResponseRequestDto;
import ru.gpbi.requestprocessing.repository.RequestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

		private final RequestRepository requestRepository;
		private final RequestMapper requestMapper;


		public ResponseRequestDto save(RequestRequestDto requestDto) {
				Request request = requestRepository.save(requestMapper.mapToDao(requestDto));
				return requestMapper.mapToDto(request);
		}

		public List<ResponseRequestDto> findAll() {
				return requestRepository.findAll().stream().map(requestMapper::mapToDto).toList();
		}
}
