package cn.ckeen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description：TODO
 * @author: CKeen
 * @date: 2022/5/6 12:48 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGrpcProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudGrpcProviderApp.class, args);
    }
}
