package com.yhkx.core.configuration;
import com.yhkx.core.util.ApiLogger;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties(prefix = "spring.rocketmq.producer")
public class RocketMQConfig {
    private String pushConsumerGroup;
    private String pullConsumerGroup;
    private String nameServer;
    private String group;
    private int retryTimesWhenSendAsyncFailed;
    private int sendMsgTimeout;
    private int compressMsgBodyOverHowmuch;
    private int maxMessageSize;
    private boolean retryAnotherBrokerWhenNotStoreOk;
    private String instanceName;
    private int retryTimesWhenSendFailed;

    @Primary
    @Bean
    public DefaultMQProducer initMQProducer() {
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(nameServer);
        producer.setInstanceName(instanceName);
        producer.setCompressMsgBodyOverHowmuch(compressMsgBodyOverHowmuch);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setRetryAnotherBrokerWhenNotStoreOK(retryAnotherBrokerWhenNotStoreOk);
        producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendAsyncFailed);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
        producer.setSendMsgTimeout(sendMsgTimeout);

        try {
            producer.start();
        } catch (MQClientException e) {
            ApiLogger.rocketMqLog("RocketMQ初始化异常", e);
            return null;
        }

        return producer;
    }


    @Bean
    public DefaultMQPushConsumer initMQPushConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(pushConsumerGroup);
        consumer.setNamesrvAddr(nameServer);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);


        return consumer;
    }

    public String getPushConsumerGroup() {
        return pushConsumerGroup;
    }

    public void setPushConsumerGroup(String pushConsumerGroup) {
        this.pushConsumerGroup = pushConsumerGroup;
    }

    public String getPullConsumerGroup() {
        return pullConsumerGroup;
    }

    public void setPullConsumerGroup(String pullConsumerGroup) {
        this.pullConsumerGroup = pullConsumerGroup;
    }

    public boolean isRetryAnotherBrokerWhenNotStoreOk() {
        return retryAnotherBrokerWhenNotStoreOk;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getRetryTimesWhenSendAsyncFailed() {
        return retryTimesWhenSendAsyncFailed;
    }

    public void setRetryTimesWhenSendAsyncFailed(int retryTimesWhenSendAsyncFailed) {
        this.retryTimesWhenSendAsyncFailed = retryTimesWhenSendAsyncFailed;
    }

    public int getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public int getCompressMsgBodyOverHowmuch() {
        return compressMsgBodyOverHowmuch;
    }

    public void setCompressMsgBodyOverHowmuch(int compressMsgBodyOverHowmuch) {
        this.compressMsgBodyOverHowmuch = compressMsgBodyOverHowmuch;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public boolean getRetryAnotherBrokerWhenNotStoreOk() {
        return retryAnotherBrokerWhenNotStoreOk;
    }

    public void setRetryAnotherBrokerWhenNotStoreOk(boolean retryAnotherBrokerWhenNotStoreOk) {
        this.retryAnotherBrokerWhenNotStoreOk = retryAnotherBrokerWhenNotStoreOk;
    }

    public int getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }

}
