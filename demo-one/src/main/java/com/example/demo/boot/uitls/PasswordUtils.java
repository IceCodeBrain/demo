package com.example.demo.boot.uitls;

import com.example.demo.boot.core.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

/**
 * @description: PasswordUtils <br>
 * @date: 2021/5/20 16:30 <br>
 * @author: PWB <br>
 */
@Slf4j
public class PasswordUtils {

    public static String buildPw(String password) {
        return DigestUtils.md5DigestAsHex(Constants.SALT_PRE.concat(password).concat(Constants.SALT).getBytes());
    }

/*    public static void main(String[] args) {
     String pass =    buildPw("weather123");
     log.info(pass);
    }*/

}
