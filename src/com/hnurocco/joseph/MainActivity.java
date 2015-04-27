package com.hnurocco.joseph;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b = (Button)findViewById(R.id.Calculate);
		final EditText in_n = (EditText)findViewById(R.id.input_n);
		final EditText in_m = (EditText)findViewById(R.id.input_m);
		final TextView out = (TextView)findViewById(R.id.out);
		out.setMovementMethod(new ScrollingMovementMethod());
		final String tn = in_n.getText().toString();
		final String tm = in_n.getText().toString();
		b.setOnClickListener(new OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				if((in_n.getText().toString().isEmpty())||(in_m.getText().toString().isEmpty())){
					
					Toast t =Toast.makeText(MainActivity.this, "Please enter item", Toast.LENGTH_SHORT);
				    t.show();
					
				}
				else{
					out.setText("");
					int num = Integer.parseInt(in_n.getText().toString());
					int step = Integer.parseInt(in_m.getText().toString());
					int[] ring= new int[num];
					for (int tj = 0; tj < num; tj++)
						ring[tj] = tj + 1;
					ring[num-1] = 0;
					int x = num - 1;
					String s;
					while(ring[x]!=x){
						int tj = step - 1;
						while(tj-->0){
							x = ring[x];
						}
						out.append(String.valueOf(ring[x]+1) + " ");
						ring[x] = ring[ring[x]];
						out.append("\n");
					}
					out.append(String.valueOf(x+1) + " ");
					
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
