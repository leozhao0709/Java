package com.lzhao.cache.redis;

import com.lzhao.cache.bean.Employee;
import com.lzhao.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void stringRedisTemplateTest() {
        stringRedisTemplate.opsForValue().append("msg", "hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
        stringRedisTemplate.opsForList().leftPush("mylist", "3");
    }

    @Test
    public void redisTemplateTest() {
        Employee employee = employeeMapper.getEmployeeById(2);
        redisTemplate.opsForValue().set("emp-01", employee);

        Employee employee1 = (Employee) redisTemplate.opsForValue().get("emp-01");
        System.out.println(employee1);
    }
}
