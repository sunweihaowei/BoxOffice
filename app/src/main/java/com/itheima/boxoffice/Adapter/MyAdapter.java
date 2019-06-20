package com.itheima.boxoffice.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itheima.boxoffice.R;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private final List <Map <String, Object>> mapList;

    public MyAdapter(Context context, List<Map<String, Object>> mapList) {
        this.context=context;
        this.mapList=mapList;
    }

    @Override
    public int getCount() {
        return mapList.size();
    }

    @Override
    public Object getItem(int position) {
        return mapList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate( context, R.layout.item_main_lv,null );
        TextView power=view.findViewById( R.id.power );
        TextView tv_name=view.findViewById( R.id.tv_name );
        TextView tv_showDay=view.findViewById( R.id.tv_showDay );
        TextView tv_sumBoxOffice=view.findViewById( R.id.tv_sumBoxOffice );
        TextView tv_boxOffice=view.findViewById( R.id.tv_boxOffice );
        TextView tv_boxPercent=view.findViewById( R.id.tv_boxPercent );
        tv_boxOffice.setText( mapList.get( position ).get( "boxOffice" ).toString() );
        tv_boxPercent.setText( mapList.get( position ).get( "BoxPercent" ).toString() );
        tv_name.setText( mapList.get( position ).get( "Name" ).toString() );
        power.setText( mapList.get( position ).get( "Rank" ).toString() );
        tv_showDay.setText( mapList.get( position ).get( "ShowDay" ).toString()+"天" );
        tv_sumBoxOffice.setText( mapList.get( position ).get( "SumBoxOffice" ).toString() );
        return view;
    }
}
