package com.youli.test20180408;

/**
 * Created by liutao on 2018/4/8.
 */

public class LoginPresenter {

    private UserModel userModel;//model层具体实现类
    private LoginView loginView;//loginView接口

    public LoginPresenter(UserModel userModel, LoginView loginView) {
        this.userModel = userModel;
        this.loginView = loginView;
    }

    public void login(){

        loginView.showLoading("正在登录中...");//loginView的ui逻辑处理

        userModel.login(loginView.getUserName(), loginView.getPassWord(), new CallBack() {
            @Override
            public void onSuccess() {

                loginView.hideLoading();
                loginView.showResult("登录成功");

            }

            @Override
            public void onFilure(String fail) {

                loginView.hideLoading();
                loginView.showErr(fail);
            }
        });
    }
}
