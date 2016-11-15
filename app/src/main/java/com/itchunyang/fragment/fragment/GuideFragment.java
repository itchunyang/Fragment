package com.itchunyang.fragment.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.itchunyang.fragment.R;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lcy on 2016/11/15.
 */

public class GuideFragment extends Fragment implements View.OnClickListener{

    private ImageView iv;
    private Button btnDownload;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            iv.setImageBitmap((Bitmap) msg.obj);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide,container,false);

        iv = (ImageView) view.findViewById(R.id.iv);
        btnDownload = (Button) view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(getArguments().getString("address"));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                    Message message = Message.obtain(handler,0,bitmap);
                    message.sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
