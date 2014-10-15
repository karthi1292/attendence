package com.example.spinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {

	Spinner spinner;
	Button clickHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        spinner=(Spinner)findViewById(R.id.spinner1);
        clickHere=(Button)findViewById(R.id.button1);
        
        List<String> list=new ArrayList<String>();
        
        list.add("ListView");
        list.add("CustomListView");
        list.add("Navigation");
        list.add("GoogleMaps");
        
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(adapter);
     
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    
        clickHere.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Toast.makeText(MainActivity.this,
	                        "On Button Click : " + 
	                        "\n" + String.valueOf(spinner.getSelectedItem()) ,
	                        Toast.LENGTH_LONG).show();
				
			}
		});
        
    }
    


   
}
