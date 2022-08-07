package ru.gpbi.requestprocessing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpbi.requestprocessing.config.properties.LimitProperties;
import ru.gpbi.requestprocessing.entity.Request;
import ru.gpbi.requestprocessing.exception.EntityNotFoundException;
import ru.gpbi.requestprocessing.exception.LimitExceedingException;
import ru.gpbi.requestprocessing.mapper.RequestMapper;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.model.request.RequestTagLinkDto;
import ru.gpbi.requestprocessing.model.response.ResponseRequestDto;
import ru.gpbi.requestprocessing.repository.RequestRepository;
import ru.gpbi.requestprocessing.repository.TagRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

		private final RequestRepository requestRepository;
		private final TagRepository tagRepository;
		private final RequestMapper requestMapper;
		private final LimitProperties limitProperties;


		public ResponseRequestDto save(RequestRequestDto requestDto) {
				Request request = requestRepository.save(requestMapper.mapToDao(requestDto));
				return requestMapper.mapToDto(request);
		}

		public List<ResponseRequestDto> findAll() {
				return requestRepository.findAll().stream().map(requestMapper::mapToDto).toList();
		}

		public ResponseRequestDto updateRequest(RequestTagLinkDto tagLinkDto) {
				Request request = requestRepository.findById(tagLinkDto.getRequestId())
								.orElseThrow(() -> new EntityNotFoundException(String.format("Request %s not found",
												tagLinkDto.getRequestId())));
				checkLimits(tagLinkDto, request);

				tagLinkDto.getTagIds().stream().map(id -> tagRepository.findById(id)
												.orElseThrow(() -> new EntityNotFoundException(String.format("Tag %s not found", id))))
								.forEach(tag -> request.getTags().add(tag));
				requestRepository.save(request);
				return requestMapper.mapToDto(request);
		}

		private void checkLimits(RequestTagLinkDto tagLinkDto, Request request) {
				Integer tagLimit = limitProperties.getTag();
				Integer tagSum = request.getTags().size() + tagLinkDto.getTagIds().size();
				if (tagSum > tagLimit) {
						throw new LimitExceedingException(
										String.format("Too many tags. Limit is %s. But result sum is %s", tagLimit, tagSum));
				}

		}

}
