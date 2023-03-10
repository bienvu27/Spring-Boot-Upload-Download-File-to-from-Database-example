package com.bienvx.uploadfile.upload_file.repository;

import com.bienvx.uploadfile.upload_file.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
