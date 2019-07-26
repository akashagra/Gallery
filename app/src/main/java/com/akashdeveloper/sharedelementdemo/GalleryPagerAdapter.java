package com.akashdeveloper.sharedelementdemo;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.util.ArrayList;

class GalleryPagerAdapter extends PagerAdapter {
    Context mContext;
    ImageLoadListener mListener;

    interface ImageLoadListener{
        void onImageLoaded();
    }

    public GalleryPagerAdapter(FragmentActivity activity, ImageLoadListener listener) {
        mContext = activity;
        mListener = listener;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.drawee_view, null);
        SimpleDraweeView imageView = view.findViewById(R.id.image);
        ControllerListener listener = new BaseControllerListener<ImageInfo>() {

            @Override
            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                mListener.onImageLoaded();
            }
            @Override
            public void onFailure(String id, Throwable throwable) {
                mListener.onImageLoaded();
            }

        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(getUri(position))
                .setControllerListener(listener)
                .build();

        imageView.setController(controller);
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

    private String getUri(int position) {
        switch (position) {
            case 0:
                return "https://www.themealdb.com/images/category/dessert.png";
            case 1:
                return "https://www.themealdb.com/images/category/pasta.png";
            case 2:
                return "https://www.themealdb.com/images/category/side.png";
            case 3:
                return "https://www.themealdb.com/images/category/starter.png";
            default:
                return "https://www.themealdb.com/images/category/dessert.png";
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
