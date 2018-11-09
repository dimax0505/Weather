package com.example.maximovd.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private DataClass[] data =
            new DataClass[] {new DataClass(R.mipmap.ic_launcher, "Square launcher icon"),
                             new DataClass(R.mipmap.ic_launcher_round, "Round launcher icon")};

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.list_item, viewGroup, false);

            ImageView imageView = view.findViewById(R.id.image);
            TextView textView = view.findViewById(R.id.text);

            imageView.setImageResource(data[position].image);
            textView.setText(data[position].text);
        }
        return view;
    }
}
