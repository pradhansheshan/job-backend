package com.jb.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jb.client.ImageStorageClient;

@CrossOrigin(origins = "*")
@RestController
public class FormController {

    @Autowired
    private ImageStorageClient imageStorageClient;

    @PostMapping("/submit")
    public String uploadImage(
            @RequestParam MultipartFile file,
            @RequestParam String username,
            @RequestParam String mobileNumber,
            @RequestParam String address,
            @RequestParam String jobRole) throws IOException {

        // Sanitize characters for filename safety
        String safeUsername = username.replaceAll("[^a-zA-Z0-9]", "_");
        String safeMobile = mobileNumber.replaceAll("[^0-9]", "");
        String safeAddress = address.replaceAll("[^a-zA-Z0-9]", "_");

        String imageName = safeUsername + "_" + safeMobile + "_" + safeAddress + "_" + jobRole;

        try (InputStream inputStream = file.getInputStream()) {
            imageStorageClient.uploadImage(imageName, inputStream, file.getSize(), safeUsername);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace(); // Log error in real use
            return "Upload failed: " + e.getMessage();
        }
    }

    @PostMapping("/test")
    public String testMethod() {
        return "Hello from test method 2nd!";
    }   

    
    
}
