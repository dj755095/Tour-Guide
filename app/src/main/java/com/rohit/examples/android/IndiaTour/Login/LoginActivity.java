package com.rohit.examples.android.IndiaTour.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohit.examples.android.IndiaTour.Activity.MainActivity;
import com.rohit.examples.android.IndiaTour.Activity.SemiMain;
import com.rohit.examples.android.IndiaTour.R;

public class LoginActivity extends AppCompatActivity {

    Button login_button;
    TextView signupRedirectText;
    TextView forgetPass;

    private FirebaseAuth mAuth;

    EditText login_username,login_password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signupRedirectText);
        forgetPass = findViewById(R.id.forgetPass);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
                finish();
            }
        });
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ForgetPass.class);
                startActivity(i);

            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email = "";
                String password = "";
                email = login_username.getText().toString();
                password = login_password.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Authentication Successfull", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), SemiMain.class));
                                    finish();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });
    }

}