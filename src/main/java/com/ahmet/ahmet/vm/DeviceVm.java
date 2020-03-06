package com.ahmet.ahmet.vm;


import com.ahmet.ahmet.device.Device;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@Data
@NoArgsConstructor
public class DeviceVm {

    private String id;
    private String name;
    private String description;
    private String adress;
    private String online;
    private String type;
    private String lastMessageTime;
    private String lastKnowLocation;


    public DeviceVm(Device device) {
      this.setId(device.getId());
      this.setName(device.getName());
      this.setDescription(device.getDescription());
      this.setAdress(device.getAdress());
      this.setOnline(device.getOnline());
      this.setType(device.getType());
      this.setLastMessageTime(device.getLastMessageTime());
      this.setLastKnowLocation(device.getLastKnowLocation());
    }
}
