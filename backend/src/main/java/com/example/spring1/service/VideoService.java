package com.example.spring1.service;

import com.example.spring1.model.Video;
import com.example.spring1.respository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    UserService userService;

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

    public void deleteByOwnerID(String ownerID) throws Exception{
        videoRepository.deleteByOwnerID(ownerID);
        if(videoRepository.findByOwnerID(ownerID).isPresent()){
            throw new Exception("User Videos are not delete. Try again!");
        }
    }

    public void createVideo(Video video) throws Exception{
        if(userService.findById(video.ownerID()).isPresent()){
            videoRepository.save(video);
        }
        else{
            throw new Exception("OwnerID is not found to add video!");
        }
    }

}
