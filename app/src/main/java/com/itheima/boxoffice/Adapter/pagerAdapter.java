package com.itheima.boxoffice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.boxoffice.MainActivity;

import java.util.List;

public class pagerAdapter extends PagerAdapter {
    private final Context context;
    private final List<View> viewList;
    private final List<String> nameList;

    public pagerAdapter(Context context, List<View> viewList, List<String> nameList) {
        this.context=context;
        this.viewList=viewList;
        this.nameList=nameList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return nameList.get(position);
    }
}
