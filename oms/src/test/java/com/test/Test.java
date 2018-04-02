package com.test;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String args[]){
        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());

        java.util.Date expiration = new java.util.Date();
        Date expirationDate = null;
        try {
            expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-3-31");
        } catch (Exception e) {
            e.printStackTrace();
        }

        s3client.setRegion(com.amazonaws.regions.Region.getRegion(Regions.CN_NORTH_1));
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest("yanyun", "aaa.png");
        generatePresignedUrlRequest.setMethod(HttpMethod.GET); // Default.
        generatePresignedUrlRequest.setExpiration(expirationDate);

        URL s = s3client.generatePresignedUrl(generatePresignedUrlRequest);
        System.out.println(s);
    }
}
