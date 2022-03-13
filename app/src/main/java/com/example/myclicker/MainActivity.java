package com.example.myclicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Integer counter = 0;
    private Integer amountOfNumbers = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams rectangle = counterView.getLayoutParams();
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        amountOfNumbers = savedInstanceState.getInt("amountOfNumbers");
        rectangle.height = savedInstanceState.getInt("rectangle");
        rectangle.width = savedInstanceState.getInt("rectangle1");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams rectangle = counterView.getLayoutParams();
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("amountOfNumbers", amountOfNumbers);
        outState.putInt("rectangle", rectangle.height);
        outState.putInt("rectangle1", rectangle.width);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
    }

    public void onClick(View view)
    {
        counter++;
        TextView counterView = findViewById(R.id.txt_counter);
        ViewGroup.LayoutParams rectangle = counterView.getLayoutParams();
        String textCounter = Integer.toString(counter);
        if (textCounter.length()>amountOfNumbers)
        {
            rectangle.height += 10;
            rectangle.width += 55;
            counterView.setLayoutParams(rectangle);
            amountOfNumbers++;
        }
        counterView.setText(counter.toString());
    }
}
