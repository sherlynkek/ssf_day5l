package sg.edu.nus.iss.vttp5a_day5l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day5l.util.Util;

@Repository
public class ListRepo {
    @Autowired
    @Qualifier(Util.template02)
    RedisTemplate<String, Object> template;

    // slide 30
    public void leftPush(String key, String value) {
        template.opsForList().leftPush(key, value);
    }

    public void rightPush(String key, String value) {
        template.opsForList().rightPush(key,value);
    }

    // slide 30, slide 34
    public void leftPop(String key) {
        template.opsForList().leftPop(key, 1);
    }

    public void rightPop(String key) {
        template.opsForList().rightPop(key, 1);
    }

    // slide 32
    public String get(String key, Integer index) {
        return template.opsForList().index(key, index).toString();
    }

    // slide 33
    public Long length(String key) {
        return template.opsForList().size(key);
    }


}