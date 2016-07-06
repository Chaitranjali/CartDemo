package com.example.chaiii.cartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display, qty;
    int count;
    private ImageView add, sub;
    private Button btn;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.textView);
        qty = (TextView) findViewById(R.id.qty);
        btn = (Button) findViewById(R.id.button);
        add = (ImageView) findViewById(R.id.loki);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                display.setText(String.valueOf(count));
                display.setVisibility(v.VISIBLE);
                sub.setVisibility(v.VISIBLE);
                if (count == 1) {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);
                    add.startAnimation(animation);
             /*   overridePendingTransition(R.anim.right_in,R.anim.left_in);*/
                }
                qty.setVisibility(v.VISIBLE);
                btn.setVisibility(v.VISIBLE);
                btn.setText(String.valueOf(count));
            }
        });
        sub = (ImageView) findViewById(R.id.choti);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 0) {
                    count = 0;
                    display.setText(count + "");
                }
                if (count > 0) {
                    count = count - 1;
                    display.setText(count + "");
                    if (count == 0) {
                        sub.setVisibility(v.GONE);
                    }
                }
                //  Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                // sub.startAnimation(animation1);
                display.setVisibility(v.VISIBLE);

               /* overridePendingTransition(R.anim.right_out,
                        R.anim.left_out);*/
                qty.setVisibility(v.VISIBLE);
                btn.setVisibility(v.VISIBLE);
                btn.setText(String.valueOf(count));
            }
        });

    }
}
