package com.example.ms.activity5.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import com.example.ms.activity5.R;

public class FavoriteFragment extends Fragment {
    EditText kilo, boy;
    TextView vki;
    Button calc;

    private void calculate() {
        if (kilo.getText().toString().length() > 0 && boy.getText().toString().length() > 0) {
            float userWeight = Float.parseFloat(kilo.getText().toString());
            float userLength = Float.parseFloat(boy.getText().toString());
            if (userLength > 0) {
                userLength = userLength / 100;
                float result = (userWeight / ((userLength * userLength)));

                String resultDescription = "";

                if (result < 15) {
                    resultDescription = "Aşırı Zayıfsınız";
                } else if (result > 15 && result <= 30) {
                    resultDescription = "Zayıfsınız";
                } else if (result > 30 && result <= 40) {
                    resultDescription = "Normalsiniz";
                } else if (result > 40) {
                    resultDescription = "Aşırı Şişmansınız (Morbid Obez)";
                } else {
                    resultDescription = "Aşırı Şişman (Morbid Obez)";
                }
                vki.setText("Vücut kitle endeksiniz: " + result + "\n" + resultDescription);
            }
        } else {

            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Hata!");
            builder.setMessage("Kilo ya da boy boş bırakılamaz.");
            builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            builder.show();
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, null);


        kilo = view.findViewById(R.id.editkilo);
        boy = view.findViewById(R.id.editBoy);
        calc = view.findViewById(R.id.button_hesap);
        vki = view.findViewById(R.id.vki);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate();
            }
        });
return view;
    }
}



