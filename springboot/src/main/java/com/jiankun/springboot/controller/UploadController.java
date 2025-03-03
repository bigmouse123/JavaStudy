package com.jiankun.springboot.controller;

import com.jiankun.springboot.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/3 16:01
 */
@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = uuid + extension;
        String filePath = "F:\\mypic\\" + newFileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.ok("上传成功", newFileName);
    }
}
