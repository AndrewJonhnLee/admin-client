package com.admin.client;

import com.admin.client.kafka.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class ClientApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(ClientApplication.class, args);

		KafkaSender sender = context.getBean(KafkaSender.class);

		Date startDate=new Date();
		long start=startDate.getTime();
//
//		for (int i = 0; i < 100; i++) {
//			//调用消息发送类中的消息发送方法
//			sender.send(i);
//		}
		Date stopDate=new Date();
		long stop=stopDate.getTime();
		log.info("开始时间====:"+startDate);
		log.info("结束时间====:"+stopDate);
		long spend=stop-start;

		log.info("用时====:"+spend);
	}


	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {

			}
		};

	}

}
