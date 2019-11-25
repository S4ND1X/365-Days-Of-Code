package com.android.loginandform;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    /*
    *   Objetos de firebase para guardarDatos
    *
     */
    private FirebaseDatabase mFirebaseDataBase;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference databaseReference;
    private Button btnLogout, btnSubmit;
    private EditText emailId, dateId, textAreaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //---------------------- Firebase Atributos --------------------
        this.mFirebaseAuth = FirebaseAuth.getInstance();
        this.mFirebaseDataBase = FirebaseDatabase.getInstance();
        this.mFirebaseDataBase = FirebaseDatabase.getInstance();
        this.databaseReference = mFirebaseDataBase.getReference();

        //---------------------------- Componentes -------------------
        this.btnLogout = findViewById(R.id.button2);
        this.btnSubmit = findViewById(R.id.button4);
        this.emailId = findViewById(R.id.editText2);
        this.dateId = findViewById(R.id.editText);
        this.textAreaId = findViewById(R.id.editText3);


        //------------------------ Boton Logout ---------------------
        this.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intToMain);
            }
        });


        //--------------------------Boton Enviar------------------------------
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarDatosYEnviar();
            }
        });
    }

    public void ValidarDatosYEnviar(){
        String workerEmailStr = this.emailId.getText().toString();
        String dateStr = this.dateId.getText().toString();
        String reportText = this.textAreaId.getText().toString();
        if(!workerEmailStr.isEmpty() && !dateStr.isEmpty() && !reportText.isEmpty()) {
            String id = this.databaseReference.push().getKey();
            Reporte reporte = new Reporte(workerEmailStr, dateStr, reportText);
            this.databaseReference.child(id).setValue(reporte);
            this.textAreaId.setText("");
            this.emailId.setText("");
            this.dateId.setText("");
            Toast.makeText(HomeActivity.this,
                    "Se ha generado el reporte exitosamente",
                    Toast.LENGTH_SHORT).show();
        }else if(workerEmailStr.isEmpty() && dateStr.isEmpty() && reportText.isEmpty()){
                Toast.makeText(HomeActivity.this,
                        "No puedo enviar un reporte vacio!",
                        Toast.LENGTH_SHORT).show();
            this.emailId.requestFocus();
            this.dateId.requestFocus();
            this.textAreaId.requestFocus();
        }else if(workerEmailStr.isEmpty()){
            this.emailId.setError("Escribe un email");
            this.emailId.requestFocus();
        }else if(dateStr.isEmpty()){
            this.dateId.setError("Escribe Una Fecha");
            this.dateId.requestFocus();
        }else if(reportText.isEmpty()){
            this.textAreaId.setError("Escribe una descripcion");
            this.textAreaId.requestFocus();
        }else{
            Toast.makeText(HomeActivity.this,
                    "Ocurrio un error al crear el reporte",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
