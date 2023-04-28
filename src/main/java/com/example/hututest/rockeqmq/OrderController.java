package com.example.hututest.rockeqmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class OrderController {

    @Autowired
    private ProducerMsg producerMsg;

    /**
     *
     * @param msg    发送的消息
     * @param tag     二级标签
     * @return
     */
    @GetMapping("/rocket")
    public Object msg(String msg,String tag){
        //1.创建消息载体对象  Message
        Message message = new Message("orderTopic",tag,msg.getBytes());
        //2.通过注入的消息提供者对象发送消息
        try {
            SendResult send = producerMsg.getProducer().send(message);
            System.out.println("消息ID：" + send.getMsgId() + "；消息发送状态：" + send.getSendStatus());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
            return "JsonData.buildSuccess();";
    }
}
