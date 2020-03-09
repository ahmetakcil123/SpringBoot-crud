package com.ahmet.ahmet.controller;
import com.ahmet.ahmet.device.Device;
import com.ahmet.ahmet.error.ApiError;
import com.ahmet.ahmet.service.DeviceManagerService;
import com.ahmet.ahmet.device.GenericResponse;
import com.ahmet.ahmet.vm.DeviceVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeviceManagerController {

    @Autowired
    DeviceManagerService deviceManagerService;



    @PostMapping("/api/1.0/device")
    GenericResponse createDevice(@Valid  @RequestBody Device device){


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



    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError(400,"validation error",request.getServletPath());


        //hata mesajlarını map halinde göstermek için ayarlandı.
        BindingResult result = exception.getBindingResult();
        Map<String , String > validationErrors = new HashMap<>();

        for(FieldError fieldError: result.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationErrors);
        return apiError;
        //Validation yani değer gşirmedğimiz zamanlarda alınan hataları düzenli göstermek için yapıldı. FArkı görmek
        //istediğin zaman yorum satırı yap ve postman de kontrol et.
    }




}
