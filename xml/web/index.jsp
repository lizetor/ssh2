<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
<s:form action="saveUser">
    <s:textfield name="username" label="Username" id="username"/><span id="msg"></span>
    <s:textfield name="password" label="Password"/>
    <s:submit value="Submit"/>
</s:form>
<script>
    $(function () {
        $("#username").blur(function () {
            $.get("${pageContext.request.contextPath}/checkUser",
                {
                    username: $("#username").val()
                },
                function (data, status) {
                    var msg = $("#msg");

                    if(data.resultJsonData!==null && data.resultJsonData.result===true){
                        msg.html(data.resultJsonData.resultMessage);
                    }else{
                        msg.html("可以使用");
                    }
                }
            )
        })

    })
</script>
</body>
</html>
