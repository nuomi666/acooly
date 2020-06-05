<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_testCase_editform"
          action="/manage/jorge/testCase/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="testCase" scope="request">
            <input name="id" type="hidden"/>
            <input name="createUser"  type="hidden" value="${createUser}"/>
            <table class="editForm" width="100%">
                <tr>
                    <th width="25%">用例编号：</th>
                    <td><input type="text" name="caseNo" placeholder="请输入用例编号..." class="easyui-validatebox"
                               data-options="validType:['length[1,64]'],required:true"/></td>
                </tr>
                <tr>
                    <th>用例名称：</th>
                    <td><input type="text" name="caseName" placeholder="请输入用例名称..." class="easyui-validatebox"
                               data-options="validType:['length[1,32]'],required:true"/></td>
                </tr>
                <tr>
                    <th>所属系统：</th>
                    <td><select id="projectNo" name="projectNo" editable="false" panelHeight="300"
                                class="easyui-combobox" style="min-width: 235px;" data-options="required:true">
					<#list allProjectNos as k,v>
                        <option value="${k}">${v}</option></#list>
                    </select></td>
                </tr>
                <tr id="interfaceNoTr">
                    <th>所属接口：</th>
                    <td><select id="interfaceNo" name="interfaceNo" editable="false" panelHeight="300"
                                class="easyui-combobox" style="min-width: 235px;" data-options="valueField:'id',textField:'text'">
                    <#--<#list allInterfaceNos as k,v>-->
                        <#--<option value="1">请选择</option>-->
                    <#--</#list>-->
                    </select></td>
                </tr>
                <tr>
                    <th>用例类别：</th>
                    <td><select name="caseType" editable="false" panelHeight="300" class="easyui-combobox"
                                style="min-width: 235px;" data-options="required:true">
					<#list allCaseTypes as k,v>
                        <option value="${k}">${v}</option></#list>
                    </select></td>
                </tr>
                <tr>
                    <th>请求地址：</th>
                    <td><textarea rows="3" cols="40" placeholder="请输入请求地址..." name="url" class="easyui-validatebox"
                                  data-options="required:true"></textarea></td>
                </tr>
                <#--<tr>-->
                    <#--<th>请求参数：</th>-->
                    <#--<td><textarea rows="3" cols="40" placeholder="请输入请求参数..." name="input" class="easyui-validatebox"-->
                                  <#--data-options="validType:['length[1,1024]'],required:true"></textarea></td>-->
                <#--</tr>-->
                <tr>
                    <th>协议类型：</th>
                    <td><select name="protocolType" editable="false" panelHeight="300" class="easyui-combobox"
                                style="min-width: 235px;" data-options="required:true">
					<#list allProtocolTypes as k,v>
                        <option value="${k}">${v}</option></#list>
                    </select></td>
                </tr>
            </table>
        </@jodd.form>
    </form>
</div>

<script type="text/javascript">

    // $('#interfaceNoTr').hide();
    $(function () {
        var projectNo = $('#projectNo').combobox("getValue");
        var interfaceNo = '${testCase.interfaceNo}';
        //首次加载系统的接口
        getInterfaceNos(projectNo,interfaceNo);
        //下拉框修改后重新加载接口数据
        $('#projectNo').combobox({
            onChange: function (newProjectNo, oldProjectNo) {
                $('#interfaceNo').empty();
                getInterfaceNos(newProjectNo,'');
            }
        });
    });


    function getInterfaceNos(projectNo,interfacsNo) {
        $.ajax({
            url: '/manage/jorge/testCase/relaodInterfaceNos.html',
            data: {
                'projectNo': projectNo
            },
            success: function (data) {
                if (data.success) {
                    var Data = data.data;
                    var dataList;
                    dataList = [];
                    $.each(data.data, function (key, value) {
                        // alert("key:"+key+",value:"+value);
                        dataList.push({"id": key,"text":value});
                        // $("#interfaceNo").append(  //此处向select中循环绑定数据
                        //         "<option value="+key+">" + value+ "</option>");
                    })
                    $("#interfaceNo").combobox("loadData",dataList);
                    //默认选中第一条数据
                    if (interfacsNo=='') {
                        $("#interfaceNo").combobox("select",dataList[0].id);
                    }else {
                        $("#interfaceNo").combobox("select",interfacsNo);
                    }
                    // for (var k in Data)
                    // {
                    //     alert("key:"+k)
                    //     $('#interfaceNo').append(  //此处向select中循环绑定数据
                    //             '<option value='+k+'>' + Data[k]+ '</option>');
                    //     // alert("key"+k);
                    //     // alert("value"+Data[k])
                    //     // $('#interfaceNo').html(k.val())
                    //     // $('#interfaceNo').val(k)
                    // }

                }
            }

        });

    }
</script>
