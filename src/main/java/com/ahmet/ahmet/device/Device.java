package com.ahmet.ahmet.device;

import lombok.Data;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class Device {

    @Id
    private String id;

    @NotNull(message = "Name may be not null!!!")
    @Size(min = 4,max = 20,message = "Size must be between min 4 and max 20 characters!")

    private String name;

    @NotNull(message = "Description may be not null!!!")
    @Size(min = 4,max=100,message ="Size must be between min 4 and max 100 characters!" )
    private String description;

    @NotNull(message = "Adress may be not null!!!")
    @Size(min = 4, max = 250,message = "Size must be between min 4 and max 250 characters!")
    private String adress;

    private String online;

    private String type;

    @NotNull(message = "Last message time may be not null!!!")
    private String lastMessageTime;

    @NotNull(message = "Last know location may be noy null!!!")
    private String lastKnowLocation;
}
