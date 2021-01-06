package com.pg17.cpg17;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class PG17Activity extends Activity {
	
	Integer[] imageIDs = { R.drawable.one, R.drawable.two, R.drawable.three,R.drawable.four};

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(new ImageAdapter(this));  //Calls a user defined function
		
		
		//What should happen when the users clicks on an image in the gallery
		gallery.setOnItemClickListener(new Gallery.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
			
				Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",Toast.LENGTH_SHORT).show();
				
				ImageView imageView = (ImageView) findViewById(R.id.image1);
				imageView.setImageResource(imageIDs[position]);
			}
		});

    }
    public class ImageAdapter extends BaseAdapter {
		private Context context;
		
		//Here is the constructor
		public ImageAdapter(Context c) {
			context = c;
		}

		// returns the number of images
		public int getCount() {
			return imageIDs.length;
		}

		// returns the ID of an item
		public Object getItem(int position) {
			return position;
		}

		// returns the ID of an item
		public long getItemId(int position) {
			return position;
		}

		// ---returns an ImageView view---
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(imageIDs[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
			//imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}

}