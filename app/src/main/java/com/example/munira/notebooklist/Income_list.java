package com.example.munira.notebooklist;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Income_list extends AppCompatActivity {

    /* step:1 Main page its initial create for object*/
    private EditText IncomeHeadInputET;
    private EditText IncomeAmountInputET;
    private ListView myIncomeWishList;
    private List<Item> IncomeWishList;
    FloatingActionButton floatIncomeListButton;

    /*step:2 many data show so adapter use for array*/

//    ArrayList<Item> IncomeArrayList=new ArrayList<Item>();
//
//    /* step:3 array list data convert work for Base Adapter or array list show style declare*/
//  final  CustomAdapter adapter=new CustomAdapter(getBaseContext(),IncomeArrayList);;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_list);

         /* step:4 main page to activity.xml page connection and casting*/


        IncomeHeadInputET=(EditText)findViewById(R.id.income_item_input);
        IncomeAmountInputET=(EditText)findViewById(R.id.input_amount_description);
        myIncomeWishList=(ListView)findViewById(R.id.viewB_income_list);
        floatIncomeListButton = findViewById(R.id.fab_income_button);


        /*step:15 database declare collection of  data show by database*/
         final DatabaseHelper helper = new DatabaseHelper(getBaseContext());
//        ArrayList<Item> incomeArrayList = IncomeArrayList; // calls function to get items list
       final List<Item> incomeArrayList=helper.getAllData();
        final CustomAdapter adapter = new CustomAdapter(this, incomeArrayList);
      //  incomeArrayList = helper.getAllData();
       /*step:11 adapter call*/
        myIncomeWishList.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        //step:5 create array list Setup the data source


    /* step:6 create Base Adapter and instantiate the custom list adapter*/


    // get the ListView and attach the adapter
        ListView myIncomeWishList  = (ListView) findViewById(R.id.viewB_income_list);
        myIncomeWishList.setAdapter(adapter);







        /* step:5 create array list*/
        final List<Item> IncomeArrayList=new ArrayList<Item>();
            //* step:6 create Base Adapter*//*
//        adapter= new CustomAdapter() {
//
//
//            //*step:9 how to view.so data view style for layout Inflater*//*
//            LayoutInflater Inflater = (LayoutInflater) getBaseContext( ). getSystemService(LAYOUT_INFLATER_SERVICE);
//
//            @Override
//            public int getCount() {
//
//                 /*step:8 array list Length*/
//                return IncomeArrayList.size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                /*step:7 array list Item return*/
//
//                return IncomeArrayList.get(position);
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                ViewHolder viewHolder;
//
//                /*step:10 condition for layout show*/
//                if (convertView == null){
//
//                    convertView=Inflater.inflate(R.layout.activity_wish_list_item,null);
////                    viewHolder = new ViewHolder(convertView);
////                    convertView.setTag(viewHolder);
////                } else {
////                    viewHolder = (ViewHolder) convertView.getTag();
////                }
//
//
//
//
//
//                TextView wishTextViewTitle=(TextView)convertView.findViewById(R.id.item_title);
//                TextView wishTextViewAmount=(TextView)convertView.findViewById(R.id.item_amount_description);
//                TextView wishTextViewDate=(TextView)convertView.findViewById(R.id.item_wishlistDateTextView);
//
//                Item currentItem = (Item) getItem(position);
//                wishTextViewTitle.setText(IncomeArrayList.get(position).getWishString());
//                wishTextViewAmount.setText(IncomeArrayList.get(position).getAmountInteger());
//
//                String date=IncomeArrayList.get(position).getNoteDate();
//                wishTextViewDate.setText(date);
//                return convertView;
//            }
//        };

        myIncomeWishList.setAdapter(adapter);


        /*step:12 wish add button press*/
        floatIncomeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validating form

                    String inputTitle=IncomeHeadInputET.getText().toString();
                    String inputAmount=IncomeAmountInputET.getText().toString();


                    if(!IncomeAmountInputET.getText().toString().equals("") ||
                            !IncomeHeadInputET.getText().toString().equals("")){


                        Date dateObj = Calendar.getInstance().getTime();

                        String IncomeTitle=IncomeHeadInputET.getText().toString();
                        String  finalString= IncomeAmountInputET.getText().toString();
                        String dateString="";

                        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss ");
                        try {
                            dateObj = curFormater.parse(dateString);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                        dateString = curFormater.format(dateObj);
                        Item item=new Item(0,IncomeTitle,finalString,dateString);
                        incomeArrayList.add(item);

                /*step:14 collection of  data show by database*/
                        item.setWishString("Item:" + IncomeArrayList.size( ));
                        item.setWishString(IncomeHeadInputET.getText( ).toString( ));

                        item.setAmountInteger("Item:" + IncomeArrayList.size( ));
                        item.setAmountInteger(IncomeAmountInputET.getText( ).toString( ));

                        DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                        helper.insertData(IncomeTitle, inputAmount, dateString);
                        IncomeArrayList.add(item);
                        //myIncomeWishList.setAdapter(adapter);
                        //adapterChanged();
                 /*new set data notification show*/
                       adapter.notifyDataSetChanged();

                    /*data set and clear*/
                        IncomeHeadInputET.setText("");
                        IncomeAmountInputET.setText("");

                    /* data type end and keyboard hide*/

                        InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(IncomeHeadInputET.getWindowToken(),0);
                        inputMethodManager.hideSoftInputFromWindow(IncomeAmountInputET.getWindowToken(),0);

                    /*add and small notification sms show*/
                        Toast.makeText(getBaseContext(),"New Income Addad to List",Toast.LENGTH_SHORT).show();

                    }else {

                        if (IncomeHeadInputET.getText().toString().equals("")){

                            IncomeHeadInputET.setError("Title can't be empty !!!");
                        }

                        if (IncomeAmountInputET.getText().toString().equals("")){

                            IncomeAmountInputET.setError("Income amount can't be empty !!!");
                        }



                    }




                }






        });



         /*step:13 press on data and delete item */
        myIncomeWishList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Database data
                DatabaseHelper helper = new DatabaseHelper(getBaseContext());


                /*data delete */

                helper.deleteData(incomeArrayList.get(position).getWishId());
                incomeArrayList.remove(position);
                adapter.notifyDataSetChanged();

//                adapterChanged();
                Toast.makeText(getBaseContext(),"One Item Remove",Toast.LENGTH_SHORT).show();

                return false;
            }
        });


    }
//    void adapterChanged()
//    {
//        adapter.notifyDataSetChanged();
//    }


}
