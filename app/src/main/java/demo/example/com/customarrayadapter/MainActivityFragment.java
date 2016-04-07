package demo.example.com.customarrayadapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A fragment containing the list view of Android versions.
 */
public class MainActivityFragment extends Fragment {

    private AndroidFlavorAdapter flavorAdapter;

    private ArrayList<AndroidFlavor> flavorList;

    AndroidFlavor[] androidFlavors = {
            new AndroidFlavor("Cupcake", "1.5", R.drawable.cupcake),
            new AndroidFlavor("Donut", "1.6", R.drawable.donut),
            new AndroidFlavor("Eclair", "2.0-2.1", R.drawable.eclair),
            new AndroidFlavor("Froyo", "2.2-2.2.3", R.drawable.froyo),
            new AndroidFlavor("GingerBread", "2.3-2.3.7", R.drawable.gingerbread),
            new AndroidFlavor("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb),
            new AndroidFlavor("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream),
            new AndroidFlavor("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean),
            new AndroidFlavor("KitKat", "4.4-4.4.4", R.drawable.kitkat),
            new AndroidFlavor("Lollipop", "5.0-5.1.1", R.drawable.lollipop)
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null || !savedInstanceState.containsKey("flavors")) {
            flavorList = new ArrayList<AndroidFlavor>(Arrays.asList(androidFlavors));
        }
        else {
            flavorList = savedInstanceState.getParcelableArrayList("flavors");
        }
    }

    public MainActivityFragment() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("flavors", flavorList);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        flavorAdapter = new AndroidFlavorAdapter(getActivity(), flavorList);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AndroidFlavor flavorClick = flavorAdapter.getItem(i);
                flavorClick.versionName += ":)";
                flavorAdapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}