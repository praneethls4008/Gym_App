package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/{u}/{x}/")
public class RestControllerMain {
	@GetMapping
	public String getParam(@PathVariable("u") String u,@PathVariable("x") String x,@RequestParam(required=false) String iv, @RequestParam(required=false) String id) {
		return "x:"+x+" u:"+u+" iv "+iv+" id "+id;
	}
}
