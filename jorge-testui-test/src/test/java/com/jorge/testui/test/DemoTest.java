
package com.jorge.testui.test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;


/**
 * @author qiubo
 */
public class DemoTest extends TestBase {
    @Test
    public void testController() throws Exception {
        assertGetBodyIs("hello", "hello world");
    }

    @Test
    public void testStaticResouce() throws Exception {
        assertGetBodyIs("demo.html", "demo");
    }

    @Test
    public void testNotFound() throws Exception {
        assertGetBodyContains("xxxx", "status=404");
    }

    @Test
    public void testJson(){
//        TestCaseOneApiRequest request = new TestCaseOneApiRequest();
//        request.setAge(88L);
//        request.setCaseNo("88888");
//        String apiRequestString = JSON.toJSONString(request, SerializerFeature.PrettyFormat,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteMapNullValue);
////        Gson g = new GsonBuilder().serializeNulls().create();
////        String apiRequestString =g.toJson(new TestCaseOneApiRequest());
//        System.out.println(apiRequestString);
    }
}
