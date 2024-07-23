package com.example.spring1.controller;

import com.example.spring1.model.Video;
import com.example.spring1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/")
    public ResponseEntity<?> getVideo(){
        return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newVideo(@RequestBody Video video){
        try{
            videoService.createVideo(video);
            return new ResponseEntity<>("Video added successfully!", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
