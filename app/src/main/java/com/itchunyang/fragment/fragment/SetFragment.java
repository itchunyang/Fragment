package com.itchunyang.fragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itchunyang.fragment.R;

/**
 * Created by lcy on 2016/11/15.
 */

public class SetFragment extends Fragment{

    public static final String TAG = SetFragment.class.getSimpleName();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_set, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach: context");
        super.onAttach(context);
    }

    //此方法在sdk23过时，改成了
    // public void onAttach(Context context) {
    // super.onAttach(context);
    // }.
    //但是，你如果集成context那个(上面的)，低版本系统就不调用他
    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach: Activity");
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach: ");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
