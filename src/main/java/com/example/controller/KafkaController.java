package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("send")
    public String sendKafka(HttpServletRequest request, HttpServletResponse response){
        try{
            String message = request.getParameter("message");
            log.info("kafka message :{}", message);
            kafkaTemplate.send("test", "key", message);
            log.info("send Ok");
            return "success";
        }catch (Exception e){
            return "send fail";
        }
    }

}
