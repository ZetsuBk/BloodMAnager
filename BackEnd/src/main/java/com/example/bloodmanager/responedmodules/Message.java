package com.example.bloodmanager.responedmodules;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String message;

    Message(String message){
        this.message = message;
    }

    public static Message  writeMessage(String message){
            return new Message(message);
    }
}
