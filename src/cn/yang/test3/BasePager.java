package cn.yang.test3;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import cn.yang.test.R;

public class BasePager {
	
	public Activity mActivity;
	public LinearLayout mView;//布局对象
	
	public BasePager(Activity activity) {
		mActivity=activity;
		initViews();
	}

	private void initViews() {
		mView = (LinearLayout)View.inflate(mActivity, R.layout.basepager_test3, null);
	}
	
}
