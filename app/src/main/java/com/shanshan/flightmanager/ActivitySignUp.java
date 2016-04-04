package com.shanshan.flightmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivitySignUp extends Activity {

    private EditText userId;
    private EditText userPassword;
    private EditText passwordConfirm;
    private Button signUp;
    private EditText userAge;
    private RadioGroup mRadioGroup;
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_sign_up);

        userId = (EditText) findViewById(R.id.editText);
        userPassword = (EditText) findViewById(R.id.editText2);
        passwordConfirm = (EditText) findViewById(R.id.editText3);
        signUp = (Button) findViewById(R.id.sign_up_button);
        userAge = (EditText) findViewById(R.id.editText4);
        userName = (EditText) findViewById(R.id.editText21);
        userAge.setInputType(EditorInfo.TYPE_CLASS_NUMBER);

        mRadioGroup = (RadioGroup) findViewById(R.id.radio);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FlightManagerDB.getInstance(ActivitySignUp.this)
                        .searchUser(userId.getText().toString()).getId()==null) {
                    if(userPassword.getText().toString().length() >= 6){
                        if(userPassword.getText().toString().equals(passwordConfirm.getText()
                                .toString())){
                            UserDatas userDatas = new UserDatas();

                            userDatas.setId(userId.getText().toString());
                            userDatas.setPassword(userPassword.getText().toString());
                            userDatas.setSex(mRadioGroup.getCheckedRadioButtonId()
                                    == R.id.male ? "男":"女");
                            userDatas.setName(userName.getText().toString());
                            userDatas.setAge(Integer.parseInt(userAge.getText().toString()));
                            FlightManagerDB.getInstance(ActivitySignUp.this).saveUser(userDatas);
                            Toast.makeText(ActivitySignUp.this, "注册成功", Toast.LENGTH_LONG ).show();
                            finish();
                        }else{
                            Toast.makeText(ActivitySignUp.this, "密码不一致", Toast.LENGTH_LONG ).show();
                        }
                    }else{
                        Toast.makeText(ActivitySignUp.this, "密码长度应至少六位", Toast.LENGTH_LONG ).show();
                    }
                }else{
                    Toast.makeText(ActivitySignUp.this, "此用户已被注册", Toast.LENGTH_LONG ).show();
                }
            }
        });



    }
}
