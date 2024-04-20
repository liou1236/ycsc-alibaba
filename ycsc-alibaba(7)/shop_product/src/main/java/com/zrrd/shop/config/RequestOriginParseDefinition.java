package com.zrrd.shop.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Ming
 */
@Component
public class RequestOriginParseDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //除了参数进行限制 也可以加载请求头header上
        //只有带这个Token请求头的才能放行|
        String header = httpServletRequest.getHeader("Token");
        return httpServletRequest.getParameter("SN"); //serviceName简写
    }
}
