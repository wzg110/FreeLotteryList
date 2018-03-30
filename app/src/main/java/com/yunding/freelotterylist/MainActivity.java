package com.yunding.freelotterylist;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Button;
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
    private Button btn_click;

    private  int []  count={0,0,0,0,0,
            0,0,0,0,0,0
            ,0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        fullScreen(this);
        list=this.findViewById(R.id.lv_data);
        swipe=this.findViewById(R.id.swipe);
        btn_click=this.findViewById(R.id.btn_click);
        swipe.setOnRefreshListener(this);
        mAdapter=new DataAdapter(mdataList,this);
        list.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        firstRequestTime=System.currentTimeMillis();
        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i){
                    case  SCROLL_STATE_TOUCH_SCROLL:
//                        表示正在滚动
                        btn_click.setVisibility(View.GONE);
                        break;
                    case  SCROLL_STATE_FLING:
//                        表示手指做了抛的动作
                        break;
                    case SCROLL_STATE_IDLE:
//                        表示屏幕已停止

                        btn_click.setVisibility(View.VISIBLE);
                        break;
                }

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("asda");
                builder.create().show();

            }
        });
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
                        
                        precent();
                        mAdapter.setNewData(mdataList);
                    }else{
//                        Toast.makeText(MainActivity.this,"错了",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"错了",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void precent() {
if (mdataList==null||mdataList.isEmpty()){
    Toast.makeText(MainActivity.this,"错了",Toast.LENGTH_SHORT).show();
}else{

    for (int i=0;i<mdataList.size();i++){

        String[] aaaa = mdataList.get(i).getOpencode().split("\\+");


        if (aaaa[i].contains("01")){
            count[0]=count[0]+1;
        }else if (aaaa[i].contains("02")){
            count[1]=count[1]+1;
        }
        else if (aaaa[i].contains("03")){
            count[2]=count[2]+1;
        }else if (aaaa[i].contains("04")){
            count[3]=count[3]+1;
        }else if (aaaa[i].contains("05")){
            count[4]=count[4]+1;
        }else if (aaaa[i].contains("06")){
            count[5]=count[5]+1;
        }else if (aaaa[i].contains("07")){
            count[6]=count[6]+1;
        }else if (aaaa[i].contains("08")){
            count[7]=count[7]+1;
        }else if (aaaa[i].contains("09")){
            count[8]=count[8]+1;
        }else if (aaaa[i].contains("10")){
            count[9]=count[9]+1;
        }else if (aaaa[i].contains("11")){
            count[10]=count[10]+1;
        }else if (aaaa[i].contains("12")){
            count[11]=count[11]+1;
        }else if (aaaa[i].contains("13")){
            count[12]=count[12]+1;
        }else if (aaaa[i].contains("14")){
            count[13]=count[13]+1;
        }else if (aaaa[i].contains("15")){
            count[14]=count[14]+1;
        }else if (aaaa[i].contains("16")){
            count[15]=count[15]+1;
        }else if (aaaa[i].contains("17")){
            count[16]=count[16]+1;
        }else if (aaaa[i].contains("18")){
            count[17]=count[17]+1;
        }else if (aaaa[i].contains("19")){
            count[18]=count[18]+1;
        }else if (aaaa[i].contains("20")){
            count[19]=count[19]+1;
        }else if (aaaa[i].contains("21")){
            count[20]=count[20]+1;
        }else if (aaaa[i].contains("22")){
            count[21]=count[21]+1;
        }else if (aaaa[i].contains("23")){
            count[22]=count[22]+1;
        }else if (aaaa[i].contains("24")){
            count[23]=count[23]+1;
        }else if (aaaa[i].contains("25")){
            count[24]=count[24]+1;
        }else if (aaaa[i].contains("26")){
            count[25]=count[25]+1;
        }else if (aaaa[i].contains("27")){
            count[26]=count[26]+1;
        }else if (aaaa[i].contains("28")){
            count[27]=count[27]+1;
        }else if (aaaa[i].contains("29")){
            count[28]=count[28]+1;
        }else if (aaaa[i].contains("30")){
            count[29]=count[29]+1;
        }else if (aaaa[i].contains("31")){
            count[30]=count[30]+1;
        }else if (aaaa[i].contains("32")){
            count[31]=count[31]+1;
        }else if (aaaa[i].contains("33")){
            count[32]=count[32]+1;
        }
    }



}

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
