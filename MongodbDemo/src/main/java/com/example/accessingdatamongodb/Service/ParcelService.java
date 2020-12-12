package com.example.accessingdatamongodb.Service;

import com.example.accessingdatamongodb.Entity.Parcel;
import com.example.accessingdatamongodb.Repository.ParcelRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {
    @Autowired
    ParcelRepository parcelRepository;

    public List<Parcel> findAll() {
        return parcelRepository.findAll();
    }


    public Long addOne(Parcel parcel) {
        // 做数据验证
        Preconditions.checkNotNull(parcel, "未输入包裹信息");
        parcelRepository.insert(parcel);
        return parcel.getId();
    }

    public void update(Parcel parcel) {
        Preconditions.checkNotNull(parcel, "未输入包裹信息");
        parcelRepository.save(parcel);
    }

    public void delete(Long id) {
        Preconditions.checkNotNull(id, "未输入包裹id");
        parcelRepository.deleteById(id);
    }
}
