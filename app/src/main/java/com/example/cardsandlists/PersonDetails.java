package com.example.cardsandlists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonDetails extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        i1= (ImageView) findViewById(R.id.person_photo);
        t1= (TextView) findViewById(R.id.person_name);
        t2= (TextView) findViewById(R.id.person_age);
        i1.setImageResource(getIntent().getIntExtra("image_id",1));
        t1.setText("Name :" +getIntent().getStringExtra("name"));
        t2.setText("Age: "+getIntent().getStringExtra("age"));
    }
}
