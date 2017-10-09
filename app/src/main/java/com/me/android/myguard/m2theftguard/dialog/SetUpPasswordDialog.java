package com.me.android.myguard.m2theftguard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.me.android.myguard.R;

/**
 * Created by Administrator on 2017/9/28.
 */

public class SetUpPasswordDialog extends Dialog implements View.OnClickListener {
    /**
     * Creates a dialog window that uses the default dialog theme.
     * <p>
     * The supplied {@code context} is used to obtain the window manager and
     * base theme used to present the dialog.
     *
     * @param context the context in which the dialog should run
     * @see android.R.styleable#Theme_dialogTheme
     */


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    /**标题栏*/
    private TextView mTitleTV;
    /**首次输入密码文本框*/
    public EditText mFirstPWDET;
    /**确认密码文本框*/
    public EditText mAffirmET;
    /**回调接口*/
   private MyCallBack myCallBack;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.setup_password_dialog);
        super.onCreate(savedInstanceState);
        initView();
    }
  public SetUpPasswordDialog(@NonNull Context context){
    super(context,R.style.dialog_custom);
  }
    private void initView() {
        mTitleTV=(TextView)findViewById(R.id.tv_setuppwd_title);
        mFirstPWDET=(EditText)findViewById(R.id.et_firstpwd);
        mAffirmET=(EditText)findViewById(R.id.et_affirm_password);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }
  public void setTitle(String title){
      if(!TextUtils.isEmpty(title)){
          mTitleTV.setText(title);
      }
  }

  public void setCallBack(MyCallBack myCallBack){
      this.myCallBack=myCallBack;
  }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ok:
                System.out.print("SetupPasswordDialog");
                myCallBack.ok();
                break;
            case R.id.btn_cancel:
                 myCallBack.cancel();
                break;

        }

    }
    public interface MyCallBack{
        void ok();
        void cancel();
    }
}
