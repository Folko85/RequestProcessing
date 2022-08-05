package ru.gpbi.requestprocessing.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Accessors(chain = true)
@Document(collection = "tags")
public class Tag {

		@Id
		private Long id;

		@Field (name = "tag name")
		private String tagName;
}
