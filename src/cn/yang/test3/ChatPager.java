package cn.yang.test3;

import android.app.Activity;
import android.widget.TextView;

public class ChatPager extends BasePager {

	public ChatPager(Activity activity) {
		super(activity);
		initData();
	}

	private void initData() {
		TextView textView = new TextView(mActivity);
		textView.setText("ChatPager");
		mView.addView(textView);
	}

	
}
