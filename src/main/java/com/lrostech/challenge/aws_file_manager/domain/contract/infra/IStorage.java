package com.lrostech.challenge.aws_file_manager.domain.contract.infra;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IStorage {
    boolean uploadFile(MultipartFile file);

    List<String> listFiles();

    void deleteFile(String fileName);
}
