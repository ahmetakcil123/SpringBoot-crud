package com.ahmet.ahmet.repository;

import com.ahmet.ahmet.device.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

    Device findByName(String name);

    void deleteById(String id);

   //List<Device> deleteAll ( );



//mongorepository kullanıcaz.
}
