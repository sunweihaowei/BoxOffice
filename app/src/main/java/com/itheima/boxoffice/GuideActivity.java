package com.itheima.boxoffice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GuideActivity extends AppCompatActivity {
    private ViewPager vp;
    private List<ImageView> imageViews = new ArrayList<>();
    private int[] intImage = new int[]{R.drawable.guide1, R.drawable.guide2, R.drawable.guide4};
    private TextView tv_hello;
    private TextView tv_hint;
    private ImageView iv;
    private Handler handler=new Handler(  ){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            if (msg.what==1){
                iv.setImageBitmap( (Bitmap) msg.obj );
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        final SharedPreferences sharedPreferences = getSharedPreferences( "guide", MODE_PRIVATE );
        String name = sharedPreferences.getString( "name", null );
        if (name != null) {//guide文件不为空的时候，直接跳转
            vp.setVisibility( View.GONE );
            iv.setVisibility( View.VISIBLE );
            Timer timer=new Timer(  );
            TimerTask timerTask=new TimerTask() {
                @Override
                public void run() {
                    startActivity( new Intent( GuideActivity.this,MainActivity.class ) );
                }
            };
            timer.schedule( timerTask,5000 );

        }
        listImageView();
        MyAdapter adapter = new MyAdapter();
        vp.setAdapter( adapter );
        vp.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                switch (i) {
                    case 0:
                        tv_hello.setVisibility( View.VISIBLE );
                        tv_hint.setVisibility( View.INVISIBLE );
                        break;
                    case 1:
                        tv_hello.setVisibility( View.INVISIBLE );
                        tv_hint.setVisibility( View.INVISIBLE );
                        break;
                    case 2:
                        tv_hello.setVisibility( View.INVISIBLE );
                        tv_hint.setVisibility( View.VISIBLE );
                       /* Animation animation = AnimationUtils.loadAnimation( GuideActivity.this, R.anim.all_animation );*/
                        /*tv_hint.setAnimation( animation );
                        animation.start();*/
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString( "name", "jjj" );
                        edit.commit();
                        Timer timer = new Timer();
                        TimerTask timerTask = new TimerTask() {
                            @Override
                            public void run() {
                                startActivity( new Intent( GuideActivity.this, MainActivity.class ) );

                            }
                        };
                        timer.schedule( timerTask, 7000 );
                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        } );
        new Thread(  ){
            @Override
            public void run() {
                super.run();
                OkHttpClient okHttpClient=new OkHttpClient();
                final Request request=new Request.Builder().url( "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=650565685,3750903649&fm=26&gp=0.jpg" )
                        .build();
                Call call=okHttpClient.newCall( request );
                call.enqueue( new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText( GuideActivity.this,"请求Failure", Toast.LENGTH_LONG ).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        InputStream inputStream = response.body().byteStream();
                        Bitmap bitmap= BitmapFactory.decodeStream( inputStream );
                        Message message=handler.obtainMessage();
                        message.what=1;
                        message.obj=bitmap;
                        handler.sendMessage( message );
                    }
                } );
            }
        }.start();
    }

    private void listImageView() {
        for (int i = 0; i < intImage.length; i++) {
            ImageView imageView = new ImageView( GuideActivity.this );
            imageView.setBackgroundResource( intImage[i] );
            imageViews.add( imageView );
        }
    }

    private void initView() {
        vp = (ViewPager) findViewById( R.id.vp );
        tv_hello = (TextView) findViewById( R.id.tv_hello );
        tv_hint = (TextView) findViewById( R.id.tv_hint );
        iv = (ImageView) findViewById( R.id.iv );
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView( imageViews.get( position ) );
            return imageViews.get( position );
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView( (View) object );
        }
    }


}
