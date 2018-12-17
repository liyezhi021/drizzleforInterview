package com.example.T_RocketMQ;

import com.example.rocketMQ.RocketMQConsumer;
import com.example.rocketMQ.RocketMQListener;

public class RocketMQConsumerTest {

    private static String nameServerAdd = "127.0.0.1:9876";

    private static String mqTopics = "MQ_MSG_TOPICS_TEST";

    public static void main(String[] args) {

        String consumerMqGroupName = "CONSUMER-MQ-GROUP";

        RocketMQListener mqListener = new RocketMQListener();
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, nameServerAdd,
                consumerMqGroupName, mqTopics);
        mqConsumer.init();

        try {
            Thread.sleep(1000 * 60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
