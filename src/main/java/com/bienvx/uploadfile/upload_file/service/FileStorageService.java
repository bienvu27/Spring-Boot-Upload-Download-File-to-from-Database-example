package com.bienvx.uploadfile.upload_file.service;

import com.bienvx.uploadfile.upload_file.model.FileDB;
import com.bienvx.uploadfile.upload_file.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;


@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getContentType());
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFile() {
        return fileDBRepository.findAll().stream();
    }
}
