package com.example.asynctask1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {
	
	int count;
	public static final int progress_bar_type = 0; 
	private ProgressDialog progressdialog;
	Button b1;
	ImageView image;
	private static String url = "http://api.androidhive.info/progressdialog/hive.jpg";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        image=(ImageView)findViewById(R.id.imageView1);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DownloadFileFromUrl().execute(url);
				
			}
		});
      }
    
    @Override
    protected Dialog onCreateDialog(int id){
    	switch(id){
    	case progress_bar_type:
    		progressdialog=new ProgressDialog(this);
    		progressdialog.setMessage("Downloading file.Please Wait...");
    		progressdialog.setIndeterminate(false);
            progressdialog.setMax(100);
    		progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    		//progressdialog.setCancelable(true);
    		progressdialog.show();
    		return progressdialog;
    	default: 
    		return null;
    	}
	
    	
    	
    }
    
    class DownloadFileFromUrl extends AsyncTask<String,String,String> {
    
		@Override
    	protected void onPreExecute(){
    		
    		super.onPreExecute();
    		showDialog(progress_bar_type);
    	}
    	
		

		@Override
		protected String doInBackground(String... url) {
			// TODO Auto-generated method stub
			
			try {
				URL furl=new URL(url[0]);
				URLConnection urlconnection=furl.openConnection();
				urlconnection.connect();
				int lengthoffile=urlconnection.getContentLength();
				
				InputStream input=new BufferedInputStream(furl.openStream(),8192);
				
			
				OutputStream output=new FileOutputStream("/sdcard/downloadedfile.jpg");
				
				byte data[]=new byte[1024];
				
				long total=0;
				
				while((count=input.read(data))!=-1){
				total+=count;
				publishProgress(""+(int)((total*100)/lengthoffile));
				
				output.write(data, 0, count);
					
				}
				output.flush();
				output.close();
				input.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				  Log.e("Error: ", e.getMessage());
			}
			
			return null;
		}
		
		protected void onProgressUpdate(String...progress){
			
			
			progressdialog.setProgress(Integer.parseInt(progress[0]));
		}

		@Override
		protected void onPostExecute(String url){
			
			dismissDialog(progress_bar_type);
			String imagepath=Environment.getExternalStorageDirectory().toString()+ "/downloadedfile.jpg";
			image.setImageDrawable(Drawable.createFromPath(imagepath));
		}
    }
}
