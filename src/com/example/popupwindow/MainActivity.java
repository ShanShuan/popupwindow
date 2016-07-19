package com.example.popupwindow;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	Button btnShowMore;
	PopupWindow popupWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnShowMore=(Button) findViewById(R.id.btn_show_more);
		btnShowMore.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View view=View.inflate(MainActivity.this, R.layout.more, null);
				if(popupWindow==null){
					popupWindow=new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
					int width=btnShowMore.getWidth();
					int height=btnShowMore.getHeight();
					view.measure(0, 0);
					popupWindow.showAsDropDown(btnShowMore, -width, -height);
					Button btnDismiss=(Button) view.findViewById(R.id.btn_dismiss);
					btnDismiss.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							popupWindow.dismiss();
							popupWindow=null;
						}
					});
					
				}
				
			}
		});
	}


}
