package com.admin.client.kafka;

import com.admin.client.model.Account;
import com.admin.client.model.Message;
import com.admin.client.service.AccountService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {

    @Autowired
    private AccountService accountService;

    private Gson gson = new GsonBuilder().create();

//单个topic,多个分区
    @KafkaListener(topics = {"test_par3"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            Message message1 = gson.fromJson("" + message, Message.class);

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
            save(message1.getId());
        }

    }

    private void save(int id) {

        Account account = accountService.find(id);
//        Account account=new Account();
//        account.setId(id);
//        account.setMoney(new Double(0));
        Double money = account.getMoney() + 1;

        accountService.update(account.getId(), money);

    }

}
//10.36.2
//06.04.7