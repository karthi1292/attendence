package com.example.attendance2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;


public class MainActivity extends Activity {
	long date_id;
	Student student;
	String[] id_array;
	int i = 0;
	EditText date;
	SqliteAdapter db;
	ListView lv;
	ArrayList<Student> storedValues;
	Switch s1;
	String[] names={"KARTHI","MOHAN","MALAI","KALAI","VIJAY","MALA","RAGU","LOGU","BALA","PRASANNA","JAGA","JACK","MANOJ","RANJITH","PRAVEEN"};
	Button submit;
	long name1_id,name2_id,name3_id,name4_id,name5_id,name6_id,name7_id,name8_id,name9_id,name10_id,name11_id,name12_id,name13_id,name14_id;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv=(ListView)findViewById(R.id.listView1);
        s1=(Switch)findViewById(R.id.switch1);
        submit=(Button)findViewById(R.id.button1);
        date=(EditText)findViewById(R.id.editText1);
        
        db=new SqliteAdapter(this);
    
	     name1_id= db.addStudent(new Student("KARTHI"));
	     name2_id= db.addStudent(new Student("MOHAN"));
	     name3_id=db.addStudent(new Student("MALAI"));
	     name4_id= db.addStudent(new Student("KALAI"));
	     name5_id=db.addStudent(new Student("VIJAY"));
	     name6_id=db.addStudent(new Student("MALA"));
	     name7_id=db.addStudent(new Student("RAGU"));
	     name8_id=db.addStudent(new Student("LOGU"));
	     name9_id =   db.addStudent(new Student("BALA"));
	     name10_id= db.addStudent(new Student("PRASANNA"));
	     name11_id=db.addStudent(new Student("JAGA"));
	     name12_id = db.addStudent(new Student("JACK"));
	     name13_id =db.addStudent(new Student("MANOJ"));
	     name14_id=db.addStudent(new Student("RANJITH"));
        
         
        storedValues=db.getAllStudents();
        
       
        
        date_id=db.addDATE(new DateData(date.getText().toString()));
        
        CustomAdapter adapter=new CustomAdapter(this, storedValues,date_id);
        lv.setAdapter(adapter);
    }
       
      public void MainData(int position , boolean isChecked){
				
				Log.e("main method", "" + position);
				
				switch(position){   
			case 0:
				
					if(i>0){
						Log.e("val", "update");
						db.updateDATA(name1_id,date_id,isChecked);
					}
					else{
						Log.e("val", "add");
						db.addPresent(name1_id,date_id,isChecked);
					    i=1;
					}
					break;
					
			/*case 1:
				if(i>0){
					db.updateDATA(name2_id,date_id,isChecked);
					Log.e("val","2");
				}
				else{
					Log.e("val","2");
					db.addPresent(name2_id,date_id,isChecked);
					i++;
				}
				break;
				
			case 2:
				if(i>0){
						db.updateDATA(name3_id,date_id,isChecked);
				}
				else{
						db.addPresent(name3_id,date_id,isChecked);
				 i++;
					}
				break;
			case 3:
					if(i>0){
							db.updateDATA(name4_id,date_id,isChecked);
					}
					else{
							db.addPresent(name4_id,date_id,isChecked);
					 i++;
						}
					break;
			case 4:
						if(i>0){
							db.updateDATA(name5_id,date_id,isChecked);
					}
					else{
							db.addPresent(name5_id,date_id,isChecked);
					 i++;
						}
					break;
			case 5:
						if(i>0){
							db.updateDATA(name6_id,date_id,isChecked);
					}
					else{
							db.addPresent(name6_id,date_id,isChecked);
					 i++;
						}
					break;
			case 6:
						if(i>0){
							db.updateDATA(name7_id,date_id,isChecked);
					}
					else{
							db.addPresent(name7_id,date_id,isChecked);
					 i++;
						}
						break;
			case 7:
						if(i>0){
							db.updateDATA(name8_id,date_id,isChecked);
					}
					else{
							db.addPresent(name8_id,date_id,isChecked);
					 i++;
						}
						break;
			case 8:
						if(i>0){
							db.updateDATA(name9_id,date_id,isChecked);
					}
					else{
							db.addPresent(name9_id,date_id,isChecked);
					 i++;
						}
						break;
			case 9:
						if(i>0){
							db.updateDATA(name10_id,date_id,isChecked);
					}
					else{
							db.addPresent(name10_id,date_id,isChecked);
					 i++;
						}
						break;
			case 10:
						if(i>0){
							db.updateDATA(name11_id,date_id,isChecked);
					}
					else{
							db.addPresent(name11_id,date_id,isChecked);
					 i++;
						}	
						break;
			case 11:
						if(i>0){
							db.updateDATA(name12_id,date_id,isChecked);
					}
					else{
							db.addPresent(name12_id,date_id,isChecked);
					 i++;
						}
						break;
			case 12:
					if(i>0){
							db.updateDATA(name13_id,date_id,isChecked);
					}
					else{
							db.addPresent(name13_id,date_id,isChecked);
					 i++;
						}
					break;
			case 13:
					if(i>0){
						db.updateDATA(name14_id,date_id,isChecked);
					}
					else{
						
						db.addPresent(name14_id,date_id,isChecked);
					 i++;
					}	
					break;*/
					
					default:
						break;
		}
				
      }
        
	}
   
   
 
  
