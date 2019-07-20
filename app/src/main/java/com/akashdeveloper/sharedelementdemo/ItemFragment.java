package com.akashdeveloper.sharedelementdemo;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.Map;

public class ItemFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_screen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView firstPeek = view.findViewById(R.id.peek_first);
        ImageView secondPeek = view.findViewById(R.id.peek_second);
        ImageView thirdPeek = view.findViewById(R.id.peek_third);
        ImageView fourthPeek = view.findViewById(R.id.peek_fourth);
//        WindowManager wm = (WindowManager) getContext()
//                .getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                12, displayMetrics);
//        int length = getscreenWidth(display) - 3 * padding / 3;
//
//        ConstraintLayout.LayoutParams firstImage = (ConstraintLayout.LayoutParams) firstPeek.getLayoutParams();
//        firstImage.width = length;
//        firstImage.height = length;
//        firstImage.setMargins(0, padding, 0, 0);
//
//        ConstraintLayout.LayoutParams secondImage = (ConstraintLayout.LayoutParams) secondPeek.getLayoutParams();
//        secondImage.width = length;
//        secondImage.height = length;
//        secondImage.setMargins(padding, padding, 0, 0);
//
//        firstPeek.setLayoutParams(firstImage);
//        secondPeek.setLayoutParams(secondImage);
//        thirdPeek.setLayoutParams(firstImage);
//        fourthPeek.setLayoutParams(secondImage);

        firstPeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullGallery(v, 0);
            }
        });

        secondPeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullGallery(v, 1);
            }
        });

        thirdPeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullGallery(v, 2);
            }
        });

        fourthPeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFullGallery(v, 3);
            }
        });
    }
    private void openFullGallery(final View v, int i) {
                 getFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true) // setAllowOptimization before 26.1.0
//                .addSharedElement(v, v.getTransitionName())
                .replace(R.id.container,
                        new GalleryFragment())
                .addToBackStack(null)
                .commit();

//        setExitSharedElementCallback(
//                new SharedElementCallback() {
//                    @Override
//                    public void onMapSharedElements(
//                            List<String> names, Map<String, View> sharedElements) {
//                        // Locate the ViewHolder for the clicked position.
//
//                        // Map the first shared element name to the child ImageView.
//                        sharedElements
//                                .put(names.get(0), v);
//                    }
//                });
    }

    private int getscreenWidth(Display display) {
        int columnWidth;

        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }

}
