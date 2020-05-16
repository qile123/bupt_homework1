package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Integer;
import java.util.regex.Pattern;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.transform);
        CheckBox cB =  findViewById(R.id.black);
        cB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    TextView textc = findViewById (R.id.textC);
                    TextView texth = findViewById (R.id.textH);
                    textc.setTextColor(Color.parseColor("#FF0000"));//设置颜色
                    texth.setTextColor(Color.parseColor("#FF0000"));//设置颜色
                    Log.d("checkbox", "onCheckedChanged: 字体变换为红色");

                }else{
                    TextView textc = findViewById (R.id.textC);
                    TextView texth = findViewById (R.id.textH);
                    textc.setTextColor(Color.parseColor("#272727"));//设置颜色
                    texth.setTextColor(Color.parseColor("#272727"));//设置颜色
                    Log.d("checkbox", "onCheckedChanged: 字体变换为黑色");
                }
            }});
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextC = findViewById (R.id.temperatureC);
                String s = editTextC.getText().toString();
                if(isInteger(s))
                {
                    int T_c = Integer.parseInt(s);
                    double T_f = T_c * 0.3048;
                    String res = String.valueOf(T_f);
                    TextView resT = findViewById (R.id.textViewRes);
                    resT.setText(res);
                    resT.setTextSize(18);
                    Log.d("button", "onButtonChanged: 开始单位转换");
                }
            }
        });
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
