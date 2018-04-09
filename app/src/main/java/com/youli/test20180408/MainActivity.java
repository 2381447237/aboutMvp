package com.youli.test20180408;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginView,View.OnClickListener{

    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    private EditText username,password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loginPresenter=initPresenter();//初始化presenter
    }

    public LoginPresenter initPresenter(){

        return new LoginPresenter(new UserModel(),this);
    }

    private void initView(){

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        progressDialog =new ProgressDialog(this);
        login.setOnClickListener(this);

    }

    @Override
    public void showLoading(String msg) {

        progressDialog.setMessage(msg);
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }

    }

    @Override
    public void hideLoading() {

        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    public void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return password.getText().toString().trim();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.login:
                loginPresenter.login();
                break;
        }

    }

    @Override
    protected void onDestroy() {

        if(loginPresenter!=null){
            loginPresenter=null;
        }
        super.onDestroy();
    }
}
