package com.example.swipepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.AnimatedImageDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.webkit.WebSettings;
import android.widget.ZoomButton;

import com.example.swipepage.adapterClass.AdapterClass;

public class MainActivity extends  AppCompatActivity {

    AdapterClass adapterClass;
    ViewPager2 pager2;
    int list[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager2 = findViewById(R.id.view_pager2);
        list = new int[3];


        list[0] = R.drawable.athlete;
        list[1] = R.drawable.athlete;

        list[2] = R.drawable.athlete;


        adapterClass = new AdapterClass(list);
        //SET ADAPTER
        pager2.setAdapter(adapterClass);
       pager2.setClipToPadding(false);
        pager2.setClipChildren(false);
        pager2.setOffscreenPageLimit(4);
        pager2.setCurrentItem(0,true);

       // pager2(-450);





        //pager2.setClipToPadding(true);
        CompositePageTransformer transformer = new CompositePageTransformer();

        transformer.addTransformer(new ViewPager2.PageTransformer() {


            @Override
            public void transformPage(@NonNull View page, float position) {

     /*           float a = -1f*Math.abs(position);
                page.setScaleY(.85f+a *.1f);
                page.setScaleX(.85f-a*.85f);
*/


                float a = -.85f+Math.abs(position);
                page.setScaleY(.85f-a*.255f);



            }
        });

        pager2.setPageTransformer(transformer);


    }

}
