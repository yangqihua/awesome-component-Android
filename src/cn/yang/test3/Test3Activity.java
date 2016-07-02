package cn.yang.test3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import cn.yang.test.R;
import cn.yang.utils.Utils;

public class Test3Activity extends FragmentActivity {
	
	private Fragment mFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test3);
		initFragment();
		
	}

	private void initFragment() {
		mFragment = new MyFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, mFragment,"MyFragment")
		.commit();
	}
	
	public void onTabClicked(View view) {
		Utils.showShortToast(this, "请滑动屏幕来切换界面");
	}

}
