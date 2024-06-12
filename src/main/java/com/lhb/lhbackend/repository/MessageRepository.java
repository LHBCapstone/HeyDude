package com.lhb.lhbackend.repository;

import com.lhb.lhbackend.entity.Member;
import com.lhb.lhbackend.entity.Message;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByFromMemberAndToMember(Member fromMember, Member toMember);
}
