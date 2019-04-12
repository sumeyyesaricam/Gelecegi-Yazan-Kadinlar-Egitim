package example.smyy.bottomnavigationsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DietListFragment extends Fragment {
    final List<Diet> dietList = new ArrayList<Diet>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_diet_list, null);
        dietList.add(new Diet(R.drawable.menu_3, "Yumurta,peynir,zeytin", "5000C"));
        dietList.add(new Diet(R.drawable.menu_1, "Mevsim yeşillikleri salata", "2000C"));
        dietList.add(new Diet(R.drawable.menu_2, "Badem,fındık,ceviz", "4000C"));
        dietList.add(new Diet(R.drawable.menu_4, "Kivi,çilek,muz", "1000C"));

        ListView myDietList = (ListView) view.findViewById(R.id.list_fragment_diet_listview);
        DietListAdapter dietListAdapter = new DietListAdapter(getLayoutInflater(), dietList);
        myDietList.setAdapter(dietListAdapter);


        return view;
    }
}
