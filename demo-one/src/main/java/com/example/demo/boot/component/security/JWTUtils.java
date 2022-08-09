package com.example.demo.boot.component.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.boot.restful.CommonException;
import com.example.demo.boot.restful.RestCode;
import com.example.demo.boot.uitls.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Slf4j
public class JWTUtils {

    private final static String SALT = "YcYp65l;uq234pwb;iIjHg872S-ajfL.khp636";

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @param phone 用户的密码
     */
    public static void verify(String token, String userId, String phone) {
        try {
            String secret = DigestUtils.md5DigestAsHex(phone.concat(SALT).getBytes());
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userId", userId)
                    .build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CommonException(RestCode.UNAUTHORIZED.getCode(), e.getMessage());
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            throw new CommonException(RestCode.UNAUTHORIZED.getCode(), e.getMessage());
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param userId 用户Id
     * @param phone  用户的密码
     * @return 加密的token
     */
    public static String sign(String userId, String phone) {
        return sign(userId, phone, getExpireTime());
    }


    public static String sign(String userId, String phone, Date expireTime) {
        String secret = DigestUtils.md5DigestAsHex(phone.concat(SALT).getBytes());
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("userId", userId)
                .withExpiresAt(expireTime)
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
        return DateUtils.addYears(new Date(), 1);
    }


}
