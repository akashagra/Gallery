package com.akashdeveloper.sharedelementdemo;

import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

class GalleryPagerAdapter extends PagerAdapter {
    Context mContext;

    public GalleryPagerAdapter(FragmentActivity activity) {
        mContext = activity;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.drawee_view, null);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageDrawable(mContext.getResources().getDrawable(getImageAt(position)));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    private int getImageAt(int position) {
        switch (position) {
            case 0:
                return R.drawable.image_one;
            case 1:
                return R.drawable.image_two;
            case 2:
                return R.drawable.image_three;
            case 3:
                return R.drawable.image_four;
            default:
                return R.drawable.image_one;
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
    }
}
