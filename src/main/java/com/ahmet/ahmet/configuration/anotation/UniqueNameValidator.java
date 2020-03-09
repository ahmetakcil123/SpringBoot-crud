package com.ahmet.ahmet.configuration.anotation;

import com.ahmet.ahmet.device.Device;
import com.ahmet.ahmet.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String>{

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Device inDB = deviceRepository.findByName(value);
        if(inDB == null) {
            return true;
        }
        return false;
    }
}
