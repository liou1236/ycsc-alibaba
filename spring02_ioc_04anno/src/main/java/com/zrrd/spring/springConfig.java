package com.zrrd.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.zrrd")
@Import({JDBCConfig.class})
public class springConfig {


}
