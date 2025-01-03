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
public class RedisConfig 
{
    // Slide 17
    @Value("${spring.data.redis.host}") // now use local, but if deploy railway, use railway one
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private Integer redisPort;

    @Value("${spring.data.redis.username}")
    private String redisUsername;

    @Value("${spring.data.redis.password}")
    private String redisPassword;
    
    // Slide 18 (split up into separate beans)
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() // link up to redis (?)
    {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setHostName(redisHost);
        rsc.setPort(redisPort);

        if (redisUsername.trim().length()>0)
        {
            rsc.setUsername(redisUsername);
            rsc.setPassword(redisPassword);
        }

        JedisClientConfiguration jcc = JedisClientConfiguration.builder().build();
        JedisConnectionFactory jcf = new JedisConnectionFactory(rsc, jcc);
        jcf.afterPropertiesSet();

        return jcf;
    }

    @Bean(Util.template01) // how data is written to database
    public RedisTemplate<String, String> redisObjectTemplate01() // guy doing the stuff , add, create, whatever
    {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory()); // connecting back to factory
        template.setKeySerializer(new StringRedisSerializer()); // kinda let redis understand java
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }

    @Bean(Util.template02)
    public RedisTemplate<String, Object> redisObjectTemplate02() // serialised obj as a string better?
    {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}
