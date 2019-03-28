package example.smyy.recyclersample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends
        RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
ArrayList<Product> products;
    Context context;
    LayoutInflater inflater;
public ProductAdapter(ArrayList<Product> products, Context context){
    this.products=products;
    this.context=context;
    inflater = LayoutInflater.from(context);
}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_product, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Product selectedProduct = products.get(i);
        myViewHolder.setData(selectedProduct, i);
        myViewHolder.productName.setText(selectedProduct.getProductName());
        myViewHolder.productDescription.setText(selectedProduct.getProductDescription());
        myViewHolder.productImage.setImageResource(selectedProduct.getImageID());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView productName, productDescription;
        ImageView productImage, deleteproduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.txtProductName);
            productDescription = (TextView) itemView.findViewById(R.id.txtProductDescription);
            productImage = (ImageView) itemView.findViewById(R.id.imageProduct);
            deleteproduct = (ImageView) itemView.findViewById(R.id.btnDelete);
            //deleteproduct.setOnClickListener(this);

        }

    }
}
