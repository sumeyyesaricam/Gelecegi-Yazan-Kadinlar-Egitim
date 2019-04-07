package com.example.bottomnavigationsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FavoriteFragment extends Fragment {

    Button btnCalculate;
    EditText editText;
    EditText editText1;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void hesapla() {

        //boy/100=a;
        // kilo/(a*a)
        // sonuc 15 den kucukse cok zayif 15 ile 30 zayif
        //30 40 normal
        //40 dan buyuk sisman

      float KullaniciKilo=Float.parseFloat(editText.getText().toString());
      float KullaniciBoy=Float.parseFloat(editText1.getText().toString());

      float a= KullaniciBoy/100;
      float b=KullaniciKilo/(a*a);


      if(b<=15)
          Toast.makeText(getActivity(), "cok zayif",Toast.LENGTH_LONG).show();
      else if(b>15 & b<30)
          Toast.makeText(getActivity(), "zayif",Toast.LENGTH_LONG).show();

      else if(b>30 & b<40)
          Toast.makeText(getActivity(), "normal",Toast.LENGTH_LONG).show();
      else if(b>40)
          Toast.makeText(getActivity(), "sisman",Toast.LENGTH_LONG).show();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // componentler burada tanimlanir
        //ilk basta view activite edilir
        //layotu dosyasini tanimladik setcontent yok
        //elimizde olan gorunumu vievden icindeki componentlara ulasiyorum findviewby id demek yerine

        View view = inflater.inflate(R.layout.fragment_favorite, null);
         editText = view.findViewById(R.id.editText);
         editText1 = view.findViewById(R.id.editText2);
         btnCalculate = view.findViewById(R.id.button);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla();
            }
        });

        return view;

    }


}
