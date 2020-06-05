package com.jorge.testui.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-11-19 15:34
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;


@Slf4j
public class FreemarkerDemo {
    //系统名
    private static final String systemName = "trade";

    private static final String TEMPLATE_PATH = getProjectPath()+"/jorge-testui-test/src/test/resources/template";
    private static final String SERVICE_PACKAGE = getPackages().get("servicePackage");
    private static final String REQUEST_PACKAGE = getPackages().get("requestPackage");
    private static final String SERVICE_NAME = "GatewayDepositBackFacadeDepositBackSuccess";
    private static final String CLASS_NAME = SERVICE_NAME+"Service";
    private static final String REQUEST_CLASS_NAME = SERVICE_NAME+"ApiRequest";
    private static final String AUTHOR_NAME = "mufanglin";
    private static final String FACADE_CLASSNAME = "GatewayDepositBackFacade";
    private static final String FACADE_METHOD = "depositBack";
    private static final String FACADE_RESULT = "GatewayDepositBackResult";
    private static final String FACADE_ORDER = "GatewayDepositBackOrder";

    public static void main(String[] args) {
        String workspace = getPackages().get("serviceWorkspace");
        String workspace1 = getPackages().get("requestWorkspace");
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("servicePackage", SERVICE_PACKAGE);
        dataMap.put("requestPackage", REQUEST_PACKAGE);
        dataMap.put("serviceClassName", SERVICE_NAME);
        dataMap.put("authorName", AUTHOR_NAME);
        dataMap.put("facadeClassName", FACADE_CLASSNAME);
        dataMap.put("facadeMethod",FACADE_METHOD);
        dataMap.put("facadeResult",FACADE_RESULT);
        dataMap.put("facadeOrder",FACADE_ORDER);
        dataMap.put("className",CLASS_NAME);
        dataMap.put("requestClassName",REQUEST_CLASS_NAME);

        generateFacadeService("caseservice.ftl",dataMap,workspace,CLASS_NAME);
        generateFacadeService("facaderequest.ftl",dataMap,workspace1,REQUEST_CLASS_NAME);

//        generateFacadeService("apicaseservice.ftl",dataMap,workspace,CLASS_NAME);
//        generateFacadeService("apirequest.ftl",dataMap,workspace1,REQUEST_CLASS_NAME);

    }

    public static String getProjectPath() {
        String file = AcoolyCoder.class.getClassLoader().getResource(".").getFile();
        String testModulePath = file.substring(0, file.indexOf("/target/"));
        String projectPath = testModulePath.substring(0, testModulePath.lastIndexOf("/"));
        return projectPath + "/";
    }

    private static Map<String ,String> getPackages() {
        String basePackage = "com.jorge.testui.service.";
        String servicePackage = basePackage + systemName;
        String requestPackage = basePackage+"message." + systemName;
        String baseServiceWorkspace = servicePackage.replace(".","/");
        String baseRequestWorkspace = requestPackage.replace(".","/");
        String serviceWorkspace = getProjectPath() + "jorge-testui-service/src/main/java/" + baseServiceWorkspace +"/";
        String requestWorkspace = getProjectPath() + "jorge-testui-service/src/main/java/" + baseRequestWorkspace+"/";
        Map<String,String> packageMap = new HashMap<>();
        packageMap.put("servicePackage",servicePackage);
        packageMap.put("requestPackage",requestPackage);
        packageMap.put("serviceWorkspace",serviceWorkspace);
        packageMap.put("requestWorkspace",requestWorkspace);
        return packageMap;
    }

    @Test
    public void name() {
       System.out.println( getPackages().get("serviceWorkspace"));
       System.out.println( getPackages().get("requestWorkspace"));
       System.out.println( getPackages().get("servicePackage"));
       System.out.println( getPackages().get("requestPackage"));
//        System.out.println(getProjectPath());
    }

    public static void generateFacadeService(String templateName,Map<String, Object> dataMap,String workspace,String className){
// step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            // step4 加载模版文件
            Template template = configuration.getTemplate(templateName);
            // step5 生成数据
            File distPath = new File(workspace);
            if (!distPath.exists()) {
                distPath.mkdirs();
            }
            //生成service类
            File docFile = new File(workspace + className+".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println(className+".java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
