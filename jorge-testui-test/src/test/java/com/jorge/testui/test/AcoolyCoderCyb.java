
package com.jorge.testui.test;
import com.acooly.coder.Generator;
import com.acooly.coder.generate.impl.DefaultCodeGenerateService;
import org.apache.commons.lang3.StringUtils;

/**
 * 代码生成工具
 */
public class AcoolyCoderCyb {
    public static void main(String[] args) {
        DefaultCodeGenerateService service = (DefaultCodeGenerateService) Generator.getGenerator();
        //set workspace if possible
        if (StringUtils.isBlank(service.getGenerateConfiguration().getWorkspace())) {
            String workspace = getProjectPath() + "jorge-testui-core";
            service.getGenerateConfiguration().setWorkspace(workspace);
        }
        //set root pacakge if possible
        if (StringUtils.isBlank(service.getGenerateConfiguration().getRootPackage())) {
            service.getGenerateConfiguration().setRootPackage(getRootPackage());
        }
        /**
         * 需要生成的表
         *
         * 			生成所有的表(星号)： "*"
         * 			部分表:   "act_account_xx","act_account_bat_yy"
         *
         */
        service.generateTable("pay_payengine_order_refund");
    }
    
    public static String getProjectPath() {
        String file = AcoolyCoderCyb.class.getClassLoader().getResource(".").getFile();
        String testModulePath = file.substring(0, file.indexOf("/target/"));
        String projectPath = testModulePath.substring(0, testModulePath.lastIndexOf("/"));
        return projectPath + "/";
    }
    
    private static String getRootPackage() {
        return "com.jorge.testui.database." + jsCodePackages;
    }
    
    /**
     * 系统名
     *
     */
    public static final String	jsCodePackages = "paycore";
    
}
