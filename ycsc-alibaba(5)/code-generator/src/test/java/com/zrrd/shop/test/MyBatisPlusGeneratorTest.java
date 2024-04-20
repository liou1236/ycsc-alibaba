package com.zrrd.shop.test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

public class MyBatisPlusGeneratorTest {
    @Test
    public void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/zrrd_mall?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true",
                        "root","root")
                .globalConfig(builder -> {
                    builder.author("hao") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://中软云创商城项目/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zrrd.shop") // 设置父包名
                            .moduleName("ums") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E://中软云创商城项目/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("ums_admin",
                                    "ums_admin_login_log",
                                    "ums_growth_change_history",
                                    "ums_integration_change_history",
                                    "ums_integration_consume_setting",
                                   " ums_member",
                                    "ums_member_level",
                                    "ums_member_login_log",
                                    "ums_member_receive_address",
                                   " ums_member_rule_setting",
                                    "ums_member_statistics_info",
                                    "ums_member_tag",
                                    "ums_member_task",
                                    "ums_menu",
                                    "ums_permission",
                                    "ums_resource",
                                    "ums_resource_category",
                                    "ums_role") // 设置需要生成的表名
                            .addTablePrefix("ums_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
