package com.example.hututest.rockeqmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生产者  ---用户生产消息
 */
@Component
public class ProducerMsg {

    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;   //生产者的组

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;    //NameServer地址

    private DefaultMQProducer producer;  //默认生产者

    public DefaultMQProducer getProducer() {
        return producer;
    }

    /**
     * @PostConstruct  会在servlet初始化时执行，只执行一次
     * 作用：让当前方法在 构造函数之后，init方法之前执行
     */
    @PostConstruct
    public void defaultMQProducer(){
        //1.创建一个默认生产者对象，作用于生产消息
        producer = new DefaultMQProducer(producerGroup);
        //2.绑定生产者和namesrvAddr
        producer.setNamesrvAddr(namesrvAddr);
        //3.发送消息
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
