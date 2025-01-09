package com.lrostech.challenge.aws_file_manager.domain.service;

import com.lrostech.challenge.aws_file_manager.domain.contract.infra.IStorage;
import com.lrostech.challenge.aws_file_manager.domain.contract.service.IUploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadFileService implements IUploadFileService {
    private final IStorage storage;

    @Override
    public boolean execute(MultipartFile file) {
        return this.storage.uploadFile(file);
    }
}
