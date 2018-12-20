package com.example.restTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class postForEntity {

    public static void main(String[] args) {
        String url = "http://prd-message-service.cn-north-1.eb.amazonaws.com.cn/api/message/sms/scheduled";
        Map<String, Object> map = new HashMap();
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //HttpEntity<Object> httpEntity = new HttpEntity(map, headers);
        rest.postForEntity(url, null, null);
        //System.out.println("r=" + ((String)response.getBody()).toString());
    }

    public static void main1(String[] args) {
        String url = "http://t7.common.new.api.dcfservice.com/api/common/v1/captcha/validate";
        Map<String, Object> map = new HashMap();
        map.put("capthcaId", "123333");
        map.put("content", "1");
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> httpEntity = new HttpEntity(map, headers);
        ResponseEntity<Boolean> response = rest.postForEntity(url, httpEntity, Boolean.class, new Object[0]);
        System.out.println("r=" + ((Boolean)response.getBody()).toString());
    }

}
