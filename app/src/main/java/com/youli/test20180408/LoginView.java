package com.youli.test20180408;

/**
 * Created by liutao on 2018/4/8.
 */

public interface LoginView {

    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    void showLoading(String msg);
    /**
     * 隐藏进度条
     */
    void hideLoading();
    /**
     * 显示登录的结果
     * @param result
     */
    void showResult(String result);
    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);
    /**
     * 获得界面上用户名的值
     * @return
     */
    String getUserName();
    /**
     * 获得界面上密码的值
     * @return
     */
    String getPassWord();
}
