package com.lhb.lhbackend.repository;

import com.lhb.lhbackend.entity.Guide;
import com.lhb.lhbackend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
}
