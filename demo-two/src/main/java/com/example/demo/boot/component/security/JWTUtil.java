package com.example.demo.boot.component.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class JWTUtil {

    // 过期时间一天
    //private static final long EXPIRE_TIME = 10 * 24 * 60 * 60 * 1000;
    //一秒中
    // private static final long EXPIRE_TIME = 1000;

    private final static String SALT = "YcYp65l;uq234pwb;iIjHg872S-ajfL.khp636";
    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @param phone 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String phone) {
        try {
            String secret = DigestUtils.md5DigestAsHex(phone.concat(SALT).getBytes());
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            log.info("JWTVerificationException = " + exception.getMessage());
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {

            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            log.info("JWTDecodeException = " + e.getMessage());
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param phone    用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String phone) {
        // Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String secret = DigestUtils.md5DigestAsHex(phone.concat(SALT).getBytes());
        Date date = getExpireTime();

        Algorithm algorithm = Algorithm.HMAC256(secret);
        //log.info("--------------------JWTUtil----------------sign成功!");
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }


    /**
     * token是否过期
     *
     * @return true：过期
     */
    public static boolean isTokenExpired(String token) {
        Date now = new Date(System.currentTimeMillis());
        //  Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }

    private static Date getExpireTime() {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        //3个月后
        c.add(Calendar.MONTH, 3);
        return c.getTime();
    }
}
