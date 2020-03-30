package chapter.android.aweme.ss.com.homework;

import android.content.ContentUris;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);
        TextView tv_center = findViewById(R.id.tv_center);
        tv_center.setText(String.valueOf(getAllChildViewCount(findViewById(R.id.root))));
    }

    public int getAllChildViewCount(View view) {
        if(!(view instanceof ViewGroup))
            return 1;

        ViewGroup viewGroup = (ViewGroup)view;
        int end = viewGroup.getChildCount(),count = 0;
        View child;

        for(int i=0;i<end;i++)
        {
            child = viewGroup.getChildAt(i);
            count += getAllChildViewCount(child);
        }
        return count;
    }
}
