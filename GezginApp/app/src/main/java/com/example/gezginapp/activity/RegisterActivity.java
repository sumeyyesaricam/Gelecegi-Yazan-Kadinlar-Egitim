package com.example.gezginapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gezginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    EditText editEmail;
    EditText editPassword;
    EditText editConfirmPAssword;
    Button btnRegister;
    String email;
    String password;
    String confirmPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editEmail=findViewById(R.id.user_email_register_et);
        editPassword=findViewById(R.id.user_password_register_et);
        editConfirmPAssword=findViewById(R.id.user_confirm_email_register_tv);
        btnRegister=findViewById(R.id.button_register);
        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfoAndRegister();
            }
        });

    }
    private void getUserInfoAndRegister(){
        email=editEmail.getText().toString().trim();
        password=editPassword.getText().toString().trim();
        confirmPassword=editConfirmPAssword.getText().toString().trim();
        if(!email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if(password.equals(confirmPassword)){
                register();
            }
        }else{
            Toast.makeText(this,"Edittextleri kontrol edin",Toast.LENGTH_LONG);
        }
    }
    private void register(){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


}
