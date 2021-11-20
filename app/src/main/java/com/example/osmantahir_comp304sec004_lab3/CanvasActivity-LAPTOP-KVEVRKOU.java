package com.example.osmantahir_comp304sec004_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CanvasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int x=50;
    int y=50;
    int thickness;
    int color=Color.RED;
    ImageView imgVCanvas;
    ArrayList<Path> paths=new ArrayList<Path>();
    ArrayList<Paint> paints=new ArrayList<Paint>();
    String[] thick = { "20", "25", "30", "35","40" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        //add spinner values
        final Spinner spinnerThickness=(Spinner)findViewById(R.id.spnrThick);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, thick);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThickness.setAdapter(adapter);
        spinnerThickness.setOnItemSelectedListener(this);

        //get radio buttons value
        final RadioButton rBtnRed=(RadioButton)findViewById(R.id.rBtnRed);
        final RadioButton rBtnYellow=(RadioButton)findViewById(R.id.rBtnYellow);
        final RadioButton rBtnCyan=(RadioButton)findViewById(R.id.rBtnCyan);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                color=(rBtnRed.isChecked())? Color.RED
                        :(rBtnYellow.isChecked())? Color.GREEN
                        :(rBtnCyan.isChecked())? Color.YELLOW
                        :Color.WHITE;
            }
        });

        imgVCanvas=(ImageView)findViewById(R.id.imageView);
        updateCoordinate();

        final Button buttonRight= (Button) findViewById(R.id.btnRight);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(x+thickness*2<=imgVCanvas.getWidth()){
                    Path p = new Path();
                    p.moveTo(x,y);
                    x+=thickness;
                    p.lineTo(x, y);
                    Paint paint = new Paint();
                    paint.setStyle(Paint.Style.STROKE);
                    setPaint(paint);
                    paint.setColor(color);
                    paint.setStrokeWidth(thickness);
                    paths.add(p);
                    paints.add(paint);
                    updateCoordinate();
                    draw();
                }
            }
        });
        final Button buttonDown= (Button) findViewById(R.id.btnDown);
        buttonDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(y+thickness*2<=imgVCanvas.getHeight()){
                    Path p = new Path();
                    p.moveTo(x,y);
                    y+=thickness;
                    p.lineTo(x, y);
                    Paint paint = new Paint();
                    paint.setStyle(Paint.Style.STROKE);
                    setPaint(paint);
                    paint.setColor(color);
                    paint.setStrokeWidth(thickness);
                    paths.add(p);
                    paints.add(paint);
                    updateCoordinate();
                    draw();
                }
            }
        });
        final Button buttonUp= (Button) findViewById(R.id.btnUp);
        buttonUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(y-thickness*2>=0){
                    Path p = new Path();
                    p.moveTo(x,y);
                    y-=thickness;
                    p.lineTo(x, y);
                    Paint paint = new Paint();
                    setPaint(paint);
                    paint.setColor(color);
                    paint.setStrokeWidth(thickness);
                    paths.add(p);
                    paints.add(paint);
                    updateCoordinate();
                    draw();
                }
            }
        });

        final Button buttonLeft= (Button)findViewById(R.id.btnLeft);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (x - thickness*2 >= 0) {
                    Path p = new Path();
                    p.moveTo(x,y);
                    x-=thickness;
                    p.lineTo(x, y);
                    Paint paint = new Paint();
                    setPaint(paint);
                    paint.setColor(color);
                    paint.setStrokeWidth(thickness);
                    paths.add(p);
                    paints.add(paint);
                    updateCoordinate();
                    draw();
                }
            }
        });
        final Button buttonClear=(Button)findViewById(R.id.btnClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=thickness;
                y=thickness;
                paths.clear();
                paints.clear();
                updateCoordinate();
                draw();
            }
        });
    }

    void setPaint(Paint paint){
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        paint.setPathEffect(new CornerPathEffect(5) );   // set the path effect when they join.
        paint.setAntiAlias(true);                         // set anti alias so it smooths
    }

    void draw(){
        Bitmap bitmap = Bitmap.createBitmap(imgVCanvas.getWidth(), imgVCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imgVCanvas.setImageBitmap(bitmap);

        for (int i=0;i<paths.size()&&i<paints.size();i++){
            canvas.drawPath(paths.get(i),paints.get(i));
        }
    }

    public void updateCoordinate(){
        final TextView txtVCoordinate=findViewById(R.id.txtVCoord);
        txtVCoordinate.setText("x:"+x+" y:"+y);
    }
    //get spinner value
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        thickness=Integer.parseInt(String.valueOf(thick[i]));
        x=thickness;
        y=thickness;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}