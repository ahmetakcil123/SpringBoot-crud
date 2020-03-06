package com.ahmet.ahmet.device;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;


@Data
public class Device {
    @Id
    private String id;
    private String name;
    private String description;
    private String adress;
    private String online;
    private String type;
    private String lastMessageTime;
    private String lastKnowLocation;
}
