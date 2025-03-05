package com.jiankun.springboot.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/4 20:30
 */
@Data
public class OperLog {
    private Integer id;
    private String module;
    private String logType;
    private Integer adminId;
    private String adminName;
    private String requestMethod;
    private String requestUri;
    private String requestParams;
    private String responseParams;
    private String requestIp;
    private String serverAddress;
    private Integer exception;
    private String exceptionMsg;
    private Date startTime;
    private Date endTime;
    private Long executeTime;
    private String userAgent;
    private String deviceName;
    private String browserName;
    private Integer deleted;
    private Date createTime;
    private Date updateTime;

}
