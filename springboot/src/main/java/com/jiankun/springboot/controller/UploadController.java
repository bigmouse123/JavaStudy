package com.jiankun.springboot.controller;

import com.jiankun.springboot.constant.RedisConstant;
import com.jiankun.springboot.util.AliOSSUtil;
import com.jiankun.springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = uuid + extension;
        //1.本地上传
//        String filePath = "F:\\mypic\\" + newFileName;
//        try {
//            file.transferTo(new File(filePath));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return Result.ok("上传成功", newFileName);

        //2.阿里云上传
        String url = "";
        try {
            url = AliOSSUtil.uploadFile(newFileName, file.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForSet().add(RedisConstant.UPLOAD_IMAGE, url);
        System.out.println("上传图片:" + url);
        return Result.ok("上传成功", url);
    }
}
