package com.event.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class Session implements Serializable {

    @Serial
    static final long serialVersionUID = 1L;

    private String language;
    private String description;
    private String date;
    private URL url;
}
