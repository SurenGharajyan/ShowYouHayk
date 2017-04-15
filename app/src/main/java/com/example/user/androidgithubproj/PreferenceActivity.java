package com.example.user.androidgithubproj;


import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class PreferenceActivity extends AppCompatActivity {
    Button btn_adder,btn_sender,btn_closer;
    EditText editText_tal,editText_vercnel;
    SharedPreferences sharedPreferences;
    RelativeLayout rel_preference;
    int l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        editText_tal=(EditText) findViewById(R.id.ed_sPref);
        editText_vercnel=(EditText) findViewById(R.id.edit_sends);
        btn_adder=(Button) findViewById(R.id.btn_add);
        btn_adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup(v);
            }
        });
        btn_closer=(Button) findViewById(R.id.close_preference_btn);
        btn_closer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_sender=(Button) findViewById(R.id.btn_send);
        btn_sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tal();
            }
        });
        /*editText_tal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l++;
                Log.d("l=", String.valueOf(l));
                if(l%2==0){
                    hideSoftKeyboard(PreferenceActivity.this);
                }
            }
        });*/
        rel_preference=(RelativeLayout) findViewById(R.id.activity_preference);
        rel_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(PreferenceActivity.this);
            }
        });
    }
    static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    void vercnel() {
        sharedPreferences=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("artahaytutyun",editText_tal.getText().toString());
        editor.commit();
    }
    void tal() {
        sharedPreferences=getPreferences(MODE_PRIVATE);
        editText_vercnel.setText(sharedPreferences.getString("artahaytutyun",""));
    }
    void popup(View v) {
        PopupMenu popupMenu=new PopupMenu(PreferenceActivity.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_copy_cut,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cut_edittext:
                        vercnel();
                        editText_tal.setText("");
                        break;
                    case R.id.copy_edittext:
                        vercnel();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}


