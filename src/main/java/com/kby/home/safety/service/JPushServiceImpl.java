package com.kby.home.safety.service;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.kby.home.safety.model.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangpeng12 on 2017/5/21.
 */
@Component
public class JPushServiceImpl {
    @Autowired
    JPushClient jPushClient;
    private static final Logger logger = LoggerFactory.getLogger(JPushServiceImpl.class);

    public boolean pushAlert(Alert alert){
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId(alert.getId().toString()))
                .setNotification(Notification.android(alert.getContent(), "报警", null))
                .build();
        try {
            PushResult result = jPushClient.sendPush(pushPayload);
            return  result.isResultOK();
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error("Connection error, should retry later", e);
            return false;
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error("Should review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
            return false;
        }
    }




}
