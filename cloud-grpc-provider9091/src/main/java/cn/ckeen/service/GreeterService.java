package cn.ckeen.service;

import cn.ckeen.lib.grpc.test.HelloReply;
import cn.ckeen.lib.grpc.test.HelloRequest;
import cn.ckeen.lib.grpc.test.SimpleGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description：TODO
 * @author: CKeen
 * @date: 2022/5/6 12:43 上午
 */
@GrpcService
public class GreeterService extends SimpleGrpc.SimpleImplBase {

    private static Logger log = LoggerFactory.getLogger(GreeterService.class);

    // 引入该参数是为了做负载均衡验证
    @Value("${grpc.server.port}")
    private String serverPort;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "server port:" + serverPort + ",Hello " + request.getName();
        final HelloReply.Builder replyBuilder = HelloReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        log.info("Returning " +message);

        responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("测试出错").asException());
    }
}
