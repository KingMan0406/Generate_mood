package com.example.mylesso_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_g, btnGenerate;
    TextView tv_otvet,tv_main_answer;
    int otvetInt, getOtvetInt;
    LottieAnimationView lotty_sun,lotty_one,lotty_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lotty_sun= findViewById(R.id.lotty_sun);
        lotty_one = findViewById(R.id.lotty_one);
        lotty_two = findViewById(R.id.lotty_two);
        btnGenerate = findViewById(R.id.btn_generate);
        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_one.setAnimation(R.raw.animation_fire);
        lotty_two.setAnimation(R.raw.fun_time);
        btn_g =  findViewById(R.id.btn_generate);
        tv_otvet = findViewById(R.id.tv_otvet);
        tv_main_answer =findViewById(R.id.tv_main_answer);

        btnGenerate = findViewById(R.id.btn_generate);


        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();

                getOtvetInt = random.nextInt(100);
                otvetInt =getOtvetInt;
                if(( otvetInt != 0) && (otvetInt> 0)){
                    tv_otvet.setText(String.valueOf(otvetInt)+" %");
                    printAnswer();
                    btnGenerate.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "Enter again Generate", Toast.LENGTH_SHORT).show();
                    btnGenerate.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void printAnswer(){
        if(otvetInt>=1 && otvetInt<= 48){
            tv_main_answer.setText("Завтра повезет ");
            lotty_two.setVisibility(View.VISIBLE);

        }else {
            if(otvetInt>48 && otvetInt<=65){
             tv_main_answer.setText("Мы рады за тебя");
           lotty_two.setVisibility(View.VISIBLE);
        } else{
                if(otvetInt>65 && otvetInt<=100){
                    tv_main_answer.setText("Поздравляю супер");
                    lotty_one.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}