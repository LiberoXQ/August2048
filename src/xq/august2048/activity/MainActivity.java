package xq.august2048.activity;

import xq.august2048.R;
import xq.august2048.adapter.GridAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView title, score, scores, best, bests, annoncement;
	private Button start;
	private GridView gridView;

	private GridAdapter gridAdapter;
	private Context con;
	private int[] img;
	private long mExitTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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

		img = new int[]
				{
				R.drawable.blank,//0
				R.drawable.one,//1
				R.drawable.two,//2
				R.drawable.three,//3
				R.drawable.four,//4
				R.drawable.five,//5
				R.drawable.six,//6
				R.drawable.seven,//7
				R.drawable.eight,//8
				R.drawable.nine,//9
				R.drawable.ten,//10
				R.drawable.eleven,//11
				R.drawable.blank,//12
				R.drawable.blank,//13
				R.drawable.blank,//14
				R.drawable.blank,//15
				};
		con = this;
		gridAdapter = new GridAdapter(con, img);
		// Remove Click Animation
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		gridView.setAdapter(gridAdapter);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				// Object mHelperUtils;
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();

			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
