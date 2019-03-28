package example.smyy.mediasample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    EditText etMessage;
    EditText etPhone;
    Button btnSendMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        etMessage=findViewById(R.id.etMessage);
        etPhone=findViewById(R.id.etPhone);
        btnSendMsg=findViewById(R.id.btnSendMsg);

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + etPhone.getText().toString());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", etMessage.getText().toString());
                startActivity(intent);
            }
        });

    }
}
