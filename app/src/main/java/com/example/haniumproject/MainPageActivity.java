package com.example.haniumproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainPageActivity extends AppCompatActivity implements View.OnClickListener {
            private static final String TAG="MainPageActivity";

            ImageButton locationMap_imgbtn;
            ImageButton Name_imgbtn;
            ImageButton community_imgbtn;
            TextView locationMap_txt;
            TextView Name_txt;
            TextView community_txt;
            TextView textViewUserEmail;
            Button buttonSignOut;


            FirebaseAuth firebaseAuth;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_mainpage);

                locationMap_imgbtn=(ImageButton)findViewById(R.id.MainPage_locationMap_imgbtn);
                locationMap_txt=(TextView)findViewById(R.id.MainPage_locationMap_txt);
                Name_imgbtn=(ImageButton)findViewById(R.id.MainPage_name_imgbtn);
                Name_txt=(TextView)findViewById(R.id.MainPage_name_txt);
                community_imgbtn=(ImageButton)findViewById(R.id.MainPage_Community_imgbtn);
                community_txt=(TextView)findViewById(R.id.MainPage_Community_txt);
                textViewUserEmail=(TextView)findViewById(R.id.textviewUserEmail);

                locationMap_imgbtn.setOnClickListener(this);
                locationMap_txt.setOnClickListener(this);
                Name_txt.setOnClickListener(this);
                Name_imgbtn.setOnClickListener(this);
                community_txt.setOnClickListener(this);
                community_imgbtn.setOnClickListener(this);
                buttonSignOut=(Button)findViewById(R.id.buttonLogout);
                buttonSignOut.setOnClickListener(this);

                firebaseAuth = FirebaseAuth.getInstance();
                //유저가 로그인 하지 않은 상태라면 null 상태이고 이 액티비티를 종료하고 로그인 액티비티를 연다.
                if(firebaseAuth.getCurrentUser() == null) {
                    finish();
                    startActivity(new Intent(this, LoginActivity.class));
                }
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //textViewUserEmail의 내용을 변경해 준다.
                textViewUserEmail.setText("반갑습니다.\n"+ user.getEmail()+"으로 로그인 하였습니다.");

                //logout button event
                buttonSignOut.setOnClickListener(this);




                // 전체화면인 DrawerLayout 객체 참조
                final android.support.v4.widget.DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

                // Drawer 화면(뷰) 객체 참조
                final View drawerView = (View) findViewById(R.id.drawer);


                // 드로어 화면을 열고 닫을 버튼 객체 참조
                ImageButton btnOpenDrawer = (ImageButton) findViewById(R.id.btn_OpenDrawer);
                ImageButton btnCloseDrawer = (ImageButton) findViewById(R.id.btn_CloseDrawer);


                // 드로어 여는 버튼 리스너
                btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawerLayout.openDrawer(drawerView);
                    }
                });


                // 드로어 닫는 버튼 리스너
                btnCloseDrawer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawerLayout.closeDrawer(drawerView);
                    }
                });


            }
            @Override
            public void onClick(View view){
                if (view==locationMap_imgbtn){
                    finish();
                    startActivity(new Intent(this,CareCenterMapActivity.class));
                }if (view==locationMap_txt){
                    finish();
                    startActivity(new Intent(this,CareCenterMapActivity.class));
                }if (view == buttonSignOut) {
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(this, LoginActivity.class));
                }
            }
        }


