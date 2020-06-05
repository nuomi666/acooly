package com.jorge.testui.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-02-20 21:54
 */
@Slf4j
public class AppiumFirstTest {
    protected static AndroidDriver<AndroidElement> driver;
    protected static String ipAddress = "192.168.66.97"; //本地ip
    protected static boolean isUiautomator2 = false;
    protected static String appPackageName = "com.pccb.app.debug";

    public static String getProjectPath() {
        String file = AppiumFirstTest.class.getClassLoader().getResource(".").getFile();
        String testModulePath = file.substring(0, file.indexOf("/target/"));
        String projectPath = testModulePath.substring(0, testModulePath.lastIndexOf("/"));
        System.out.println(testModulePath);
        return testModulePath + "/src/test/resources/";
    }

    @Test
    public void first() throws MalformedURLException {
        File app = new File(getProjectPath(), "pccb-v3.2.0-vivo-debug.apk");  //尊享版包
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //android模拟器
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        capabilities.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
        capabilities.setCapability("unicodeKeyboard", "true"); // 支持中文输入
        capabilities.setCapability("resetKeyboard", "true"); // 支持中文输入，必须两条都配置
//        capabilities.setCapability("appPackage", "com.pccb.app.debug");
        capabilities.setCapability("appPackage", "com.android.calculator2");
//        capabilities.setCapability("appActivity", "com.pccb.app.ui.main.GuideActivity");
        capabilities.setCapability("appActivity", ".Calculator");
//        capabilities.setCapability("appWaitActivity", "com.pccb.app.ui.main.GuideActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("del").click();
        driver.findElementById("digit_9").click();
        driver.findElementById("digit_5").click();
        driver.findElementById("op_add").click();
        driver.findElementById("digit_6").click();
        driver.findElementById("eq").click();

        driver.quit();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Apps");
        el1.click();
        driver.navigate().back();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Calculator");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("multiply");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_6");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el7.click();


    }
}
