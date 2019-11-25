package com.android.loginandform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private  EditText emailId, passwordId;
    private Button btnSignUp;
    private TextView tvSignIn;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear la sesion de firebase
        this.mFirebaseAuth = FirebaseAuth.getInstance();
        //Obtener los elementos de la pantalla
        this.emailId = findViewById(R.id.editEmail);
        this.passwordId = findViewById(R.id.editPassword);
        this.btnSignUp = findViewById(R.id.buttonSignUp);
        this.tvSignIn = findViewById(R.id.textView);
        this.btnSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String emailStr = emailId.getText().toString();
                String passwordStr = passwordId.getText().toString();
                if(emailStr.isEmpty()){
                    emailId.setError("Please enter an email");
                    emailId.requestFocus();
                }else if(passwordStr.isEmpty()){
                    passwordId.setError("Please enter a password");
                    passwordId.requestFocus();
                }else if(emailStr.isEmpty() && passwordStr.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Fields Are Empty",
                            Toast.LENGTH_SHORT).show();
                }else if(!(emailStr.isEmpty() && passwordStr.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,
                                        "Sign up Failed, please Try Again",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this,
                            "Error Ocurred!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
