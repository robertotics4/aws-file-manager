package com.lrostech.challenge.aws_file_manager.presentation.controller;

import com.lrostech.challenge.aws_file_manager.domain.contract.service.IDeleteFileService;
import com.lrostech.challenge.aws_file_manager.domain.contract.service.IListFilesService;
import com.lrostech.challenge.aws_file_manager.domain.contract.service.IUploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileController {
    private final IUploadFileService uploadFileService;
    private final IListFilesService listFilesService;
    private final IDeleteFileService deleteFileService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        this.uploadFileService.execute(file);
    }

    @GetMapping
    public ResponseEntity<List<String>> listFiles() {
        List<String> files = this.listFilesService.execute();
        return ResponseEntity.ok(files);
    }

    @DeleteMapping("/{fileName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        this.deleteFileService.execute(fileName);
        return ResponseEntity.noContent().build();
    }
}
