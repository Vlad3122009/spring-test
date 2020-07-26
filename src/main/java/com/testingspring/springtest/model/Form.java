package com.testingspring.springtest.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class Form extends AbstractBaseEntity {

    @NonNull
    @NotNull
    private final LocalDateTime dateTime;

    @NonNull
    @NotBlank
    @Size(min = 5, max = 20)
    private final String topic;

    public Form(Integer id,LocalDateTime dateTime,String topic) {
        super(id);
        this.dateTime = dateTime;
        this.topic = topic;
    }

    public Form(LocalDateTime dateTime,String topic){
        this(null,dateTime,topic);
    }
}
