package ru.gpbi.requestprocessing.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestTagDto {

		@Schema(description = "Имя тэга")
		private String tagName;
}
