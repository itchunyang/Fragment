package com.itchunyang.fragment.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.itchunyang.fragment.R;

/**
 * Created by lcy on 2016/11/15.
 */

public class MyDialogFragment extends DialogFragment {

    //重写onCreateView()是fragment的传统方式，适合自定义的对话框
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.fragment_dialog,container,false);
    }


    //就没有一种快一点的方式来建立对话框么？快用onCreatDialog吧！
    //通过它返回的是一个Dialog对象，这个对象就会被显示到屏幕上
    //千万别同时使用onCreatView和onCreatDialog方法，他们仅仅是为了完成同样一个目的的两条路而已。
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("用户申明")
//                .setMessage("hello world")
//                .setPositiveButton("我同意", null)
//                .setNegativeButton("不同意", null)
//                .setCancelable(false);
//
//        return builder.create();
//    }
}
