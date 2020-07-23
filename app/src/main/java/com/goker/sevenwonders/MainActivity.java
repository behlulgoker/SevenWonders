package com.goker.sevenwonders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listview = findViewById(R.id.listView);

        final ArrayList<String> structureName = new ArrayList<>();
        structureName.add("Petra");
        structureName.add("Taj Mahal");
        structureName.add("Christ the Redeemer");
        structureName.add("Machu Picchu");
        structureName.add("Great Wall of China");
        structureName.add("Colosseum");
        structureName.add("Chichen Itza");


        final ArrayList<String> countryName = new ArrayList<>();
        countryName.add("Jordan");
        countryName.add("India");
        countryName.add("Brasil");
        countryName.add("Peru");
        countryName.add("China");
        countryName.add("Italy");
        countryName.add("Mexico");

        Bitmap Petra = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.petra);
        Bitmap TajMahal = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tajmahal);
        Bitmap Christ = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.christ);
        Bitmap MachuPicchu = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.machupicchu);
        Bitmap GreatWall = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.greatwall);
        Bitmap Colosseum = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseum);
        Bitmap ChichenItza = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.chickenitza);

        final ArrayList<Bitmap> structureImages = new ArrayList<>();
        structureImages.add(Petra);
        structureImages.add(TajMahal);
        structureImages.add(Christ);
        structureImages.add(MachuPicchu);
        structureImages.add(GreatWall);
        structureImages.add(Colosseum);
        structureImages.add(ChichenItza);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,structureName);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("structureName",structureName.get(i));
                intent.putExtra("countryName",countryName.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(structureImages.get(i));


                startActivity(intent);
            }
        });








    }
}