package ru.gpbi.requestprocessing.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestRequestDto {

		@Schema(description = "Текст запроса")
		private String text;
		@Schema(description = "Дата изменения запроса")
		private Long modifiedDate;
		@Schema(description = "Длина запроса")
		private Long length;

}
