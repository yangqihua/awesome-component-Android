package cn.yang.test3;

import android.app.Activity;
import android.widget.TextView;

public class ContactPager extends BasePager {

	public ContactPager(Activity activity) {
		super(activity);
		initData();
	}

	private void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("ContactPager");
		mView.addView(textView);
	}

	
}
