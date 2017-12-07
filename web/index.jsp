<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
<s:form action="saveUser">
    <s:textfield name="username" label="username" id="username"/><span id="msg"></span>
    <s:textfield name="password" label="password"/>
    <s:submit value="submit"/>
</s:form>

<script>
    $(function () {
        $("#username").blur(function () {
            $.get(
                "${pageContext.request.contextPath}/checkUser",
                {
                    username: $("#username").val()
                },
                function(data){
                    console.log(data);
                    if(data.resultJsonData!== null){
                        $("#msg").html(data.resultJsonData.resultMessage);
                    }
                }
            )
        })
    })
</script>

</body>
</html>
