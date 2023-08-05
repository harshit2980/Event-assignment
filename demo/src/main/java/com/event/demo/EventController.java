package com.event.demo;

import com.event.demo.entity.Event;
import com.event.demo.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private Service service;

    //Get List of all Event
    @GetMapping("/event/list")
    public ResponseEntity<Object> getList() {
        List<String> listResponse= service.eventList();
        if(listResponse.size()==0)
            return ResponseEntity.ok().body("No Event Found");

        return ResponseEntity.of(Optional.of(listResponse));

    }

    //Create Event along with session
    @PostMapping("/event")
    public ResponseEntity<Object> addEvent(@RequestBody Event event) {

        try {
            Event eventResponse = service.addEvent(event);
            System.out.println("hello");
            return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Delete given Session
    @DeleteMapping("/event/delete/{eName}/{sName}")
    public ResponseEntity<Object> session(@PathVariable String eName,
                                          @PathVariable String sName)
    {
        service.deleteSession(eName,sName);

        return ResponseEntity.ok().body(sName+" deleted");
    }


    // list of event and session
    @GetMapping("/event/session/list")
    public ResponseEntity<Object> getEventList() {
        List<Event> listResponse= service.list();
        if(listResponse.size()==0)
            return ResponseEntity.ok().body("No Event Found");

        return ResponseEntity.of(Optional.of(listResponse));

    }

    @DeleteMapping("/event/deleteAll")
    public ResponseEntity<Object> deleteAll()
    {
        service.delete();
        return ResponseEntity.ok().body("All deleted");
    }
}
