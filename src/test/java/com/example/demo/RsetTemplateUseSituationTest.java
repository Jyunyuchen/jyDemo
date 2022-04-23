package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.InputStream;
import java.net.URI;

@SpringBootTest
public class RsetTemplateUseSituationTest {

    private RestTemplate restTemplate;

    @Autowired
    public RsetTemplateUseSituationTest(RestTemplateBuilder builder) {

        this.restTemplate = builder.build();
    }

    /*
       透過連結下載檔案
     */
    @Test
    void test01() throws Exception{
        String presignedUrl = "https://feptest.blob.core.windows.net/fep/tdea/blob_20220419094841.txt?sv=2020-02-10&st=2022-04-19T03%3A19%3A41Z&se=2024-03-19T03%3A20%3A41Z&sr=b&sp=r&sig=VBJq7QrYUOb%2Bzxa53%2F9WVM6DerCCOugOJulBlMBXpqg%3D";
        URI sourceUri = URI.create(presignedUrl);
        System.out.println("presignedUrl=================>" + presignedUrl);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("accept", "*/*");
//        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Resource> responseEntity =
                responseEntity = restTemplate.exchange(sourceUri, HttpMethod.GET, null, Resource.class);

        InputStream responseInputStream = null;
//        String fileName = responseEntity.getBody().getFilename();
//        String fileName = responseEntity.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION).get(0);
        String ContentType = responseEntity.getHeaders().getContentType().toString();
        // File file = responseEntity.getBody().getFile();
        System.out.println("ContentType=========> " + ContentType);
        //System.out.println("fileName=========> " + responseEntity.getBody().getFilename());

        File targetFile = new File("D:\\test\\temp.txt");
        FileUtils.copyInputStreamToFile(responseEntity.getBody().getInputStream(), targetFile);

    }

    /**
     * 發送json給restAPI
     */
    @Test
    void test02(){
        // 請求路徑
        String url = "http://localhost:8081/minio/receivePresignedUrlStore";

        //建立json格式的資料
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("presignedUrl", "https://feptest.blob.core.windows.net/fep/tdea/Paloalto%20SSLVPN-Windows_20220419141746.pdf?sv=2020-02-10&st=2022-04-19T06%3A50%3A27Z&se=2024-03-19T06%3A51%3A27Z&sr=b&sp=r&sig=by6RKDLQRFIUwLL6ZTatlXe8SFznqLzkxZh5pApeIH0%3D");
//        jsonObject.put("fileNmae", "Paloalto_SSLVPN-Windows_20220419141746.pdf");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("presignedUrl", "https://feptest.blob.core.windows.net/fep/tdea/Paloalto%20SSLVPN-Windows_20220419141746.pdf?sv=2020-02-10&st=2022-04-19T06%3A50%3A27Z&se=2024-03-19T06%3A51%3A27Z&sr=b&sp=r&sig=by6RKDLQRFIUwLL6ZTatlXe8SFznqLzkxZh5pApeIH0%3D");
        objectNode.put("fileNmae", "Paloalto_SSLVPN-Windows_20220419141746.pdf");

        System.out.println(objectNode.toPrettyString());

        // 請求header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 裝配請求
//        HttpEntity<String> requestEntity = new HttpEntity<>(jsonObject.toString(), headers);

        // 發送請求
//        ResponseEntity<String> responseEntity =
//         restTemplate.postForEntity(url, requestEntity, String.class);

//        System.out.println("Body===============> " + responseEntity.getBody().toString());
//        System.out.println("ContentType===============> " + responseEntity.getHeaders().get(HttpHeaders.CONTENT_TYPE).get(0));
    }

    /**
     * restTemplate使用get帶Query Params用法
     */
    @Test
    void test03(){
        String url = "http://localhost:8081/minio/getPresignedUrlToDownload?bucketName={bucketName}&objectName={objectName}";
        // 設定http head
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //裝配資料
        /*MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("bucketName", "test");
        bodyMap.add("objectName", "go.java");*/

        Object[] params = {"test", "go.java"};

        //封裝HttpEntity
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url,
                    HttpMethod.GET, requestEntity, String.class, params);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void test04(){
        System.out.println("目前的Proxy Host:" + System.getProperty("http.proxyHost"));
        System.out.println("目前的Proxy Port:" + System.getProperty("http.proxyPort"));

        String myIpUrl = "https://myip.briian.com/";
        ResponseEntity<String> response = restTemplate.exchange(myIpUrl,
                HttpMethod.GET, null, String.class);
        System.out.println("==============>" + response.getBody());
    }
}
