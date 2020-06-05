package ${servicePackage};

import com.acooly.core.utils.Ids;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.annotation.CaseApiService;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.service.base.BaseCaseService;
import ${requestPackage}.${requestClassName};
import com.jorge.testui.utils.AssertsUtil;
import com.jorge.testui.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ${authorName}
 * @email 280932756@qq.com
 * Date: ${.now}
 */
@Slf4j
@CaseApiService(caseNo = "${serviceClassName}", desc = "memo", owner = "${authorName}")
public class ${className} extends BaseCaseService<${requestClassName}, CaseBaseResponse> {


    @Override
    protected void doService(${requestClassName} request, CaseBaseResponse response) {
        JSONObject responseEntity = new JSONObject();
        String securityKey = request.getSecurityKey();
        String accessKey = request.getAccessKey();
        String partnerId = request.getPartnerId();
        //清除数据

        //准备数据
        request.setMerchOrderNo(Ids.getDid(20));
        request.setRequestNo(Ids.getDid(20));

        //测试过程
        Map<String, Object> map = new HashMap<String, Object>();
        HttpUtil.buildMap(request, map);

        //调用接口
        responseEntity = HttpUtil.httpRequest(request, map);
        response.setContext(JSONObject.toJSONString(map));
        response.setApiResponse(JSONObject.toJSONString(responseEntity));

        //结果验证
        AssertsUtil.assertThan(responseEntity.get("code"), request.getResultCode());
        AssertsUtil.assertThan(responseEntity.get("detail"), request.getMessage());

        //数据验证

        //清除数据
        response.setCaseNo(request.getCaseNo());
        response.setSuccess(true);
        response.setGatewayUrl(request.getGatewayUrl());

    }

}
