package com.example.spring1.respository;

import com.example.spring1.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends MongoRepository<Video,String> {
    Optional<Video> findByUrl(String s);
    Optional<Video> findByOwner(String s);
    //select * from Post where user=user and status=status order by createdAt desc
    //findByUserAndStatusOrderByCreatedAtDesc(PageRequest pageRequest,User user, boolean status);
    Page<Video> findByIsPrivate(PageRequest pageRequest, boolean isPrivate);
    }
