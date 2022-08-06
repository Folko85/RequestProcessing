package ru.gpbi.requestprocessing.model.response;

import lombok.Data;

@Data
public class ResponseRequestDto {

		private String id;
		private String text;
		private Long modifiedDate;
		private Long length;
}
