package com.jb.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;

@Service
public class AzureImageStorageClient implements ImageStorageClient {

    private final BlobServiceClient blobServiceClient;

    public AzureImageStorageClient (BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    @Override
    public String uploadImage(String originalImageName, InputStream data, long length, String userName) throws IOException {

        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("job-image-container");

        // String newImageName = UUID.randomUUID().toString() + originalImageName.substring(originalImageName.lastIndexOf('.'));

        

        BlobClient blobClient = blobContainerClient.getBlobClient(originalImageName);

        blobClient.upload(data, length, true);

        return blobClient.getBlobUrl();
    }
    
    
}
