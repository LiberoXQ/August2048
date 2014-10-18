package xq.august2048.activity;


import xq.august2048.R;
import xq.august2048.adapter.GridAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	TextView title, score, scores, best, bests, annoncement;
	Button start;
	GridView grid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Remove Title
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		int[] img = new int[]
				{
				R.drawable.blank,//0
				R.drawable.blank,//1
				R.drawable.blank,//2
				R.drawable.blank,//3
				R.drawable.blank,//4
				R.drawable.blank,//5
				R.drawable.blank,//6
				R.drawable.blank,//7
				R.drawable.blank,//8
				R.drawable.blank,//9
				R.drawable.blank,//10
				R.drawable.blank,//11
				R.drawable.blank,//12
				R.drawable.blank,//13
				R.drawable.blank,//14
				R.drawable.blank,//15
				};
		Context con = this;
		//Remove Click Animation
		grid.setSelector(new ColorDrawable(Color.TRANSPARENT));
		grid.setAdapter(new GridAdapter(con, img));
	}
	
	void initView()
	{
		title = (TextView)findViewById(R.id.activity_main_title);
		score = (TextView)findViewById(R.id.activity_main_score);
		scores = (TextView)findViewById(R.id.activity_main_scores);
		best = (TextView)findViewById(R.id.activity_main_best);
		bests = (TextView)findViewById(R.id.activity_main_bests);
		annoncement = (TextView)findViewById(R.id.activity_main_annoncement);
		start = (Button)findViewById(R.id.activity_main_start);
		grid = (GridView)findViewById(R.id.activity_main_grid);
	}
	
}
