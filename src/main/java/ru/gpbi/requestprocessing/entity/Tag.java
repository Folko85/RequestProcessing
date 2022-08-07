package ru.gpbi.requestprocessing.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "tags")
public class Tag {

		@Id
		private String id;

		@Field(name = "tag_name")
		private String tagName;
}
