package cn.ckeen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description：TODO
 * @author: CKeen
 * @date: 2022/5/6 1:33 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGrpcConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudGrpcConsumerApp.class, args);
    }
}
