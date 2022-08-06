package ru.gpbi.requestprocessing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gpbi.requestprocessing.entity.Folder;
import ru.gpbi.requestprocessing.mapper.FolderMapper;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;
import ru.gpbi.requestprocessing.repository.FolderRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FolderService {

		private final FolderRepository folderRepository;
		private final FolderMapper folderMapper;

		public ResponseFolderDto save(RequestFolderDto folderDto) {
				Folder folder = folderRepository.save(folderMapper.mapToDao(folderDto));
				return folderMapper.mapToDto(folder);
		}

		public List<ResponseFolderDto> findAll() {
				return folderRepository.findAll().stream().map(folderMapper::mapToDto).toList();
		}
}
