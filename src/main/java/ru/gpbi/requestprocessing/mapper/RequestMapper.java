package ru.gpbi.requestprocessing.mapper;

import org.mapstruct.Mapper;
import ru.gpbi.requestprocessing.entity.Request;
import ru.gpbi.requestprocessing.model.request.RequestRequestDto;
import ru.gpbi.requestprocessing.model.response.ResponseRequestDto;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface RequestMapper {

		ResponseRequestDto mapToDto(Request request);

		Request mapToDao(RequestRequestDto requestDto);

}

