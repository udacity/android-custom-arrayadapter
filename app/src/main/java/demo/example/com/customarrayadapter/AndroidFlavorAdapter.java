package demo.example.com.customarrayadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AndroidFlavorAdapter extends ArrayAdapter<AndroidFlavor> {
    private static final String LOG_TAG = AndroidFlavorAdapter.class.getSimpleName();

    public AndroidFlavorAdapter(Activity context, List<AndroidFlavor> androidFlavors)
    {
        super(context, 0, androidFlavors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AndroidFlavor androidFlavor = getItem(position);
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_flavor, parent, false);

        ImageView iconView = (ImageView) rootView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(androidFlavor.image);

        TextView versionNameView = (TextView) rootView.findViewById(R.id.list_item_version_name);
        versionNameView.setText(androidFlavor.versionName);

        TextView versionNumberView = (TextView) rootView.findViewById(R.id.list_item_versionnumber_textview);
        versionNumberView.setText(androidFlavor.versionNumber);
        return rootView;
    }
}
