package ru.gpbi.requestprocessing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.gpbi.requestprocessing.entity.Tag;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
}
