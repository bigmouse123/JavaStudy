package com.jiankun.springboot.job;

import com.jiankun.springboot.constant.RedisConstant;
import com.jiankun.springboot.util.AliOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/6 15:36
 */
@Configuration
public class DeleteImageJob {
    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 */2 * * * *")
    public void deleteImage() {
        System.out.println("delete image");
        Set<String> set = redisTemplate.opsForSet().difference(RedisConstant.UPLOAD_IMAGE, RedisConstant.UPLOAD_IMAGE_TO_DB);
        if (!CollectionUtils.isEmpty(set)) {
            for (String image : set) {
                AliOSSUtil.deleteFile(image);
                System.out.println("删除:" + image);
            }
            redisTemplate.delete(RedisConstant.UPLOAD_IMAGE);
            redisTemplate.delete(RedisConstant.UPLOAD_IMAGE_TO_DB);
        }
    }

}
