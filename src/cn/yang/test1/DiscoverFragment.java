package cn.yang.test1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.yang.test.R;
import cn.yang.utils.Utils;

public class DiscoverFragment extends Fragment {
	
	private Context mActivity;
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mActivity = getActivity();
		if (view == null) {
			view = inflater.inflate(R.layout.fragment3_test1, container, false);
		}
		return view;
	}
	
	public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);};
	
	@Override
	public void onPause() {
		super.onPause();
//		Utils.showShortToast(mActivity, "DiscoverFragment onPause!");
	}
	
	@Override
	public void onResume() {
		super.onResume();
//		Utils.showShortToast(mActivity, "DiscoverFragment onResume!");
	}
}
