package cn.yang.test3;

import android.app.Activity;
import android.widget.TextView;

public class DiscoverPager extends BasePager {

	public DiscoverPager(Activity activity) {
		super(activity);
		initData();
	}

	private void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("DiscoverPager");
		mView.addView(textView);
	}

	
}
