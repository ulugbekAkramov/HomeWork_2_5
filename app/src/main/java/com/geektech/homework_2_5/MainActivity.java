package com.geektech.homework_2_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private Button button;
     private TextView forgot, textView,input;
     private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        logic();
    }

    private void init() {
        button= findViewById(R.id.btn_login);
        textView = findViewById(R.id.registratsiya);
        email = findViewById(R.id.pochta);
        password = findViewById(R.id.parol);
        forgot = findViewById(R.id.tv_zp);
        input = findViewById(R.id.btn_vhod);
    }

    private void logic(){
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                colorButton();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                colorButton();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("admin") || password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    forgot.setVisibility(View.GONE);
                    input.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);

                } else { Toast.makeText(MainActivity.this, "Не правильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void colorButton(){
        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            button.setBackgroundColor(getResources().getColor(R.color.gray));
        }
        else button.setBackgroundColor(getResources().getColor(R.color.red));
    }
}