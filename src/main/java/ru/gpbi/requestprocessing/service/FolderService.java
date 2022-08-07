package ru.gpbi.requestprocessing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpbi.requestprocessing.entity.Folder;
import ru.gpbi.requestprocessing.entity.Request;
import ru.gpbi.requestprocessing.exception.EntityNotFoundException;
import ru.gpbi.requestprocessing.exception.LimitExceedingException;
import ru.gpbi.requestprocessing.mapper.FolderMapper;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.model.request.RequestFolderLinkDto;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;
import ru.gpbi.requestprocessing.repository.FolderRepository;
import ru.gpbi.requestprocessing.repository.RequestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FolderService {

		private final FolderRepository folderRepository;
		private final RequestRepository requestRepository;
		private final FolderMapper folderMapper;

		public ResponseFolderDto save(RequestFolderDto folderDto) {
				Folder folder = folderRepository.save(folderMapper.mapToDao(folderDto));
				return folderMapper.mapToDto(folder);
		}

		public List<ResponseFolderDto> findAll() {
				return folderRepository.findAll().stream().map(folderMapper::mapToDto).toList();
		}

		public ResponseFolderDto updateFolder(RequestFolderLinkDto requestFolderLinkDto) {
				checkLimits(requestFolderLinkDto.getRequestIds());
				Folder folder = folderRepository.findById(requestFolderLinkDto.getFolderId())
								.orElseThrow(() -> new EntityNotFoundException(String.format("Folder %s not found",
												requestFolderLinkDto.getFolderId())));
				requestFolderLinkDto.getRequestIds().stream().map(id -> requestRepository.findById(id)
												.orElseThrow(() -> new EntityNotFoundException(String.format("Request %s not found", id))))
								.forEach(request -> folder.getRequests().add(request));
				folderRepository.save(folder);
				return folderMapper.mapToDto(folder);
		}

		private void checkLimits(List<String> requestIds) {
				folderRepository.findAll().stream().flatMap(folder -> folder.getRequests().stream())
								.map(Request::getId).forEach(id -> {
										if (requestIds.contains(id)) {
												throw new LimitExceedingException("Request already contains in other folder");
										}
								});
		}
}
