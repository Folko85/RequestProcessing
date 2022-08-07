package ru.gpbi.requestprocessing.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class RequestTagLinkDto {

		@Schema(description = "Идентификатор запроса")
		private String requestId;
		@Schema(description = "Идентификатор тега")
		private List<String> tagIds;
}
