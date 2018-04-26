package com.example.root.sharedpreferencesloginlogouttask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText usrname_etv;
    private SharedPreferences getmSp;
    private SharedPreferences.Editor editmSp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrname_etv=(EditText)findViewById(R.id.usrname_etv);
        getmSp=getSharedPreferences("credential",MODE_PRIVATE);
        editmSp=getmSp.edit();

        if (!TextUtils.isEmpty(getmSp.getString("usrname",null))) {
            openHomeActivity();
        }

    }

    public void login(View view)
    {
        if (!TextUtils.isEmpty(usrname_etv.getText().toString())) {
            editmSp.putString("usrname", usrname_etv.getText().toString());
            editmSp.commit();
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!TextUtils.isEmpty(getmSp.getString("usrname",null))) {
            finish();
        }
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
