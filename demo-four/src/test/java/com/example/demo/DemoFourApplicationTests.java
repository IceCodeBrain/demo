package com.example.demo;

import com.example.demo.controller.ScmTopicController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest()
class DemoFourApplicationTests {

    @Resource
    private ScmTopicController scmTopicController;
    @Test
    void contextLoads() {
    }

    @Test
    void testTransactional() {
        scmTopicController.testTransactional();
    }
}
