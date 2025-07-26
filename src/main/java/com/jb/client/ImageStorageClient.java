package com.jb.client;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public interface ImageStorageClient {
    
    String uploadImage(String originalImageName, InputStream data, long length, String userName) throws IOException;
}
