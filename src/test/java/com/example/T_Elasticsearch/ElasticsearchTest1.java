package com.example.T_Elasticsearch;


import com.example.Application;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticsearchTest1 {

    public final static String HOST = "127.0.0.1";

    public final static int PORT = 9300;

    private TransportClient client = null;

    @Before
    public void getConnect() throws UnknownHostException {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT)
        );
        System.out.println("ElasticSearch client info :" + client.toString());
    }

    @After
    public void closeConnect() {
        if (client != null) {
            client.close();
        }
    }


    //https://www.cnblogs.com/sunny1009/articles/7887568.html
    @Test
    public void test1() throws IOException {

        IndexResponse response = client.prepareIndex("msg", "tweet", "1").setSource(XContentFactory.jsonBuilder()
                .startObject().field("userName", "张三")
                .field("sendDate", new Date())
                .field("msg", "你好李四")
                .endObject()).get();

        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());

    }

}














