package cn.yang.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.yang.test1.Test1Activity;
import cn.yang.test2.Test2Activity;
import cn.yang.test3.Test3Activity;
import cn.yang.test4.Test4Activity;
import cn.yang.test5.Test5Activity;
import cn.yang.test6.Test6Activity;
import cn.yang.test7.Test7Activity;
import cn.yang.test8.Test8Activity;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void click(View view){
		int id = view.getId();
		Intent intent;
		switch (id) {
		case R.id.button1:
			intent = new Intent(this,Test1Activity.class);
			startActivity(intent);
			break;
		case R.id.button2:
			intent = new Intent(this,Test2Activity.class);
			startActivity(intent);
			break;
		case R.id.button3:
			intent = new Intent(this,Test3Activity.class);
			startActivity(intent);
			break;
		case R.id.button4:
			intent = new Intent(this,Test4Activity.class);
			startActivity(intent);
			break;
		case R.id.button5:
			intent = new Intent(this,Test5Activity.class);
			startActivity(intent);
			break;
		case R.id.button6:
			intent = new Intent(this,Test6Activity.class);
			startActivity(intent);
			break;
		case R.id.button7:
			intent = new Intent(this,Test7Activity.class);
			startActivity(intent);
			break;
		case R.id.button8:
			intent = new Intent(this,Test8Activity.class);
			startActivity(intent);
			break;
		case R.id.button9:
			break;
		case R.id.button10:
			break;
		default:
			break;
		}
	}
	
}
