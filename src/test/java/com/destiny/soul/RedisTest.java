package com.destiny.soul;

import com.destiny.soul.entity.Student;
import com.destiny.soul.utils.RedisUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author zhuhaifeng
 * @since 2020-11-26
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void test() {
        Student student = new Student();
        student.setId(11);
        student.setAge("13");
        student.setName("me");
        student.setCreateTime(new Date());
        redisUtil.set("student", student);
        System.out.println("success");
    }

    @Test
    public void get() {
        Student student = (Student)redisUtil.get("student");
        redisUtil.expire("student", 100L);
        System.out.println(redisUtil.getExpire("student"));
    }
}
