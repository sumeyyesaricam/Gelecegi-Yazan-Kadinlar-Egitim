package example.smyy.mediasample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera=findViewById(R.id.open_photo_and_video);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this
                        ,CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showVoiceActivity(View view){
        Intent intent=new Intent(MainActivity.this
                ,VoiceActivity.class);
        startActivity(intent);
    }

    public void showMapActivity(View view){
        Intent intent=new Intent(MainActivity.this
                ,MapActivity.class);
        startActivity(intent);
    }

    public void showWebActivity(View view){
        Intent intent=new Intent(MainActivity.this
                ,MapActivity.class);
        startActivity(intent);
    }

    public void showSmsActivity(View view){
        Intent intent=new Intent(MainActivity.this
                ,SmsActivity.class);
        startActivity(intent);
    }

    public void showCallActivity(View view){
        Intent intent=new Intent(MainActivity.this
                ,CallActivity.class);
        startActivity(intent);
    }
}
