package ru.gpbi.requestprocessing.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResponseRequestDto {

		@Schema(description = "Идентификатор запроса")
		private String id;
		@Schema(description = "Текст запроса")
		private String text;
		@Schema(description = "Дата изменения запроса")
		private Long modifiedDate;
		@Schema(description = "Длина запроса")
		private Long length;
}
