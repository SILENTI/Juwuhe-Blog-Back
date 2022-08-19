package com.example.generalbase.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author SILENTI
 * gnerator启动类详解：https://baomidou.com/pages/981406/#%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE-datasourceconfig
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/base_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "root").globalConfig(builder -> {
                    //全局配置
                    builder.author("SILENTI") // 设置作者
                            // 禁止打开生成目录
                            .disableOpenDir()
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 覆盖已生成文件
                            .fileOverride()
                            // 时间配置
                            .dateType(DateType.TIME_PACK).commentDate("yyyy-MM-dd").outputDir("D:\\PROJECT\\GeneralBase\\src\\main\\java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.example.generalbase")
                            // 设置父包模块名
                            .moduleName("")
                            // 实体类包名
                            .entity("entity")
                            // 服务层
                            .service("service").serviceImpl("service.Impl")
                            // 控制层
                            .controller("controller")
                            // mapper层
                            .mapper("mapper")
                            //xml配置文件
//                            .xml("mapper.xml")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\PROJECT\\GeneralBase\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("user")
                            // .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                            // 开启Controller策略配置
                            .controllerBuilder()
                            //开启生成@RestController 控制器
                            .enableRestStyle()
                            // 开启Service策略配置
                            .serviceBuilder()
                            //开启Entity策略配置
                            .entityBuilder()
                            //开启Lombok
                            .enableLombok()
                            // 开启Mapper策略配置
                            .mapperBuilder()
                            //启动@Mapper注解
                            .enableMapperAnnotation()
                            // 启用 BaseResultMap 生成
                            .enableBaseResultMap()
                            // 启用 BaseColumnList
                            .enableBaseColumnList();
                }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
