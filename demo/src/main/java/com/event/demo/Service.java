package com.event.demo;

import com.event.demo.entity.Event;
import com.event.demo.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Service {

    @Autowired
    private Repository repository;


    //Creating Event method
    public Event addEvent(Event event) {
        System.out.println("welcome to addEvent method");
        return this.repository.save(event);
    }

    //create list of Event method
    public List<String> eventList() {
        System.out.println("welcome to eventList method");
        Iterable<Event> itr = repository.findAll();
        List<String> eventList = new ArrayList<>();
        for (Event element : itr) {
            eventList.add(element.getEventName());
        }
        CollectionUtils.filter(eventList, Objects::nonNull);

        return eventList;
    }

    //Delete session method
    public void deleteSession(String eventName, String sessionName) {
        System.out.println("Welcome to deleteSession method");
        List<Event> event = repository.getEventsByeventNameRegEx("^"+eventName);

        for (Event element : event) {
            System.out.println(element);

            if (sessionName.equalsIgnoreCase("session_1")) {
                element.setSession_1(null);
                repository.save(element);
            } else if (sessionName.equalsIgnoreCase("session_2")) {
                element.setSession_2(null);
                repository.save(element);
            } else {
                element.setSession_3(null);
                repository.save(element);
            }
        }
    }

    // event and session list method
    public List<Event> list() {
        System.out.println("welcome to list method");
        Iterable<Event> itr = repository.findAll();
        List<Event> eventList = new ArrayList<>();
        for (Event element : itr) {
            eventList.add(element);
        }
        return eventList;
    }

    public void delete(){
        Iterable<Event> itr= repository.findAll();
        repository.deleteAll(itr);
    }
}