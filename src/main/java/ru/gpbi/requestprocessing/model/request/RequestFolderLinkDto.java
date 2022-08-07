package ru.gpbi.requestprocessing.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class RequestFolderLinkDto {

		@Schema(description = "Идентификатор папки")
		private String folderId;
		@Schema(description = "Идентификатор запроса")
		private List<String> requestIds;
}
