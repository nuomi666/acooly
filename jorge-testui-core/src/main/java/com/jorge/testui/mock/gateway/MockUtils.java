package com.jorge.testui.mock.gateway;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-04-10 09:13
 */
@Slf4j
public class MockUtils {

    /**
     * 传入一个数据获取其百位上的数据
     * @param a
     * @return
     */
    public static Long hundreds(Long a ){
        Long r = a/100%10;
        return r;
    }

    public static void main(String[] args) {
        long a = 128999;
        System.out.println(hundreds(a));
    }
}
