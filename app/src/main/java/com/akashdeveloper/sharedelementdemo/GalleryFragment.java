package com.akashdeveloper.sharedelementdemo;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    int a;
    private ArrayList<MediaStore.Images.Media> dataset;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            a = getArguments().getInt("key");
        }
        setSharedElementEnterTransition(new ChangeBounds());
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.gallery_screen,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        postponeEnterTransition();
        final ViewPager viewPager = view.findViewById(R.id.view_pager);
        GalleryPagerAdapter galleryPagerAdapter = new GalleryPagerAdapter(getActivity(), new GalleryPagerAdapter.ImageLoadListener() {
            @Override
            public void onImageLoaded() {
                startPostponedEnterTransition();
            }
        });
        viewPager.setAdapter(galleryPagerAdapter);
        viewPager.setCurrentItem(a);

    }
}
