package com.ahmet.ahmet.service;
import com.ahmet.ahmet.device.Device;
import com.ahmet.ahmet.repository.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DeviceManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceManagerService.class);

    @Autowired
    DeviceRepository deviceRepository;



    public Device save(Device device)
    {
        LOGGER.info("Device saved test git => {}", device);
        return deviceRepository.save(device);
    }

   @Transactional
   public List<Device> saveAllDevice(List<Device> deviceList){
       LOGGER.info("saveAll win => {}", deviceList);
        List<Device>  response = (List<Device>) deviceRepository.saveAll(deviceList);
        return response;
   }

    @Transactional
    public List<Device> getAllDevice() {
        LOGGER.info("getall win => {}");
        List<Device> response = (List<Device>) deviceRepository.findAll();
        return response;
    }

    public Device getByName(String name){
        LOGGER.info("Device get  => {}", name);
        Device inDb = deviceRepository.findByName(name);
        return inDb;
    }


    public void deleteId(String id) {
        LOGGER.info("Device is removed  => {}", id);
        deviceRepository.deleteById(id);

    }

   public void deleteAllDevice() {
       LOGGER.info("deleteall win => {}");
       deviceRepository.deleteAll();
       List<Device> list = deviceRepository.findAll();
       if (list.size() == 0) {
           ResponseEntity.ok("başarılı");
       }
       else{
           ResponseEntity.badRequest().body("silinemedi");
       }

   }




}



