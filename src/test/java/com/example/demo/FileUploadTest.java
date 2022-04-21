package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@SpringBootTest
public class FileUploadTest {

    private RestTemplate restTemplate;

    @Autowired
    public FileUploadTest(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Test
    void uploadFile() throws Exception{

        int DEFAULT_BUFFER_SIZE = 8192;

        //接受檔案上傳的API地址
        String url = "http://localhost:8081/minio/uploadFile";

        //資料所在路徑
        String filePath = "src/test/java/com/wistron/vda/training/controller/MinIOTest.java";
       // FileSystemResource resource = new FileSystemResource(new File(filePath));
        InputStream inputStream = new FileInputStream(filePath);

        File file = File.createTempFile("temp2",".java");

        FileOutputStream outputStream = new FileOutputStream(file, false);
        int read;
        byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }


        FileSystemResource resource = new FileSystemResource(file);


        // 設定http head
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        //裝配資料
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("file", resource);

        //封裝HttpEntity
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap,headers);

        // 發送請求
        ResponseEntity<String> response = restTemplate.exchange(url,
                    HttpMethod.POST, requestEntity, String.class);

        System.out.println("=================> " + response.getBody());
        file.deleteOnExit();

    }
}
