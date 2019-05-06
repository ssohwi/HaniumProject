package com.example.haniumproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_User extends AppCompatActivity{

    private EditText name;
    private EditText id;
    private EditText password;
    private EditText number;
    private EditText password_confirm;
    private Button signUp;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_signup);
        //Intent intent = getIntent();

        name=(EditText)findViewById(R.id.Name);
        id=(EditText)findViewById(R.id.ID);
        password=(EditText)findViewById(R.id.password);
        password_confirm=(EditText)findViewById(R.id.password1);
        number=(EditText)findViewById(R.id.number);
        signUp=(Button)findViewById(R.id.signup_button);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (name.getText().toString()==null || id.getText().toString()==null || password.getText().toString()==null ||
                password_confirm.getText().toString()==null || number.getText().toString()==null){
                    Toast.makeText(getApplicationContext(),"모두 입력해주세요",Toast.LENGTH_LONG).show();
                    return;
                }

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(id.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(SignUp_User.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                            }
                        });
            }
        });
    }
}
