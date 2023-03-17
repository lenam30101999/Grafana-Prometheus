package com.example.grafanaprometheus.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class PrometheusController {

    @GetMapping("/testApi")
    public ResponseEntity<String> createLogs() {
        log.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }

    @GetMapping("/testApi1")
    public ResponseEntity<String> createLogs1() {
        log.error("Just checking error");
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
