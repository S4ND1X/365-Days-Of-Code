package com.android.loginandform;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailId, password;
    private Button btnLogin;
    private TextView tvRegister;
    private FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Crear la sesion de firebase
        this.mFirebaseAuth = FirebaseAuth.getInstance();
        //Obtener los elementos de la pantalla
        this.emailId = findViewById(R.id.editEmail);
        this.password = findViewById(R.id.editPassword);
        this.btnLogin = findViewById(R.id.button);
        this.tvRegister = findViewById(R.id.textView);

        this.mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this,
                                    "You are logged in",
                                    Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Please Login",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = emailId.getText().toString();
                String passwordStr = password.getText().toString();
                if(emailStr.isEmpty()){
                    emailId.setError("Please enter an email");
                    emailId.requestFocus();
                }else if(passwordStr.isEmpty()){
                    password.setError("Please enter a password");
                    password.requestFocus();
                }else if(emailStr.isEmpty() && passwordStr.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Fields Are Empty",
                            Toast.LENGTH_SHORT).show();
                }else if(!(emailStr.isEmpty() && passwordStr.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,
                                        "Login Erro Try Again!",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                Intent intToHome =  new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Error Ocurred!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intSignUp);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
