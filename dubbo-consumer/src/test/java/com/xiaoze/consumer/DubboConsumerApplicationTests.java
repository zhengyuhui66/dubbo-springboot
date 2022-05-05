package com.xiaoze.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerApplicationTests {

    @Test
    public void contextLoads() {
        try {
            ServerSocket serverSocket = new ServerSocket(100);
            serverSocket.accept();
            Socket socket= new Socket();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
