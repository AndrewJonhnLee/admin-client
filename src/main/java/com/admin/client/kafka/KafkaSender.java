package com.admin.client.kafka;

import com.admin.client.model.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(int i) {
//        kafkaTemplate.partitionsFor().
        Message message = new Message();
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        int topicId=i%10;
        int messageId=i%20;
        message.setId(messageId+1);
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("test_par3",topicId, gson.toJson(message));
    }
}
