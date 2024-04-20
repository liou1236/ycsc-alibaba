package com.zrrd.shop.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

/**
 * @author : Ming
 */
/*
 * JWT操作的工具类 用于生成jwt token和解析token
 * */
public class JwtUtil {
    /*
     * 用于生成令牌
     * long exp,:令牌的有效时间 例如从现在开始5min内有效
     * String... claims:需要放到令牌中的声明信息
     * */
    public static String create(long exp,String... claims){
        long now = System.currentTimeMillis();//系统当前时间
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(new Date(now)) //令牌的签发时间
                .setExpiration(new Date(now + exp)) //设置令牌的过期时间
                .setIssuer("ZRRD")              //签发人
                .setSubject("云创商城token凭证")   //令牌主题
                .setId(UUID.randomUUID().toString()); //令牌的唯一标识
        //添加的声明信息
        builder.claim("userId",claims[0]);//决定好的可变参数claims[0]= userId
        builder.claim("username",claims[1]);//决定好的可变参数claims[1]= username
        //声明签名的加密算法和密钥
        builder.signWith(SignatureAlgorithm.HS256,"ycyyds");
        return builder.compact();//生成并且返回jwt字符串
    }
    /*
     * 解析jwt token的方法
     * */
    public static String parse(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey("ycyyds").parseClaimsJws(token).getBody();
            //如果token解析成功 则从token声明信息中用户ID和用户名返回
            return claims.get("userId",String.class)+","+claims.get("username",String.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;//如果解析时出错 说明令牌是伪造的或者是过期
        }


    }

}
