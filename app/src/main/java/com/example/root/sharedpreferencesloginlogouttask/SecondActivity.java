package com.example.root.sharedpreferencesloginlogouttask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView welcome_tv;
    private SharedPreferences getmSp;
    private String name;
    SharedPreferences.Editor editSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcome_tv=(TextView)findViewById(R.id.welcome_tv);


        getmSp=getSharedPreferences("credential",MODE_PRIVATE);
        name=getmSp.getString("usrname",null);
        welcome_tv.setText("Welcome "+name);



    }

    public void logout(View view)
    {
        editSp = getmSp.edit();
        editSp.putString("usrname", "");
        editSp.commit();
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }




}
