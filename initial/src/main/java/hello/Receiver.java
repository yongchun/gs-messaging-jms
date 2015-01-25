package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {

    /**
     * Get a copy of the application context
     */
    @Autowired
    ConfigurableApplicationContext context;

    private AtomicInteger  count = new AtomicInteger(0);// 记录消费消息的数量


    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    public void receiveMessage(BusinessMessage message) {

        System.out.println(Thread.currentThread().getName());
        System.out.println("Received <" + message + ">");
        try {
            if (message.getIndex() % 4 == 0) {
                Thread.sleep(1000 * 6); // 模拟不通消息消费快慢
            } else {
                Thread.sleep(1000 * 2);
            }
        } catch (Exception e) {
            //TODO
        }
        count.addAndGet(1);
        if(count.intValue()==10){
            context.close(); //关闭spring context
            FileSystemUtils.deleteRecursively(new File("activemq-data"));
        }
    }
}