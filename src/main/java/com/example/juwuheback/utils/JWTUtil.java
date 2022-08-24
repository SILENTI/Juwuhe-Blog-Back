package com.example.juwuheback.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.juwuheback.domain.dto.UserDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    /**
     * 头信息
     */
    private static final String HEADER = "";

    /**
     * 秘钥
     */
    private static final String Token_SECRET = "JuWuHe";

    /**
     * 过期时间
     */
    private static final long EXPIRE_DATE = 30 * 60 * 100000;

    /**
     * 生成Token信息
     * -根据用户信息来生成Token信息
     *
     * @return
     */
    public static String getToken(UserDTO userDTO) {
        //token失效时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_DATE);
        //设置秘钥
        Algorithm algorithm = Algorithm.HMAC256(Token_SECRET);
        //设置头信息
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");

        return JWT.create().
                //header头信息
                        withHeader(header).
                //playload加密内容
                        withClaim("username", userDTO.getUsername()).withClaim("password", userDTO.getPassword()).
                //过期时间
                        withExpiresAt(expireDate).
                //签名-即秘钥
                        sign(algorithm);
    }
}
