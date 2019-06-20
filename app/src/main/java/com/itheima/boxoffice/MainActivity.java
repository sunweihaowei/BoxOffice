package com.itheima.boxoffice;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
/*import com.itheima.PullToRefreshView;*/
import com.itheima.boxoffice.Adapter.MyAdapter;
import com.itheima.boxoffice.bean.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private TextView tv_sumBoxOffice;
    private ListView lv;
    /*private PullToRefreshView pulltorefreshView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage( msg );

                if (msg.what == 1) {
                    String json = (String) msg.obj;
                    Gson gson = new Gson();

                     main main = gson.fromJson( json, main.class );
                    final List <Map <String, Object>> mapList = new ArrayList <>();
                    Map <String, Object> map;
                    String realTimeBoxOffice = main.getShowapi_res_body().getRealTimeRank().getRealTimeBoxOffice();
                    for (int i = 0; i < 10; i++) {
                        String boxOffice = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getBoxOffice();
                        String BoxPercent = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getBoxPercent();
                        String Name = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getName();
                        String Rank = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getRank();
                        String ShowDay = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getShowDay();
                        String SumBoxOffice = main.getShowapi_res_body().getRealTimeRank().getMovieRank().get( i ).getSumBoxOffice();
                        map = new HashMap <>();
                        map.put( "boxOffice", boxOffice );
                        map.put( "BoxPercent", BoxPercent );
                        map.put( "Name", Name );
                        map.put( "Rank", Rank );
                        map.put( "ShowDay", ShowDay );
                        map.put( "SumBoxOffice", SumBoxOffice );
                        mapList.add( map );
                    }
                    tv_sumBoxOffice.setText( realTimeBoxOffice );
                    MyAdapter adapter = new MyAdapter( MainActivity.this, mapList );
                    lv.setAdapter( adapter );
                    lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                        }
                    } );


                }
            }
        };
       /* pulltorefreshView.setOnRefreshListener( new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {



                        pulltorefreshView.setRefreshing( false );
                    }

        } );*/
        getjson();
    }
    private void getjson() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url( "https://route.showapi.com/1821-1?showapi_appid=97930&showapi_timestamp=20190617123611&showapi_sign=9756795fe56241b2bedfb89cb8bcc1b9" )
                        .build();
                Call call = okHttpClient.newCall( request );
                call.enqueue( new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e( null, "获取网络失败" );
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Message message = handler.obtainMessage();
                        message.what = 1;
                        message.obj = string;
                        handler.sendMessage( message );
                    }
                } );
            }
        }.start();
    }


    private void initView() {
        tv_sumBoxOffice = (TextView) findViewById( R.id.tv_sumBoxOffice );
        lv = (ListView) findViewById( R.id.lv );
        /*pulltorefreshView = (PullToRefreshView) findViewById( R.id.pulltorefreshView );*/
    }
}
