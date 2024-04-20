package com.zrrd.shop.filter;


import com.zrrd.shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.LinkedList;
import java.util.List;

/**
 * 进行统一的身份认证（1 验证是否携带了token、2 jwt是否合法（有没有被伪造）、3 是否过期）
 */
//@Component
//@ConfigurationProperties(prefix = "auth-filter")
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //这个list集合中的请求是不需要通过身份认证过程的
    private List<String> excludes = new LinkedList<>();

    public List<String> getExcludes() {
        return excludes;
    }
    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
    private final String AUTHORIZATION = "Authorization";//请求头中用于封装token的属性名
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uri = exchange.getRequest().getURI().getPath();//获取本次请求的
//        System.out.println(excludes);
//        System.out.println(uri);
        if (excludes.contains(uri)) {//如果当前请求路径包含在不需要认证的集合里，直接放行
            return chain.filter(exchange);
        }
        //最终项目里从请求头中获取 19行
        //String token = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION);//获取请求头中的token信息
        //为了今天测试我们从请求参数中获取 21行
        String token = exchange.getRequest().getQueryParams().getFirst(AUTHORIZATION);
        // 当前请求未携带令牌 或者 令牌解析出错（令牌伪造|已过期）
        if (StringUtils.isEmpty(token) || JwtUtil.parse(token) == null) {//5/6
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//设置响应状态码为 未授权
            return exchange.getResponse().setComplete();//返回客户端
        }
        // 令牌合法，请求继续进行（路由到其他微服务） 7
        return chain.filter(exchange);
    }

    // 返回值决定了这个过滤器在整个过滤器链中的执行顺序，返回值越小执行越靠前
    @Override
    public int getOrder() {
        return 1;
    }
}