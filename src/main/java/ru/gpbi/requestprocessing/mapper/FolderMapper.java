package ru.gpbi.requestprocessing.mapper;

import org.mapstruct.Mapper;
import ru.gpbi.requestprocessing.entity.Folder;
import ru.gpbi.requestprocessing.model.request.RequestFolderDto;
import ru.gpbi.requestprocessing.model.response.ResponseFolderDto;

@Mapper
public interface FolderMapper {

		ResponseFolderDto mapToDto(Folder folder);

		Folder mapToDao(RequestFolderDto folderDto);

}

