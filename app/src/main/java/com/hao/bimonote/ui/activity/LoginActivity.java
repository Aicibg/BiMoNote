package com.hao.bimonote.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseActivity;
import com.hao.bimonote.contract.LoginContract;
import com.hao.bimonote.presenter.LoginPresenter;
import com.hao.bimonote.ui.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_user_name)
    EditText mEtUserName;
    @BindView(R.id.et_user_password)
    EditText mEtUserPassword;
    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.bt_register)
    Button mBtRegister;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mPresenter = new LoginPresenter(this);
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(mEtUserName.getText().toString(), mEtUserPassword.getText().toString());
            }
        });

        mBtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.saveUser(mEtUserName.getText().toString(), mEtUserPassword.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        close();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(String msg) {
        mVaryViewHelperController.showLoading(msg);
    }

    @Override
    public void hideProgress() {
        mVaryViewHelperController.restore();
    }

    @Override
    public void close() {
         finish();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(this, R.id.activity_login);
    }
}
