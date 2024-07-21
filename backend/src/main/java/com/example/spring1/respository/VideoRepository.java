package com.example.spring1.respository;

import com.example.spring1.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VideoRepository extends MongoRepository<Video,String> {
    Optional<Video> findByUrl(String url);
    Optional<Video> findByOwnerID(String ownerID);
    Optional<Video> deleteByOwnerID(String ownerID);
    //select * from Post where user=user and status=status order by createdAt desc
    //findByUserAndStatusOrderByCreatedAtDesc(PageRequest pageRequest,User user, boolean status);
    Page<Video> findByIsPrivate(PageRequest pageRequest, boolean isPrivate);
    }

