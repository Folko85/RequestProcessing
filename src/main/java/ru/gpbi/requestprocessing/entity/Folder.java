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
@Document(collection = "folders")
public class Folder {

		@Id
		private Long id;

		@Field(name = "folder name")
		private String folderName;

		@DBRef
		private List<Request> requests = new ArrayList<>();
}
