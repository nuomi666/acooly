package com.jorge.testui;


import com.acooly.core.common.BootApp;
import com.acooly.core.common.boot.Apps;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;


/**
 * @author qiubo
 */
//@ComponentScan({"com.acooly.module.chart"})
@BootApp(sysName = "jorge-testui", httpPort = 8999)
@EnableJpaRepositories(excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {Main.ExcludeFilter.class})})
@MapperScan(basePackages = {"com.acooly.module.chart.dao"})
public class Main {
    public static void main(String[] args) {
        Apps.setProfileIfNotExists("test");
        new SpringApplication(Main.class).run(args);
    }


    public static class ExcludeFilter implements TypeFilter {


        @Override
        public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {


            if (metadataReader.getClassMetadata().getClassName().contains("com.jorge.testui.gateway")) {
                return true;
            }
            return false;
        }
    }
}