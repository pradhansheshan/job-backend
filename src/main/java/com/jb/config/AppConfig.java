package com.jb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobServiceClient;
import com.jb.client.AzureImageStorageClient;
import com.jb.client.ImageStorageClient;

@Configuration
public class AppConfig {

    // @Bean
    // public ImageStorageClient imageStorageClient(BlobServiceClient blobServiceClient) {
    //     return new AzureImageStorageClient(blobServiceClient);
    // }
}
