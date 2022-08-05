package ru.gpbi.requestprocessing.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Document(collection = "requests")
public class Request {

		@Id
		private Long id;

		private String text;

		@Field(name = "modified date")
		private Long modifiedDate;

		private Long length;

		@DBRef
		private List<Tag> tags = new ArrayList<>();

}