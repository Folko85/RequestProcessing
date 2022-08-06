package ru.gpbi.requestprocessing.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResponseTagDto {

		@Schema(description = "Идентификатор тэга")
		private String id;
		@Schema(description = "Имя тэга")
		private String tagName;
}
