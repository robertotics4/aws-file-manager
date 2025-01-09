package com.lrostech.challenge.aws_file_manager.domain.service;

import com.lrostech.challenge.aws_file_manager.domain.contract.infra.IStorage;
import com.lrostech.challenge.aws_file_manager.domain.contract.service.IDeleteFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteFileService implements IDeleteFileService {
    private final IStorage storage;

    @Override
    public void deleteFile(String fileName) {
        this.storage.deleteFile(fileName);
    }
}
