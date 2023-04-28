package com.example.hututest.rockeqmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 消费者     --消费信息
 */
@Component
public class ConsumerMsg {

    @Value("${apache.rocketmq.consumer.pushConsumer}")
    private String pushConsumer;    //消费者组名

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;    //NameServer地址

    //提供一个空构造器
    public ConsumerMsg() {
    }

    @PostConstruct
    //提供默认的消费者
    public void defaultMsgConsumer(){
        //1.指定消费者所消费的主题(队列) tag(2及标签，用于过滤消息)
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(pushConsumer);
        //说明,如果要消费所有tag,用通配符*代替所有tag，如果明确指定
        try {
            consumer.subscribe("orderTopic","*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        //2.指定消费的策略(从所有的消息开头位置执行， 还是从消息尾部执行)指定消费的顺序
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //TODO
        consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {//注册消息监听器，用的lambda
            try {
                for (MessageExt messageExt : list) {
                    System.out.println("messageExt: " + messageExt);//输出消息内容
                    String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                    System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + messageBody);//输出消息内容
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER; //稍后再试
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; //消费成功
        });
        
        //3.开启监听  消费消息
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
