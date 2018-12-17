package com.example.T_RocketMQ;

import com.example.rocketMQ.RocketMQProducer;
import org.apache.rocketmq.common.message.Message;

public class RocketMQProducerTest {

    private static String mqNameServer = "127.0.0.1:9876";

    private static String mqTopics = "MQ_MSG_TOPICS_TEST";

    public static void main(String[] args) {

        String producerMqGroupName = "CONSUMER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();

        for (int i = 0; i < 5; i++) {
            Message message = new Message();
            message.setBody(("I send message to rocketMQ To Test" + i).getBytes());
            mqProducer.send(message);
        }

    }

}
