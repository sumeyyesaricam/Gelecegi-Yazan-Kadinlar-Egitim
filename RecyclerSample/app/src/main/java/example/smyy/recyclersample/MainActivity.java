package example.smyy.recyclersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        products.add(new Product(R.mipmap.ic_launcher,"Kalem"
                ,"Kurşun Kalem"));
        products.add(new Product(R.mipmap.ic_launcher,"Kalem1"
                ,"Kurşun Kalem1"));
        products.add(new Product(R.mipmap.ic_launcher,"Kalem2"
                ,"Kurşun Kalem2"));
        products.add(new Product(R.mipmap.ic_launcher,"Kalem3"
                ,"Kurşun Kalem3"));
        ProductAdapter productAdapter =
                new ProductAdapter(products, this);
        recyclerView.setAdapter(productAdapter);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation
                (LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager
                (linearLayoutManager);

    }
}
