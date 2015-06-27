package demo.example.com.customarrayadapter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A fragment containing the list view of Android versions.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mFlavorAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Create some data for our list view. These are the Android versions.
        String[] data = {
                "Cupcake (Android Version -1.5)",
                "Donut (Android Version - 1.6)",
                "Eclair (Android Version - 2.0–2.1)",
                "Froyo (Android Version - 2.2–2.2.3)",
                "Gingerbread (Android Version - 2.3–2.3.7)",
                "Honeycomb (Android Version - 3.0–3.2.6)",
                "Ice Cream Sandwich (Android Version - 4.0–4.0.4)",
                "Jelly Bean (Android Version - 4.1–4.3.1)",
                "KitKat (Android Version - 4.4–4.4.4, 4.4W–4.4W.2)",
                "Lollipop (Android Version - 5.0–5.1.1)"
        };
        List<String> flavors = new ArrayList<String>(Arrays.asList(data));


        // Now that we have some  data, create an ArrayAdapter.
        mFlavorAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_flavor, // The name of the layout ID.
                        R.id.list_item_flavor_textview, // The ID of the textview to populate.
                        flavors);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_flavor);
        listView.setAdapter(mFlavorAdapter);

        return rootView;
    }
}
