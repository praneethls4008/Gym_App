package com.example.spring1.service;

import com.example.spring1.model.User;
import com.example.spring1.model.Video;
import com.example.spring1.respository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
    public Optional<Video> findByUrl(String url) {
        return videoRepository.findByUrl(url);
    }

    public Optional<Video> findByOwner(String ownerId) {
        return videoRepository.findByOwnerID(ownerId);
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public Page<Video> findByIsPrivate(boolean isPrivate, int offset, int pageSize){
        Page<Video> pagenatedVideo = videoRepository.findByIsPrivate(PageRequest.of(offset,pageSize), isPrivate);
        return pagenatedVideo;
    }

    public Page<Video> findAllVideos(int offset, int pageSize, String sortByField){
        Page<Video> pagenatedVideos = videoRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,sortByField)));
        return pagenatedVideos;
    }

    public Optional<Video> deleteByOwnerID(String ownerID){
        return videoRepository.deleteByOwnerID(ownerID);
    }
}
