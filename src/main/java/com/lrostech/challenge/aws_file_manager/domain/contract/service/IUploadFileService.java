package com.lrostech.challenge.aws_file_manager.domain.contract.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
    boolean execute(MultipartFile file);
}
