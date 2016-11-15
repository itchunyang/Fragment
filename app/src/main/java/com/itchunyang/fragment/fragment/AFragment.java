package com.itchunyang.fragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itchunyang.fragment.R;

/**
 * Created by lcy on 2016/11/15.
 */

public class AFragment extends Fragment implements View.OnClickListener {

    private Button loginBtn;
    private Button cancelBtn;
    private EditText userEdit;
    private EditText passwordEdit;
    private OnLoginListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        loginBtn = (Button) view.findViewById(R.id.btn_login);
        cancelBtn = (Button) view.findViewById(R.id.btn_cancel);
        userEdit = (EditText) view.findViewById(R.id.et_user);
        passwordEdit = (EditText) view.findViewById(R.id.et_password);
        loginBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (userEdit.getText().toString().isEmpty() || passwordEdit.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    listener.onLogin(userEdit.getText().toString(), passwordEdit.getText().toString());
                }
                break;

            case R.id.btn_cancel:
                listener.onCancel();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(getActivity() instanceof OnLoginListener)) {
            System.out.println("Activity is not instanceof OnLoginListener");
        } else
            listener = (OnLoginListener) getActivity();
    }

    //Fragment 向Activity传递数据
    public interface OnLoginListener {
        void onLogin(String name, String password);

        void onCancel();
    }
}
