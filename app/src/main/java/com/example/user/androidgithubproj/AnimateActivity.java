package com.example.user.androidgithubproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class AnimateActivity extends AppCompatActivity {


    SeekBar seekBar_alpha,seekBar_rotate,seekBar_scale,seekBar_translate;
    Button close_btn_Anim;
    TextView text_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        init_animation();

    }
    void init_animation() {
        seekBar_alpha=(SeekBar) findViewById(R.id.seekbar_alpha);
        seekBar_rotate=(SeekBar) findViewById(R.id.seekbar_rotate);
        seekBar_scale=(SeekBar) findViewById(R.id.seekbar_scale);
        seekBar_translate=(SeekBar) findViewById(R.id.seekbar_translate);
        close_btn_Anim=(Button) findViewById(R.id.close_animate_btn);
        close_btn_Anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        text_animation=(TextView) findViewById(R.id.text_animation_change);
        text_animation.setAlpha(1.0F);


        seekBar_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_animation.animate().alpha((float) (1-progress*0.01));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_rotate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_animation.setRotation((float) (progress*3.6));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_scale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_animation.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float) (progress*1.5));
                if(progress==0) {
                    text_animation.setTextSize(20);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_translate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_animation.setTranslationY(progress*5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
            /*Snackbar.make(seekBar, "Opacity full?", Snackbar.LENGTH_LONG).setAction("Click", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text_animation.setAlpha(1.0F);
                }
            }).show();*/
    }
}