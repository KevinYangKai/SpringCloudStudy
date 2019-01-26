package com.kevin.streamhello;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StreamHelloApplication.class)
@WebAppConfiguration
public class StreamHelloApplicationTests {

    //注入绑定接口
    /*@Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads(){
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }*/

    //注入消息通道
    @Autowired
    private MessageChannel input;

    public void contextLoads() {
        input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }

}
