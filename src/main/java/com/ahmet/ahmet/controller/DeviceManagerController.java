package com.ahmet.ahmet.controller;
import com.ahmet.ahmet.device.Device;
import com.ahmet.ahmet.repository.DeviceRepository;
import com.ahmet.ahmet.service.DeviceManagerService;
import com.ahmet.ahmet.device.GenericResponse;
import com.ahmet.ahmet.vm.DeviceVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeviceManagerController {

    @Autowired
    DeviceManagerService deviceManagerService;


    @PostMapping("/api/1.0/device")
    GenericResponse createDevice(@RequestBody Device device){
        deviceManagerService.save(device);
        return new GenericResponse("Device Saved");

    }
    @PostMapping("/api/1.0/device/saveall")
    public List<Device> saveAllDevice (@RequestBody List<Device> deviceList){
        List<Device> deviceResponse = (List<Device>) deviceManagerService.saveAllDevice( deviceList);
        return  deviceResponse;
    }

    @GetMapping("/api/1.0/device/getAll")
    @ResponseBody
    public List<Device> getAllDevice ( ){
        List<Device> deviceResponse = (List<Device>) deviceManagerService.getAllDevice();
        return deviceResponse;
    }

    @GetMapping("/api/1.0/device/{name}")
    DeviceVm getDeviceByName(@PathVariable String name){
        Device device = deviceManagerService.getByName(name);
        return new DeviceVm(device);
    }



    @DeleteMapping("/api/1.0/device/{id}")
    GenericResponse deleteDevice(@PathVariable String  id){
        deviceManagerService.deleteId(id);
        return new GenericResponse("Device is removed");
    }

   @DeleteMapping("api/1.0/device/delete")
    public void deleteAllDevices() {
        deviceManagerService.deleteAllDevice();
    }





}
