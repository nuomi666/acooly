package ${requestPackage};

import com.jorge.testui.message.FacadeRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * Date: ${.now}
 */
@Slf4j
@Getter
@Setter
public class ${requestClassName} extends FacadeRequest {

    private ${facadeOrder} ${facadeOrder?uncap_first} = new ${facadeOrder}();

}