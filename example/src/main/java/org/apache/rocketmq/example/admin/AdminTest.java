package org.apache.rocketmq.example.admin;

import org.apache.rocketmq.client.ClientConfig;
import org.apache.rocketmq.client.impl.MQAdminImpl;
import org.apache.rocketmq.client.impl.MQClientManager;
import org.apache.rocketmq.client.impl.factory.MQClientInstance;

import static org.apache.rocketmq.client.log.ClientLogger.CLIENT_LOG_USESLF4J;

public class AdminTest {
    public static void main(String[] args) throws Exception {
        System.setProperty(CLIENT_LOG_USESLF4J, "true");
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setNamesrvAddr("127.0.0.1:9876");
        clientConfig.setMqClientApiTimeout(5000);
        MQClientInstance instance = MQClientManager.getInstance().getOrCreateMQClientInstance(clientConfig);
        instance.start();
        MQAdminImpl admin = instance.getMQAdminImpl();

//        admin.createTopic("test-key", "TopicTest", 2);
        admin.createTopic("TopicTest", "TopicTest2", 2);

        instance.shutdown();
    }


}
