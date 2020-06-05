package com.jorge.testui.test;

import com.jorge.testui.database.member.dao.MembermemberDao;
import com.jorge.testui.database.member.entity.Membermember;
import com.jorge.testui.utils.ClassUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-01-14 09:58
 */
@Slf4j
public class CreatMethodTest {

    /**
     * 生成insert方法
     * @param sourceClass
     * @param orderName
     */
    public static void printDaoInsertMethod(Class<?> sourceClass, String orderName){
        String className = sourceClass.getSimpleName();
        String lowClassName = className.substring(0, 1).toLowerCase() + className.substring(1);
        System.out.println("public "+className+" insert"+className+"(");
        List<Field> fields = Arrays.asList(sourceClass.getDeclaredFields());
        for (int i = 0; i < fields.size(); i++) {
            System.out.print(fields.get(i).getType().getSimpleName()+" "+fields.get(i).getName());
            if (i<fields.size()-1){
                System.out.println(",");
            }

        }
        System.out.println("){");
        System.out.println(className+" "+lowClassName+" = new "+className+"();");

        Method[] methods = sourceClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName().startsWith("set")) {
                System.out.println(lowClassName	+ "." + method.getName() + "("
                        + captureName(method.getName()) + ");");

            }
        }
        System.out.println(lowClassName+"Dao.insert("+lowClassName+");");
        System.out.println("return "+lowClassName+";");
        System.out.println("}");
    }

    /**
     * 获取set名，把第一个字母小写
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        String para = name.substring(3);
        name = para.substring(0, 1).toLowerCase() + para.substring(1);
        return name;
    }

    public static void printSetMethods(Class<?> sourceClass, String orderName) {

        //存参数类型
        List list = new ArrayList();

        Method[] methods = sourceClass.getMethods();

        System.out.println("<================set方法====================>");
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName().startsWith("set")) {
                System.out.println(orderName	+ "." + method.getName() + "("
                        + captureName(method.getName()) + ");");

                Class[] params = method.getParameterTypes();

                //拼接好参数类型 和 参数名
                list.add(params[0].getSimpleName() + " " + captureName(method.getName()));
            }
        }
        System.out.println();
        System.out.println("<================参数信息====================>");
        printList(list);
    }

    /**
     * 生成表的全字段校验方法
     * @param sourceClass
     * @param orderName
     */
    public static void printAssertMethods(Class<?> sourceClass, String orderName) {
        //存参数类型t
        Method[] methods = sourceClass.getMethods();
        System.out.println("<================assert方法====================>");
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName().length() <= 3) {
                continue;
            }
            String a = captureName(method.getName());
            if (method.getName().startsWith("set")) {
                System.out.println("TestUtil.assertEquals("	+ a + ", " + orderName + ".get"
                        + a.substring(0, 1).toUpperCase() + a.substring(1) + "());");
            }
        }
        System.out.println();
    }

    public static void printList(List list) {
        if (!list.isEmpty() && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                //                if (i % 5 == 0) {
                //                    System.out.println();
                //                }
                System.out.println(list.get(i) + ",");
            }
        }
    }


    public static void main(String[] args) {
        List<Class<?>> daoClass = ClassUtil.getClasses("com.jorge.database.member.entity");

        printDaoInsertMethod(Membermember.class,"");
    }



}
