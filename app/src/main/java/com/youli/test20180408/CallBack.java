package com.youli.test20180408;

/**
 * Created by liutao on 2018/4/8.
 */

public interface CallBack {

    /** * model处理逻辑：成功回调 */
   void onSuccess();

    /** * model处理逻辑：失败回调 */
   void onFilure(String fail);

}
