package com.tornado.web.action;


import com.opensymphony.xwork2.ActionSupport;
import com.tornado.domain.Order;
import com.tornado.domain.User;
import com.tornado.service.OrderService;
import com.tornado.service.UserService;
import com.tornado.utils.PageBean;
import com.tornado.web.vo.ResultJsonData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;

@ParentPackage("json-default")
@Results({@Result(name = "success", type = "json")})
public class CheckUserAction extends ActionSupport {

    @Resource
    private UserService userService;

    private String username;

    private ResultJsonData resultJsonData;

    @Action("checkUser")
    public String check() {
        User user = userService.checkUserByUsername(username);

        resultJsonData = new ResultJsonData();

        if (user != null) {
            resultJsonData.setResult(true);
            resultJsonData.setResultCode(user.getId());
            resultJsonData.setResultMessage("no!");
        } else {
            resultJsonData.setResult(false);
            resultJsonData.setResultCode(0);
            resultJsonData.setResultMessage("yes!");
        }

        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ResultJsonData getResultJsonData() {
        return resultJsonData;
    }

    public void setResultJsonData(ResultJsonData resultJsonData) {
        this.resultJsonData = resultJsonData;
    }
}
