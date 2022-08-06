package ru.gpbi.requestprocessing.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestFolderDto {

		@Schema(description = "Имя папки")
		private String folderName;
}
