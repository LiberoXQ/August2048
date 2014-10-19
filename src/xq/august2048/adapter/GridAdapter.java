package xq.august2048.adapter;

import xq.august2048.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff; 
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
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
//		iv.setImageResource(image[position]);
		Bitmap photo = BitmapFactory.decodeResource(context.getResources(), R.drawable.blank);
        iv.setImageBitmap(createFramedPhoto(photo.getWidth(),photo.getHeight(),photo,(int)(photo.getWidth()/4)));
		return iv;
	}
	
	/**
    * @author http://blog.chinaunix.net/uid-20771867-id-3260250.html
    * @param x 图像的宽度
    * @param y 图像的高度
    * @param image 源图片
    * @param outerRadiusRat 圆角的大小
    * @return 圆角图片
    */
   Bitmap createFramedPhoto(int x, int y, Bitmap image, float outerRadiusRat) 
   {
       //根据源文件新建一个darwable对象
       Drawable imageDrawable = new BitmapDrawable(image);

       // 新建一个新的输出图片
       Bitmap output = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
       Canvas canvas = new Canvas(output);

       // 新建一个矩形
       RectF outerRect = new RectF(0, 0, x, y);

       // 产生一个红色的圆角矩形
       Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
       paint.setColor(Color.RED);
       canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);

       // 将源图片绘制到这个圆角矩形上
       paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
       imageDrawable.setBounds(0, 0, x, y);
       canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
       imageDrawable.draw(canvas);
       canvas.restore();

       return output;
   }
	
}
