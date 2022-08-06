package ru.gpbi.requestprocessing.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResponseFolderDto {

		@Schema(description = "Идентификатор папки")
		private String id;
		@Schema(description = "Имя папки")
		private String folderName;
}
