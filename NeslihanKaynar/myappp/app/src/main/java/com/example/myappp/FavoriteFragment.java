package com.example.myappp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FavoriteFragment extends Fragment {
    EditText edituserWeight;
    EditText edituserLenght;
    Button btnCalculate;
    TextView userResultTv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void calculate() {
        if (edituserWeight.getText().toString().length() > 0 && edituserLenght.getText().toString().length() > 0) {
            float userWeight =  Float.parseFloat(edituserWeight.getText().toString());
            float userLength = Float.parseFloat(edituserLenght.getText().toString());
            if(userLength>0){
                userLength = userLength / 100;
                float result = (userWeight / ((userLength * userLength)));

                String resultDescription = "";

                if (result < 15) {
                    resultDescription = "Aşırı Zayıf";
                } else if (result > 15 && result <= 30) {
                    resultDescription = "Zayıf";
                } else if (result > 30 && result <= 40) {
                    resultDescription = "Normal";
                } else if (result > 40) {
                    resultDescription = "Aşırı Şişman (Morbid Obez)";
                } else {
                    resultDescription = "Aşırı Şişman (Morbid Obez)";
                }

                userResultTv.setText("Vücut kitle endeksiniz: " + result + "\n" + resultDescription);
            }}else {

            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Hata!");
            builder.setMessage("Kilo ya da boy boş bırakılamaz.");
            builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            builder.show();
        }
    }
        //*boy/100=a*kilo/(a*a)
        // * sonuç 15 den küçükse çok zayıf*
        // 15 ile 30 arasında zayıf
        // * 30 ile 40 normal
        // * 40 dan büyükse şişman


        @Nullable
        @Override
        public View onCreateView (@NonNull LayoutInflater inflater
                , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_favorite,
                    null);
            edituserWeight = view.findViewById// fragment da findViewById başına view yazılarak kullanılır.
                    (R.id.editText);
            edituserLenght = view.findViewById
                    (R.id.editText2);
            btnCalculate = view.findViewById
                    (R.id.button);
            userResultTv = view.findViewById(R.id.textView2);
            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate();
                }
            });
            return view;

        }
    }

