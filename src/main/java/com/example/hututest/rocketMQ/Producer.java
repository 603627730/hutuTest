package com.example.hututest.rocketMQ;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        // 声明并初始化一个producer
        // 需要一个producer group名字作为构造方法的参数，这里为producer1
        DefaultMQProducer producer = new DefaultMQProducer("producer1");
        producer.setVipChannelEnabled(false);
        // 设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        // NameServer的地址必须有
        // producer.setClientIP("139.196.6.43");
        // producer.setInstanceName("Producer");
        producer.setNamesrvAddr("139.196.6.43:9876");

        // 调用start()方法启动一个producer实例
        producer.start();

        // 发送1条消息到Topic为TopicTest，tag为TagA，消息内容为“Hello RocketMQ”拼接上i的值
        try {
            while (true) {
                String s = sc.next();
                // 封装消息
                Message msg = new Message("TopicTest",// topic
                        "TagA",// tag
                        (s).getBytes(RemotingHelper.DEFAULT_CHARSET)// body
                );
                // 调用producer的send()方法发送消息
                // 这里调用的是同步的方式，所以会有返回结果
                SendResult sendResult = producer.send(msg);
                // 打印返回结果
                System.out.println(sendResult);
            }
        } catch (RemotingException | MQBrokerException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //发送完消息之后，调用shutdown()方法关闭producer
        System.out.println("send success");
        producer.shutdown();
    }
}