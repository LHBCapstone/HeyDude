package com.lhb.lhbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhb.lhbackend.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}