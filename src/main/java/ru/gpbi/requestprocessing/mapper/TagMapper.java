package ru.gpbi.requestprocessing.mapper;

import org.mapstruct.Mapper;
import ru.gpbi.requestprocessing.entity.Tag;
import ru.gpbi.requestprocessing.model.request.RequestTagDto;
import ru.gpbi.requestprocessing.model.response.ResponseTagDto;

@Mapper
public interface TagMapper {

		ResponseTagDto mapToDto(Tag tag);

		Tag mapToDao(RequestTagDto tagDto);

}

