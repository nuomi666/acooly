package ${servicePackage};

import com.alibaba.dubbo.config.annotation.Reference;
import com.jorge.testui.annotation.CaseApiService;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.service.base.BaseCaseService;
import ${requestPackage}.${requestClassName};
import lombok.extern.slf4j.Slf4j;


/**
 * @author ${authorName}
 * @email 280932756@qq.com
 * Date: ${.now}
 */
@Slf4j
@CaseApiService(caseNo = "${serviceClassName}", desc = "memo", owner = "${authorName}")
public class ${className} extends BaseCaseService<${requestClassName}, CaseBaseResponse> {

    @Reference(version = "1.0")
    ${facadeClassName} ${facadeClassName?uncap_first};

    @Override
    protected void doService(${requestClassName} request, CaseBaseResponse response) {
        //清除数据

        //准备数据

        //测试过程

        //调用接口
        ${facadeResult} result = ${facadeClassName?uncap_first}.${facadeMethod}(request.get${facadeOrder}());
        response.setContext(request.get${facadeOrder}().toString());
        response.setApiResponse(result.toString());

        //结果验证
        AssertsUtil.assertThan(result.getCode(),request.getResultCode());
        AssertsUtil.assertThan(result.getDetail(),request.getResultMessage());

        //数据验证

        //清除数据
        response.setCaseNo(request.getCaseNo());
        response.setSuccess(true);
        response.setGatewayUrl(request.getGatewayUrl());

    }

}
