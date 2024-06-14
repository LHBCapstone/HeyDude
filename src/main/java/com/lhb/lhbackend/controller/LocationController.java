package com.lhb.lhbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhb.lhbackend.entity.Location;
import com.lhb.lhbackend.service.LocationService;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/posts/{postId}/locations")
    public ResponseEntity<List<Location>> getLocationsByPostId(@PathVariable("postId") Long postId) {
        List<Location> locations = locationService.getLocationsByPostId(postId);
        return ResponseEntity.ok(locations);
    }
}