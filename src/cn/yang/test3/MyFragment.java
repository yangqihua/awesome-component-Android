package cn.yang.test3;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.yang.test.R;

public class MyFragment extends Fragment {
	private Activity activity;
	private View view;
	private List<BasePager> pagers;
	private ViewPager viewPager;
	
	private TextView tv_title;
	private ImageView[] imagebuttons;
	private TextView[] textviews;
	
	private int index;
	private int currentIndex;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.my_fragment_test3, container, false);
		initPagers();
		initView();
		listenPagerChange();
		return view;
	}
	private void listenPagerChange() {
		viewPager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					index = 0;
					tv_title.setText("聊天");
					break;
				case 1:
					index = 1;
					tv_title.setText("通讯录");
					break;
				case 2:
					index = 2;
					tv_title.setText("发现");
					break;
				default:
					index = 3;
					tv_title.setText("我");
					break;
				}
				imagebuttons[index].setSelected(true);
				imagebuttons[currentIndex].setSelected(false);

				textviews[index].setTextColor(0xFF45C01A);
				textviews[currentIndex].setTextColor(0xFF999999);
				currentIndex = index;
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}
			
		});
	}
	private void initView() {
		viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		viewPager.setAdapter(new ContentAdapter(pagers));
		
		imagebuttons = new ImageView[4];
		imagebuttons[0] = (ImageView)view.findViewById(R.id.ib_weixin);
		imagebuttons[1] = (ImageView) view.findViewById(R.id.ib_contact_list);
		imagebuttons[2] = (ImageView) view.findViewById(R.id.ib_find);
		imagebuttons[3] = (ImageView) view.findViewById(R.id.ib_profile);

		imagebuttons[0].setSelected(true);
		textviews = new TextView[4];
		textviews[0] = (TextView) view.findViewById(R.id.tv_weixin);
		textviews[1] = (TextView) view.findViewById(R.id.tv_contact_list);
		textviews[2] = (TextView) view.findViewById(R.id.tv_find);
		textviews[3] = (TextView) view.findViewById(R.id.tv_profile);
		textviews[0].setTextColor(0xFF45C01A);
		
		tv_title = (TextView) view.findViewById(R.id.txt_title);
		tv_title.setText("聊天");
		currentIndex=0;
		
	}
	private void initPagers() {
		activity = getActivity();
		ChatPager chatPager = new ChatPager(activity);
		ContactPager contactPager = new ContactPager(activity);
		DiscoverPager discoverPager = new DiscoverPager(activity);
		MePager mePager = new MePager(activity);
		pagers = new ArrayList<BasePager>();
		pagers.add(chatPager);
		pagers.add(contactPager);
		pagers.add(discoverPager);
		pagers.add(mePager);
	}
	
	
	
	class ContentAdapter extends PagerAdapter{
		
		private List<BasePager> pagers;
		
		public ContentAdapter(List<BasePager> pagers) {
			this.pagers = pagers;
		}
		@Override
		public int getCount() {
			return pagers.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = pagers.get(position).mView;
			container.addView(view);
			return view;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(pagers.get(position).mView);
		}
	}
}
