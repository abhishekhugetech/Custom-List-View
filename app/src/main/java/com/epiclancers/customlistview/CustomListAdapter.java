package com.epiclancers.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    ArrayList<String> arrayList;
    Context context;

    public CustomListAdapter( Context context, ArrayList<String> arrayList) {
        super( context, R.layout.single_list_item , arrayList );

        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate( R.layout.single_list_item , null , true );

        TextView textView = (TextView) view.findViewById(R.id.textView);

        textView.setText( arrayList.get(position) );

        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is Item Number " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
