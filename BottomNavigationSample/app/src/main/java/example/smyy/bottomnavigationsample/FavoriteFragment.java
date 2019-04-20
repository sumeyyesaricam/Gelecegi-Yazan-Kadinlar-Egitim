package example.smyy.bottomnavigationsample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FavoriteFragment extends Fragment {

    EditText editUserWeight;
    EditText editUserLenght;
    Button btnCalculate;
    TextView userResultTv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void calculate() {
        if (editUserWeight.getText().toString().length() > 0 && editUserLenght.getText().toString().length() > 0) {
            float userWeight =  Float.parseFloat(editUserWeight.getText().toString());
            float userLength = Float.parseFloat(editUserLenght.getText().toString());
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite,
                null);
        editUserWeight = view.findViewById
                (R.id.home_fragment_user_weight_et);
        editUserLenght = view.findViewById
                (R.id.home_fragment_user_length_et);
        btnCalculate = view.findViewById
                (R.id.home_fragment_calculate_btn);
        userResultTv=view.findViewById(R.id.home_fragment_result_tv);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return view;
    }
}
