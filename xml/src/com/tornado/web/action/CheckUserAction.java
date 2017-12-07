package com.tornado.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tornado.domain.User;
import com.tornado.service.UserService;
import com.tornado.web.vo.ResultJsonData;

public class CheckUserAction extends ActionSupport {

    private String username;

    private ResultJsonData resultJsonData;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String check() {
        User user = userService.checkUserByUsername(username);

        if (user != null) {
            resultJsonData = new ResultJsonData();

            resultJsonData.setResult(true);
            resultJsonData.setResultCode(101);
            resultJsonData.setResultMessage("已被使用");
        }

        return SUCCESS;
    }

    public ResultJsonData getResultJsonData() {
        return resultJsonData;
    }

    public void setResultJsonData(ResultJsonData resultJsonData) {
        this.resultJsonData = resultJsonData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
