package com.example.spring1.controller;

import com.example.spring1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/")
    public ResponseEntity<?> getVideo(){
        return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
    }
}
