package xq.august2048.activity;

import xq.august2048.R;
import xq.august2048.adapter.GridAdapter;
import xq.august2048.entity.Cards;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnGestureListener, OnTouchListener
{
	int FLING_MIN_GAP = 100;
	int FLING_MIN_DISTANCE = 200;
	double FLING_MIN_VELOCITY = 0.2;
	
	private TextView title, score, scores, best, bests, annoncement;
	private Button start;
	private GridView gridView;

	private GridAdapter gridAdapter;
	private Context con;
	private int[] img;
	private long mExitTime;
	
	private Cards cards;
	
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Remove Title
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		/*
		 * @author http://www.eoeandroid.com/thread-163834-1-1.html
		 * 必须事先在assets底下创建一fonts文件夹 并放入要使用的字体文件(.ttf)
		 * 并提供相对路径给creatFromAsset()来创建Typeface对象
		 */
		Typeface fontFace = Typeface.createFromAsset(getAssets(),
				"fonts/Kim's GirlType.ttf");
		// 字体文件必须是true type font的格式(ttf)；
		// 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为
		// 这个字体android没有支持,而非你的程序发生了错误

		title = (TextView) findViewById(R.id.activity_main_title);
		title.setTypeface(fontFace);
		score = (TextView) findViewById(R.id.activity_main_score);
		score.setTypeface(fontFace);
		scores = (TextView) findViewById(R.id.activity_main_scores);
		scores.setTypeface(fontFace);
		best = (TextView) findViewById(R.id.activity_main_best);
		best.setTypeface(fontFace);
		bests = (TextView) findViewById(R.id.activity_main_bests);
		bests.setTypeface(fontFace);
		annoncement = (TextView) findViewById(R.id.activity_main_annoncement);
		annoncement.setTypeface(fontFace);
		start = (Button) findViewById(R.id.activity_main_start);
		start.setTypeface(fontFace);
		gridView = (GridView) findViewById(R.id.activity_main_grid);

//		img = new int[]
//				{
//				R.drawable.blank,//0
//				R.drawable.one,//1
//				R.drawable.two,//2
//				R.drawable.three,//3
//				R.drawable.four,//4
//				R.drawable.five,//5
//				R.drawable.six,//6
//				R.drawable.seven,//7
//				R.drawable.eight,//8
//				R.drawable.nine,//9
//				R.drawable.ten,//10
//				R.drawable.eleven,//11
//				R.drawable.blank,//12
//				R.drawable.blank,//13
//				R.drawable.blank,//14
//				R.drawable.blank,//15
//				};
		cards = Cards.getInstance();
		img = exchange(cards.getCard(), img);
		con = this;
		
		gridAdapter = new GridAdapter(con, img);
		// Remove Click Animation
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		gridView.setAdapter(gridAdapter);
		
		Display display = getWindowManager().getDefaultDisplay();  
		FLING_MIN_DISTANCE = display.getWidth() / 2;
		FLING_MIN_GAP = FLING_MIN_DISTANCE / 2;
		
		gestureDetector = new GestureDetector(this);
	}

	private int[] exchange(int[][] card , int[] img)
	{
		if(img == null)
			img = new int[16];
		for(int i = 0; i < 16; i++)
		{
			switch(card[i / 4][i % 4])
			{
			case 0:
				img[i] = R.drawable.blank;
				break;
			case 1:
				img[i] = R.drawable.one;
				break;
			case 2:
				img[i] = R.drawable.two;
				break;
			case 3:
				img[i] = R.drawable.three;
				break;
			case 4:
				img[i] = R.drawable.four;
				break;
			case 5:
				img[i] = R.drawable.five;
				break;
			case 6:
				img[i] = R.drawable.six;
				break;
			case 7:
				img[i] = R.drawable.seven;
				break;
			case 8:
				img[i] = R.drawable.eight;
				break;
			case 9:
				img[i] = R.drawable.nine;
				break;
			case 10:
				img[i] = R.drawable.ten;
				break;
			case 11:
				img[i] = R.drawable.eleven;
				break;
			default:
				img[i] = R.drawable.blank;
				break;
			}
		}
		return img;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) 
		{
			if ((System.currentTimeMillis() - mExitTime) > 2000) 
			{
				// Object mHelperUtils;
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();

			} 
			else 
			{
				finish();
//				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onDown(MotionEvent e) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) 
	{
		// TODO Auto-generated method stub
		if(cards.getPlaying() == false)
			return false;
		else
		{
			if(Math.abs(e1.getX() - e2.getX()) - Math.abs(e1.getY() - e2.getY()) > FLING_MIN_GAP)
			{
				if(e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY)  
				{  
//					Toast.makeText(this, "左滑", Toast.LENGTH_SHORT).show();
					cards.stepLeft();
				}  
				else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) 
				{   
//					Toast.makeText(this, "右滑", Toast.LENGTH_SHORT).show();
					cards.stepRight();
				}  
			}
			else if(Math.abs(e1.getY() - e2.getY()) - Math.abs(e1.getX() - e2.getX()) > FLING_MIN_GAP)
			{
				if(e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY)  
				{  
//					Toast.makeText(this, "上滑", Toast.LENGTH_SHORT).show();
					cards.stepUp();
				}  
				else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY) 
				{   
//					Toast.makeText(this, "下滑", Toast.LENGTH_SHORT).show();
					cards.stepDown();
				}
			}
			img = exchange(cards.getCard(), img);
			gridAdapter.notifyDataSetChanged();
			scores.setText(cards.getScore() + "");
			if(cards.whetherSuccessful() == true)
			{
				
			}
			else if(cards.whetherFailed() == false)
			{
				
			}
			return false;
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) 
	{
		// TODO Auto-generated method stub
		gestureDetector.onTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}
}
