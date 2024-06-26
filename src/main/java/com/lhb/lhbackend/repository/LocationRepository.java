package com.lhb.lhbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhb.lhbackend.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByPostId(Long postId);
}