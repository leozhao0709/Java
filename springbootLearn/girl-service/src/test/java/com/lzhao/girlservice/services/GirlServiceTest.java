package com.lzhao.girlservice.services;

import com.lzhao.girlservice.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Optional<Girl> girl = girlService.findOne(14);
        girl.ifPresent(girl1 -> Assert.assertEquals(25, girl1.getAge()));
    }
}