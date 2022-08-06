package ru.gpbi.requestprocessing.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "requests")
public class Request {

		@Id
		private String id;

		private String text;

		@Field(name = "modified date")
		private Long modifiedDate;

		private Long length;

		@DBRef
		private List<Tag> tags = new ArrayList<>();

}
