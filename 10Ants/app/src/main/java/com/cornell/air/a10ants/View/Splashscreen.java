package com.cornell.air.a10ants.View;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.cornell.air.a10ants.Menu.MenuFrame;
import com.cornell.air.a10ants.R;

/**
 * Created by ivy on 5/11/2017.
 */

public class Splashscreen extends AppCompatActivity {

    ProgressBar mprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

        ImageView img = (ImageView) findViewById(R.id.imageView);

        Animation anim = AnimationUtils.loadAnimation(this , R.anim.anim_down);
        img.setAnimation(anim);

        mprogressbar = (ProgressBar) findViewById(R.id.progressBar) ;

        ObjectAnimator animation = ObjectAnimator.ofInt(mprogressbar , "progress" ,0,100);
        animation.setDuration(5000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splashscreen.this, Login.class));
                finish();
            }
        }, 5000);
    }
}
