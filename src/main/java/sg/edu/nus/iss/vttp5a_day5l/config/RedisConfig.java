package sg.edu.nus.iss.vttp5a_day5l.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import sg.edu.nus.iss.vttp5a_day5l.util.Util;

@Configuration
public class RedisConfig {
    
    // slide 17, slide 18

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private Integer redisPort;

    @Value("${spring.data.redis.username")
    private String redisUsername;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    // slide 18

    @Bean (Util.template01)
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setHostName(redisHost);
        rsc.setPort(redisPort);
        
        if(redisUsername.trim().length() > 0) {
            rsc.setUsername(redisUsername);
            rsc.setPassword(redisPassword);
        }

        JedisClientConfiguration jcc = JedisClientConfiguration.builder().build();
        JedisConnectionFactory jcf = new JedisConnectionFactory(rsc);
        jcf.afterPropertiesSet();
        
        return jcf;
    }

    @Bean (Util.template02)
    public RedisTemplate<String, String> redisObjectTemplate() {
        RedisTemplate<String,String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        
        return template;
    }

}
