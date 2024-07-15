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

import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
    public Optional<Video> findByUrl(String url) {
        return videoRepository.findByUrl(url);
    }

    public Optional<Video> findByOwner(String ownerId) {
        return videoRepository.findByOwner(ownerId);
    }

    public Page<Video> findByIsPrivate(boolean isPrivate, int offset, int pageSize){
        Page<Video> pagenatedVideo = videoRepository.findByIsPrivate(PageRequest.of(offset,pageSize), isPrivate);
        return pagenatedVideo;
    }

    public Page<Video> findAllVideos(int offset, int pageSize, String sortByField){
        Page<Video> pagenatedVideos = videoRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,sortByField)));
        return pagenatedVideos;
    }
}
