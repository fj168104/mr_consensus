<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }
        .center{
            text-align: center;
            width: 100%;
        }
    </style>
</head>
<body>
<!--第一页开始-->
<div class="page" >
    <div class="center"><p>迈容-格式化报告样例</p></div>
    <div class="center"><p>${bankData.name}</p></div>
    <div><p>发布时间: ${bankData.issueDate}</p></div>
    <div><p>被处罚当事人: ${bankData.partyPerson}</p></div>
    <div><p>单位名称: ${bankData.bankName}</p></div>
    <div><p>法定代表人（主要负责人）姓名: ${bankData.holderName}</p></div>
    <div><p>主要违法违规事实（案由）: ${bankData.mainCase}</p></div>
    <div><p>行政处罚依据: ${bankData.according}</p></div>
    <div><p>行政处罚决定: ${bankData.decision}</p></div>
    <div><p>作出处罚决定的机关名称: ${bankData.orgName}</p></div>
    <div><p>原链接: ${bankData.oriUrl}</p></div>

</div>
<!--第一页结束-->
<!---分页标记-->
<span style="page-break-after:always;"></span>
<!--第二页开始-->
<div class="page">
    <div><p>迈容官网: <a href="http://www.microrule.com">www.microrule.com</a></p></div>
    <div><p>商务合作：marketing@microrule.com</p></div>
    <div><p>地 址：上海·虹口</p></div>
    <div class="center">
        <img src="/opt/consensus/Downloads/logo.png" alt="MR" width="200" height="60"/>
    </div>

</div>


<!--第二页结束-->
</body>
</html>