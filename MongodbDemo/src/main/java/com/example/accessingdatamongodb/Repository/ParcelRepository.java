package com.example.accessingdatamongodb.Repository;

import com.example.accessingdatamongodb.Entity.Parcel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParcelRepository extends MongoRepository<Parcel, String> {

    void deleteById(Long id);
}
