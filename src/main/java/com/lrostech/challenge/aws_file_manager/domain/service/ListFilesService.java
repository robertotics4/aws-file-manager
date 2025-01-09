package com.lrostech.challenge.aws_file_manager.domain.service;

import com.lrostech.challenge.aws_file_manager.domain.contract.infra.IStorage;
import com.lrostech.challenge.aws_file_manager.domain.contract.service.IListFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListFilesService implements IListFilesService {
    private final IStorage storage;

    @Override
    public List<String> execute() {
        return this.storage.listFiles();
    }
}
