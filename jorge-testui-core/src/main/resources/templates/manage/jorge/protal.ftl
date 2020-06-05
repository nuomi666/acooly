<#--<link rel="stylesheet" href="https://adminlte.io/themes/dev/AdminLTE/plugins/fontawesome-free/css/all.min.css"/>-->
<section class="content" style="min-height: 10px; padding-top: 5px">
<#-- 显示总用例数 （分系统展示）-->
    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-4 col-6">
                <!-- small box -->
                <div class="small-box bg-info">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${allTestCase}</font></font></h3>

                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">总用例数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-cube fa-lg fa-fw fa-col"></i>
                    </div>
                    <a href="#" class="small-box-footer"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">更多信息 </font></font><i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-4 col-6">
                <!-- small box -->
                <div class="small-box bg-success">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${allTestCaseSuccess}</font></font></h3>

                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">成功数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-thumbs-up fa-lg fa-fw fa-col"></i>
                    </div>
                    <a href="#" class="small-box-footer"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">更多信息 </font></font><i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-4 col-6">
                <!-- small box -->
                <div class="small-box bg-danger">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${allTestCaseFail}</font></font></h3>

                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">失败数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-thumbs-down fa-lg fa-fw fa-col"></i>
                    </div>
                    <a href="#" class="small-box-footer"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">更多信息 </font></font><i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
        </div>

        <div class="row">
            <div class="col-12">
                <div class="card">
                <div class="card-header border-0">
                    <h3 class="card-title">系统用例情况</h3>
                </div>
                <div class="card-body p-0">
                    <table class="table table-striped table-valign-middle">
                        <thead>
                        <tr>
                            <th>系统名称</th>
                            <th>接口数量</th>
                            <th>用例数</th>
                            <th>成功数</th>
                            <th>失败数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list parameterStatusDto as parameterStatus>
                            <tr>
                                <td>
                                    ${parameterStatus.projectNo}
                                </td>
                                <td>
                                    ${parameterStatus.interfaceCount}
                                </td>
                                <td>
                                    ${parameterStatus.totalTestCaseCount}
                                </td>
                                <td>
                                    <span style="color: green;">${parameterStatus.successCount}</span>
                                </td>
                                <td>
                                    <span style="color: red">${parameterStatus.failCount}</span>
                                </td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
            </div>
        </div>

    </div>
</section>
<div style="padding: 0 15px;">
<#-- 分系统展示用例成功和失败数据 -->
</div>
<div style="padding: 20px 15px; height: 100%;">
    <iframe id="manage_portal_echart" src="/manage/module/echarts/index_2.html" frameborder="0" scrolling="yes" style="border:0;height: 100%;width:100%;background-color: #fff;"></iframe>
</div>