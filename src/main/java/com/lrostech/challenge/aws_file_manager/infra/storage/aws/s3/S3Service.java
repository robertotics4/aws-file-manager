package com.lrostech.challenge.aws_file_manager.infra.storage.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.lrostech.challenge.aws_file_manager.domain.contract.infra.IStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Service implements IStorage {
    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public boolean uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();

            amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), null)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

            return true;
        } catch (IOException e) {
            log.error("Error uploading file to S3", e);
            return false;
        }
    }

    @Override
    public List<String> listFiles() {
        return amazonS3.listObjects(bucketName).getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .toList();
    }

    @Override
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
        log.info("File deleted successfully: {}", fileName);
    }
}
