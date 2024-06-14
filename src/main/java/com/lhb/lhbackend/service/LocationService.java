package com.lhb.lhbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.lhbackend.entity.Location;
import com.lhb.lhbackend.repository.LocationRepository;
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocationsByPostId(Long postId) {
        return locationRepository.findByPostId(postId);
    }
}