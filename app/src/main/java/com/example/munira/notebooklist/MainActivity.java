package com.example.munira.notebooklist;



import android.content.Intent;
import android.media.Image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //step:1 Main page its initial create for objectt
    //private Image headingImage;
    private TextView headingName;
/*    private TextView menuIncome;
    private TextView menuArgent;
    private TextView menuProbality;
    private TextView menuYearly;*/
    private TextView showtotalIncome;
    private TextView totalArgent;
    private TextView totalProbality;
    private TextView totalYearly;
    private Button addIncomeButton;
    private Button addArgentButton;
    private Button addProbalityButton;
    private Button addYearlyButton;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step:2 main page to activity.xml page connection and casting.

        //headingImage=(Image)findViewById(R.id.profile_image);
       // headingName=(TextView)findViewById(R.id.profile_name);
     /*   menuIncome=(TextView) findViewById(R.id.total_income_title);
        menuArgent=(TextView) findViewById(R.id.total_argent_title);
        menuProbality=(TextView)findViewById(R.id.total_probality_title);
        menuYearly=(TextView)findViewById(R.id.total_yearly_title);*/
        showtotalIncome=(TextView)findViewById(R.id.total_income_cost);
        totalArgent=(TextView)findViewById(R.id.total_argent_cost);
        totalProbality=(TextView)findViewById(R.id.total_probality_cost);
        totalYearly=(TextView)findViewById(R.id.total_yearly_cost);
        addIncomeButton=(Button)findViewById(R.id.income_button);
        addArgentButton=(Button)findViewById(R.id.argent_button);


        // Income Capture button clicks
       addIncomeButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
               // Income Start NewActivity.class
                Intent intent=new Intent(MainActivity.this,Income_list.class);
               startActivity(intent);

         }

       });
        // Argent Capture button clicks
        addArgentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Argent_list.class);
//                startActivity(intent);
            }
        });


    }


}
