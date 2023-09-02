package com.example.demo.publisher;

import com.example.demo.config.RedisConfig;
import com.example.demo.dto.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Publisher {

    @Autowired
    private RedisConfig template;

    @Autowired
    private ChannelTopic channelTopic;

    public String publish(@RequestBody Product product){
        template.redisTemplate().convertAndSend(channelTopic.getTopic(), product.toString());
        return "Event published!!";
    }
}
