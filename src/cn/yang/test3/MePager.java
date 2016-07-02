package cn.yang.test3;

import android.app.Activity;
import android.widget.TextView;

public class MePager extends BasePager {

	public MePager(Activity activity) {
		super(activity);
		initData();
	}

	private void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("MePager");
		mView.addView(textView);
	}

	
}
