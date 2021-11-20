package com.example.osmantahir_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {
    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {
        ImageView img = (ImageView)findViewById(R.id.ImageView_Bird);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp01);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp02);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp03);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp04);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp05);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp06);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp07);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp08);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp09);
        BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp10);
        BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp11);
        BitmapDrawable frame12 = (BitmapDrawable)getResources().getDrawable(R.drawable.lamp12);




        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);
        mframeAnimation.addFrame(frame10, reasonableDuration);
        mframeAnimation.addFrame(frame11, reasonableDuration);
        mframeAnimation.addFrame(frame12, reasonableDuration);




        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}