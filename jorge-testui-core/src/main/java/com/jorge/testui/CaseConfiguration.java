package com.jorge.testui;

import com.google.common.collect.Lists;
import com.jorge.testui.servlet.CaseApiDispatchServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiubo@yiji.com
 */
@Configuration
@ComponentScan(basePackages = "com.jorge.testui")
public class CaseConfiguration {


    /**
     * 网关入口
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean caseAPIServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setUrlMappings(Lists.newArrayList("/case.do"));
        CaseApiDispatchServlet caseApiDispatchServlet = new CaseApiDispatchServlet();
        bean.setServlet(caseApiDispatchServlet);
        bean.setLoadOnStartup(1);
        return bean;
    }

}
