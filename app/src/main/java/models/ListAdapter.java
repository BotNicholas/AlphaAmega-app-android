package models;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nicholas.alpha_amega.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListItem> {

    public ListAdapter(@NonNull Context context, @NonNull List<ListItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    //Here we create widgets from plain xml
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView2);
        TextView textView = convertView.findViewById(R.id.textView2);

        ListItem item = getItem(position);

        imageView.setImageResource(item.getImageResource());
        textView.setText(item.getText());



        return convertView;
    }
}
