package com.example.haniumproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.btn1);
        Button button2=(Button)findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    void show(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("가입 유형");
        builder.setMessage("사업자  일반고객");
        builder.setPositiveButton("사업자", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"사업자를 선택하셨습니다",Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("일반고객", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"일반 고객을 선택하셨습니다",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),SignUp_User.class);

                startActivity(intent);

            }
        });
        builder.show();

    }
}
