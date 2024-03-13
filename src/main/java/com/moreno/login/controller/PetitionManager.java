package com.moreno.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moreno.login.models.LoginParams;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class PetitionManager {

    @PostMapping("/login")
    public ResponseEntity<?> login(final HttpServletRequest request, @ModelAttribute LoginParams authentication) {

        return ResponseEntity.ok().body(null);
    }
}
