package ru.gpbi.requestprocessing.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
public class ResponseError {

		@Schema (description = "Сообщение об ошибке")
		private String message;
}
