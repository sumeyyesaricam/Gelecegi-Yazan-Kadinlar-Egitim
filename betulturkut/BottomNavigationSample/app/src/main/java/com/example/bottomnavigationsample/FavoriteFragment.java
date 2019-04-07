package com.example.bottomnavigationsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FavoriteFragment extends Fragment {
    EditText kilo = null;
    EditText boy = null;
    Button hesapla;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Activitydeki setcontentview gibi tanımlama yapmak gerek. Burada bu fonksiyon (inflater) kullanılır.
        View view = inflater.inflate(R.layout.fragment_favorite,null);

        kilo = view.findViewById(R.id.kiloet);
        boy = view.findViewById(R.id.boyet);
        hesapla = view.findViewById(R.id.hesaplaButton);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();

            }
        });

        return view;
        //Componentlerin tanımlanması işlemlerini burada yaparız

    }
    private void Calculate(){
        String boy1=boy.getText().toString();
        String kilo1 = kilo.getText().toString();
        float boy = Float.parseFloat(boy1);
        float kilo = Float.parseFloat(kilo1);

        float a = boy/100;
        float sonuc = kilo/(a*a);

        if (sonuc<15){
            Toast.makeText(getContext(),"Çok zayıf!", Toast.LENGTH_LONG).show();
        }

        else if(15 < sonuc && sonuc < 30){
            Toast.makeText(getContext(),"Zayıf!", Toast.LENGTH_LONG).show();
        }

        else if(30 < sonuc && sonuc < 40){
            Toast.makeText(getContext(),"Normal!", Toast.LENGTH_LONG).show();
        }

        else if(40 < sonuc){
            Toast.makeText(getContext(),"Şişman!", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(getContext(),"Hatalı değer girdiniz!", Toast.LENGTH_LONG).show();
        }

    }
}
