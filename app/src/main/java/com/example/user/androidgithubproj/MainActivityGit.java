package com.example.user.androidgithubproj;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import static com.example.user.androidgithubproj.PreferenceActivity.hideSoftKeyboard;

public class MainActivityGit extends AppCompatActivity implements View.OnClickListener {
    RadioButton red_radiobtn,blue_radiobtn,green_radiobtn;
    Button animate_btn,sharedPref_btn;
    ImageView imageview_checker;
    EditText edittext_with_none;
    RelativeLayout rel_background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_git);
        init();
    }
    void init() {
        red_radiobtn=(RadioButton) findViewById(R.id.radio_red_btn);
        red_radiobtn.setOnClickListener(this);
        blue_radiobtn=(RadioButton) findViewById(R.id.radio_blue_btn);
        blue_radiobtn.setOnClickListener(this);
        green_radiobtn=(RadioButton) findViewById(R.id.radio_green_btn);
        green_radiobtn.setOnClickListener(this);
        animate_btn=(Button) findViewById(R.id.animate_activity_btn);
        animate_btn.setOnClickListener(this);
        sharedPref_btn=(Button) findViewById(R.id.SPref_btn);
        sharedPref_btn.setOnClickListener(this);
        imageview_checker=(ImageView) findViewById(R.id.imagebtn);
        imageview_checker.setOnClickListener(this);
        edittext_with_none=(EditText) findViewById(R.id.edit_background);
        edittext_with_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext_with_none.setText("");
            }
        });
        rel_background=(RelativeLayout) findViewById(R.id.activity_main_git);
        rel_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(MainActivityGit.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Vibrator vb=(Vibrator) getSystemService(MainActivityGit.VIBRATOR_SERVICE);
        switch (v.getId()) {

            case R.id.radio_red_btn:
                rel_background.setBackgroundColor(Color.RED);
                break;

            case R.id.radio_blue_btn:
                rel_background.setBackgroundColor(Color.BLUE);
                break;

            case R.id.radio_green_btn:
                rel_background.setBackgroundColor(Color.GREEN);
                break;



            case R.id.animate_activity_btn:
                startActivity(new Intent(MainActivityGit.this,AnimateActivity.class));
                break;


            case R.id.SPref_btn:
                startActivity(new Intent(MainActivityGit.this,PreferenceActivity.class));
                break;
            case R.id.imagebtn:
                if(edittext_with_none.getText().toString().equals("none color")){
                    rel_background.setBackgroundColor(Color.WHITE);
                } else if(edittext_with_none.getText().toString().equals("close")) {
                    final AlertDialog alertDialog=new AlertDialog.Builder(MainActivityGit.this).create();
                    alertDialog.setMessage("Do you want to Close Application?");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }else {
                    Toast.makeText(MainActivityGit.this,"Write close Or none color",Toast.LENGTH_LONG).show();
                    vb.vibrate(500);
                }

                break;
        }
    }
}


