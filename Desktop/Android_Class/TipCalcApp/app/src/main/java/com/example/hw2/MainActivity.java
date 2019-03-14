package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfTickets, groupNum;
    double totalCost;
    double tip;
    String groupChoice = "";
    double tiptotal;
    double cost1;
    double spilttip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets = (EditText)findViewById(R.id.txtTickets);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        final Spinner group2 = (Spinner)findViewById(R.id.txtGroup2);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {

            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {

                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                groupNum = Integer.parseInt(group.getSelectedItem().toString());
                tip = Double.parseDouble(group2.getSelectedItem().toString());



                totalCost = Integer.parseInt(tickets.getText().toString());
                tiptotal = tip / 100;

                cost1 = tiptotal * numberOfTickets;
                spilttip = cost1/groupNum;

                totalCost = ( numberOfTickets / groupNum) + spilttip;






                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();


                result.setText("Cost for each of " + groupChoice  +" guests: " + currency.format(totalCost));







            }

        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }
}
