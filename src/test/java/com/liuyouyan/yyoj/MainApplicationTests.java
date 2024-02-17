package com.liuyouyan.yyoj;

import com.liuyouyan.yyoj.config.WxOpenConfig;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

/**
 * 主类测试
 *
 * @author <a href="https://liuyouyan.com">刘有颜</a>
 * @from <a href="https://liuyouyan.com">刘有颜的博客</a>
 */
//@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Test
    void contextLoads() {
        System.out.println(wxOpenConfig);
    }

    @Test
    void md5(){
        String encryptPassword = DigestUtils.md5DigestAsHex(("liuyouyan" + 123456789).getBytes());
        System.out.println(encryptPassword);
    }

}
