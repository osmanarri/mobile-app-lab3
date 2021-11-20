package com.example.osmantahir_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] activities= new String[]{"Canvas Exercise", "Drawable Animation Exercise", "Tweened Animation Exercise"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, activities);

        ListView list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Intent intent= new Intent(getApplicationContext(),CanvasActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Canvas Exercise started",Toast.LENGTH_SHORT).show();
                }
                else if(position==1){
                    Intent intent= new Intent(getApplicationContext(),FrameActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Drawable Animation Exercise started",Toast.LENGTH_SHORT).show();
                }
                else if(position==2){
                    Intent intent= new Intent(getApplicationContext(),AnimationActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Tweened Animation Exercise started",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}