package com.event.demo;

import com.event.demo.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Repository extends MongoRepository<Event,String> {
    @Query("{ eventName : { $regex : ?0 } }")
    List<Event> getEventsByeventNameRegEx(String eventName);

    @Query("{$unset: {fieldName: ''}}")
    void deleteField(String documentId, String fieldName);

}
