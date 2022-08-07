package ru.gpbi.requestprocessing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.gpbi.requestprocessing.entity.Folder;

@Repository
public interface FolderRepository extends MongoRepository<Folder, String> {
}
