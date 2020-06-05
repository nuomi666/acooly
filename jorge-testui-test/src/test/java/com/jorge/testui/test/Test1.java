//package com.jorge.testui.test;
//
//import com.jorge.testui.service.message.*;
//import com.jorge.testui.service.message.trade.WechatPublicPayApiServiceTestSuccessApiRequest;
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.reflect.Field;
//
//@Slf4j
//public class Test1 {
//
//    /**
//     * 生成map.put
//     * @param args
//     */
//    public static void main(String[] args) {
//        Class<?> sourceClass = WechatPublicPayApiServiceTestSuccessApiRequest.class;
//
//        Field[] fields = sourceClass.getDeclaredFields();
//        System.out.println("<===========参数========");
//        for (Field field : fields) {
//            System.out.println("map.put(\"" + field.getName() + "\",request.get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1) + "());");
//        }
//        System.out.println("<===========参数11========");
//        for (Field field : fields) {
//            System.out.println(field.getType().getSimpleName() + " " + field.getName() + ",");
//        }
//
//    }
//
//}