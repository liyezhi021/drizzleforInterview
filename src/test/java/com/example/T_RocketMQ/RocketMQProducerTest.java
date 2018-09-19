package com.example.T_RocketMQ;

import com.example.RocketMQ.RocketMQProducer;
import org.apache.rocketmq.common.message.Message;

public class RocketMQProducerTest {

    private static String mqNameServer = "172.17.0.1:9876";

    private static String mqTopics = "MQ_MSG_TOPICS_TEST";

    public static void main(String[] args){

        String producerMqGroupName = "CONSUMER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();

        for(int i = 0; i < 5; i++){
            Message message = new Message();
            message.setBody(("I send message to RocketMQ To Test" + i).getBytes());
            mqProducer.send(message);
        }

    }

}