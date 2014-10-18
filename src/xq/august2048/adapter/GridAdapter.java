package xq.august2048.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter
{
	Context context = null;
	int[] image = null;

	public GridAdapter(Context con, int[] img)
	{
		context = con;
		image = img;
	}
	
	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return image.length;
	}

	@Override
	public Object getItem(int position) 
	{
		// TODO Auto-generated method stub
		return image[position];
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		ImageView iv = null;
		iv = new ImageView(context);
		iv.setImageResource(image[position]);
		//Get Device Parameter
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
//		LayoutParams lp = iv.getLayoutParams();
//		if(lp == null) lp = new LayoutParams(100,100);
//		lp.height = (int)((dm.widthPixels - 50) / 4);
//	    lp.width = (int)((dm.widthPixels - 50) / 4);
//	    iv.setLayoutParams(lp);
		return iv;
	}
	
}
