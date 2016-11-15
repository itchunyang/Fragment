package com.itchunyang.fragment.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lcy on 2016/11/15.
 */

public class MyDialogFragment extends DialogFragment {

    //重写onCreateView()是fragment的传统方式，适合自定义的对话框
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 对于简单的对话框，可以通过AlterDialog.Builder直接创建对话框的UI，本例用于告警框.
     * AlertDialog.Builder在Android 3.0版本之前的创建对话框方式，在之后的版本中，可用在DialogFragment中，适用于创建简单对话框。
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
