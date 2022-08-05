package ru.gpbi.requestprocessing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.gpbi.requestprocessing.entity.Request;

@Repository
public interface RequestRepository extends MongoRepository<Request, Long> {
}
