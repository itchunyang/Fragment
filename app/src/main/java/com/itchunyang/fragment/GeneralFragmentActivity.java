package com.itchunyang.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.itchunyang.fragment.fragment.AboutFragment;
import com.itchunyang.fragment.fragment.GuideFragment;
import com.itchunyang.fragment.fragment.LoginFragment;
import com.itchunyang.fragment.fragment.SetFragment;

/**
 * Android 3.0版本以前用getSupportFragmentManager
 *      1、尽量不要用app包中的fragment，因为这个是在3.0之后才有的，支持的版本太高，在低版本中是是用不了的。
 * Android3.0版本以后用getFragmentManager
 */

public class GeneralFragmentActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_fragment);
    }

    public void setFragment(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_right,new SetFragment(),"设置");
        //把事务添加进回退管理栈，注意针对的是一次事务，次事务可以一次添加多个fragment，回退时一次性退出
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void guideFragment(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putString("address","http://c.hiphotos.baidu.com/image/pic/item/11385343fbf2b211e13b5dfacf8065380cd78e69.jpg");
        //必须要在Fragment与Activity关联之前。也就是说Fragment关联Activity后，不能用他来通信
        fragment.setArguments(bundle);
        transaction.replace(R.id.container_right,fragment,"封面");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void loginFragment(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_right,new LoginFragment(),"登录");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void aboutFragment(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_right,new AboutFragment(),"关于");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /********************************************************************************************/

    public void popFragment(View view) {
        getFragmentManager().popBackStack();
    }
}
