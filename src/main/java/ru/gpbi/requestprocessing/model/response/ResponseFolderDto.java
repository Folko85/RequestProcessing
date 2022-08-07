package ru.gpbi.requestprocessing.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ResponseFolderDto {

		@Schema(description = "Идентификатор папки")
		private String id;
		@Schema(description = "Имя папки")
		private String folderName;
		@Schema(description = "Список запросов в данной папке")
		private List<ResponseRequestDto> requests;
}
