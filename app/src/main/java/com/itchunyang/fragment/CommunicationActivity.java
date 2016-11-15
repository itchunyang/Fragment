package com.itchunyang.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.itchunyang.fragment.fragment.AFragment;

public class CommunicationActivity extends AppCompatActivity implements AFragment.OnLoginListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
    }

    //AFragment回调函数
    @Override
    public void onLogin(String name, String password) {
        Toast.makeText(this,"登陆成功 user="+name+" password="+password,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel() {
        Toast.makeText(this,"登陆取消",Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        getFragmentManager().beginTransaction().replace(R.id.container_right,new AFragment()).commit();
    }
}
