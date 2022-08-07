package ru.gpbi.requestprocessing.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.gpbi.requestprocessing.entity.Request;

import java.util.List;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {


		String unwind = "{$unwind: '$tags'}";
		String transform = "{$addFields: {object: {$objectToArray: '$$ROOT.tags'}}}";
		String lookup = "{$lookup: {from: 'tags', localField: 'object.1.v', foreignField: '_id', as: 'tag'}}";
		String nextUnwind = " {$unwind: '$tag'}";
		String match = "{ $match: { 'tag.tag_name': ?0} }";
		String group = "{ $group: {_id: '$_id'}}";

		@Aggregation(pipeline = {unwind, transform, lookup, nextUnwind, match, group})
		List<Request> findByTagName(String tagName);
}
