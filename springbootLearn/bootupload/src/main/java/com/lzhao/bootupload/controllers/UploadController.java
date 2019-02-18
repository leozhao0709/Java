package com.lzhao.bootupload.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
class UploadController {

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam(name = "file")MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();

        String path = this.uploadFolder;

        if (!file.isEmpty()) {
        String originalFilename = file.getOriginalFilename();

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        String uploadDirPath = path + File.separator + year + File.separator + month + File.separator + day ;
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        if ("image/png".equals(file.getContentType())) {
            String uploadFileName = UUID.randomUUID() + originalFilename;
            File uploadFile = new File(uploadDirPath, uploadFileName);
            file.transferTo(uploadFile);
        } else {
            map.put("msg", "Please upload a png file");
            return map;
        }
    } else {
        map.put("msg", "You need to select a file to upload");
        return map;
    }

        map.put("result", "success");
        return map;
    }
}
