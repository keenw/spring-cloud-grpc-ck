package cn.ckeen.service;

import cn.ckeen.lib.grpc.test.HelloReply;
import cn.ckeen.lib.grpc.test.HelloRequest;
import cn.ckeen.lib.grpc.test.SimpleGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @description：TODO
 * @author: CKeen
 * @date: 2022/5/6 1:34 上午
 */
@Service
public class GreeterService {

    @GrpcClient("cloud-grpc-provider")
    private SimpleGrpc.SimpleBlockingStub simpleBlockingStub;

    public String greet(String name) {

        try {
            HelloReply response = simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode();
        }
    }

}
