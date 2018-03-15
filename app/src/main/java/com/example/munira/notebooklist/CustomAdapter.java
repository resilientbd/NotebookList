package com.example.munira.notebooklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Munira on 12-Mar-18.
 *  /*step:10 condition for layout show*/


public class CustomAdapter  extends BaseAdapter{
    Context context;
    List<Item> itemList;

    //public constructor
    public CustomAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_wish_list_item, parent, false);
        }

        // get current item to be displayed
        Item currentItem = (Item) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.item_title);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.item_amount_description);
        TextView wishTextViewDate=(TextView)
                convertView.findViewById(R.id.item_wishlistDateTextView);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getWishString());
        textViewItemDescription.setText(currentItem.getAmountInteger());
        textViewItemDescription.setText(currentItem.getNoteDate());

        // returns the view for the current row
        return convertView;
    }
}
