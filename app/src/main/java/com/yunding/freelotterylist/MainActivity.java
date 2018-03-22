package com.yunding.freelotterylist;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yunding.freelotterylist.DataResp.LotteryBean;
import com.yunding.freelotterylist.adapter.DataAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
private ListView list;
    private SwipeRefreshLayout swipe;
    private  static  final  String url="http://f.apiplus.net/ssq-20.json";
    private DataAdapter mAdapter;
    private List<LotteryBean.DataBean> mdataList=new ArrayList<>();
    private  long firstRequestTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        fullScreen(this);
        list=this.findViewById(R.id.lv_data);
        swipe=this.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(this);
        mAdapter=new DataAdapter(mdataList,this);
        list.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        firstRequestTime=System.currentTimeMillis();
        getData();
    }
    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT); //导航栏颜色也可以正常设置 //
//                window.setNavigationBarColor(Color.parseColor("#cccccc"));
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                attributes.flags |= flagTranslucentNavigation;

                window.setAttributes(attributes);
            }
        }
    }
    private void getData() {
        swipe.setRefreshing(true);
        OkHttpUtils.get().url(url).build()
                .connTimeOut(3000000)
                .readTimeOut(3000000)
                .writeTimeOut(3000000).execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                swipe.setRefreshing(false);
                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
                swipe.setRefreshing(false);

                try{
                    LotteryBean resp=new Gson().fromJson(response,LotteryBean.class);
                    if (resp!=null){
                        mdataList=resp.getData();
                        mAdapter.setNewData(mdataList);
                    }else{
                        Toast.makeText(MainActivity.this,"错了",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"错了",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onRefresh() {

        long time=System.currentTimeMillis();
        if (time-firstRequestTime>3000){
            firstRequestTime=System.currentTimeMillis();
            mdataList.clear();
            getData();
        }else{
            swipe.setRefreshing(false);
            Toast.makeText(MainActivity.this,"两次查询间隔三秒",Toast.LENGTH_SHORT).show();

        }

    }


}
