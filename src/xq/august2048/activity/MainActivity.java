package xq.august2048.activity;


import xq.august2048.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
	TextView title, score, scores, best, bests, annoncement;
	Button start;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Remove Title
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
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
	}
}
