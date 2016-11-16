package com.itchunyang.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.itchunyang.fragment.fragment.MyDialogFragment;

/**
 * fragment是3.0以后的东西
 * 1、fragmentactivity 继承自activity，用来解决android3.0 之前没有fragment的api，所以在使用的时候需要导入support包，框架Activity需要继承FragmentActivity，这样在activity中就能嵌入fragment来实现你想要的布局效果。
 * 当然3.0之后你就可以直接继承自Activity，并且在其中嵌入使用fragment了。
 *
 * 2、获得Manager的方式也不同
 *      3.0以下：getSupportFragmentManager()
 *      3.0以上：getFragmentManager()
 *
 *
 * ListFragment
 *      ListFragment的内容是以列表(list)的形式显示的。ListFragment的布局默认包含一个list view.
 *      因此，在ListFragment对应的布局文件中，必须指定一个 Android:id 为 “@android:id/list” 的ListView控件
 *
 * DialogFragment在android 3.0时被引入。是一种特殊的Fragment，用于在Activity的内容之上展示一个模态的对话框
 * 使用DialogFragment来管理对话框，当旋转屏幕和按下后退键时可以更好的管理其声明周期
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragment(View view) {
        startActivity(new Intent(this,GeneralFragmentActivity.class));
    }

    public void communication(View view) {
        startActivity(new Intent(this, CommunicationActivity.class));

    }

    public void listFragment(View view) {
        startActivity(new Intent(this, ListFragmentActivity.class));
    }

    public void dialogFragment(View view) {

        /**
         * 为了不重复显示dialog，在显示对话框之前移除正在显示的对话框。
         */
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("MyDialogFragment");
        if (null != fragment) {
            ft.remove(fragment);
        }

        //上面的那个空白的title好丑 getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE)
        new MyDialogFragment().show(getFragmentManager(),"MyDialogFragment");
    }
}
