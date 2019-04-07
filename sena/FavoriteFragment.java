package com.example.ms.activity5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FavoriteFragment extends Fragment {

    private void calculate() {


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    EditText kilo, boy;
    Button calc;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, null);



        kilo = view.findViewById(R.id.kilo);
        boy = view.findViewById(R.id.boy);
        calc = view.findViewById(R.id.button_hesap);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate();
                calc=kilo/(boy*boy);
                if (calc<15){
                    System.out.print("çok zayifsiniz");
                } else
                    if (calc>15 && calc<30){
                    System.out.print("zayifsiniz");
                    }else
                        if (calc<40 && calc>30){
                    System.out.print("normal kilodasınız");
                        }
            } else(calc>40){
                System.out.print("şişmansınız,üzgünüz.");
            }
        });


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
