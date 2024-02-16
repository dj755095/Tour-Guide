package com.rohit.examples.android.IndiaTour.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.rohit.examples.android.IndiaTour.R;

public class ForgetPass extends AppCompatActivity {
    ProgressBar progressBar1;
    EditText email_reset;;
    Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        progressBar1 = findViewById(R.id.progressBar1);
        email_reset = findViewById(R.id.email_reset);
        reset_button = findViewById(R.id.reset_button);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar1.setVisibility(View.VISIBLE);

                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress = email_reset.getText().toString();

                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(ForgetPass.this, "Email Have been sent SuccessFully", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                progressBar1.setVisibility(View.GONE);
            }
        });


    }
}