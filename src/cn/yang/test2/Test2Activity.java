package cn.yang.test2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.yang.test.R;
import cn.yang.test1.ChatFragment;
import cn.yang.test1.ContactFragment;
import cn.yang.test1.DiscoverFragment;
import cn.yang.test1.MeFragment;

public class Test2Activity extends FragmentActivity {

	private List<Fragment> fragments;
	private ChatFragment chatfragment;
	private ContactFragment contactfragment;
	private DiscoverFragment disconverfragment;
	private MeFragment mefragment;
	private int index;
	private int currentIndex;

	protected static final String TAG = "Test1Activity";

	private ImageView[] imagebuttons;
	private TextView[] textviews;

	private TextView tv_title;
	
	private ViewPager viewpager;
	private PagerAdapter adpter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test2);
		initData();
		initView();
	}

	private void initData() {
		chatfragment = new ChatFragment();
		contactfragment = new ContactFragment();
		disconverfragment = new DiscoverFragment();
		mefragment = new MeFragment();
		fragments = new ArrayList<Fragment>();
		fragments.add(chatfragment);
		fragments.add(contactfragment);
		fragments.add(disconverfragment);
		fragments.add(mefragment);
		currentIndex = 0;

		imagebuttons = new ImageView[4];
		imagebuttons[0] = (ImageView) findViewById(R.id.ib_weixin);
		imagebuttons[1] = (ImageView) findViewById(R.id.ib_contact_list);
		imagebuttons[2] = (ImageView) findViewById(R.id.ib_find);
		imagebuttons[3] = (ImageView) findViewById(R.id.ib_profile);

		imagebuttons[0].setSelected(true);
		textviews = new TextView[4];
		textviews[0] = (TextView) findViewById(R.id.tv_weixin);
		textviews[1] = (TextView) findViewById(R.id.tv_contact_list);
		textviews[2] = (TextView) findViewById(R.id.tv_find);
		textviews[3] = (TextView) findViewById(R.id.tv_profile);
		textviews[0].setTextColor(0xFF45C01A);
		
		tv_title = (TextView) findViewById(R.id.txt_title);
		tv_title.setText("聊天");
		
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		adpter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				return fragments.size();
			}
			
			@Override
			public Fragment getItem(int position) {
				return fragments.get(position);
			}
		}; 
	}

	private void initView() {
		viewpager.setAdapter(adpter);
		viewpager.addOnPageChangeListener(new OnPageChangeListener() {
			
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
			public void onPageScrolled(int position,float positionOffset, int positionOffsetPixels) {
				/*
				 * 1.position:向右翻页,position和当前页一致；向左翻页，和目标页一致
				 * 2.positionOffset：当前页面滑动比例，如果页面向右翻动，这个值不断变大，最后在趋近1的情况后突变为0。如果页面向左翻动，这个值不断变小，最后变为0。
				 * 3.当前页面滑动像素，变化情况和positionOffset一致
				 */
//				Log.e(TAG, " arg0="+arg0+",arg1="+arg1+",arg2="+arg2);
//				有三个参数，第一个position，这个参数要特别注意一下。当用手指滑动时，如果手指按在页面上不动，position和当前页面index是一致的；如果手指向左拖动（相应页面向右翻动）
//				，这时候position大部分时间和当前页面是一致的，只有翻页成功的情况下最后一次调用才会变为目标页面；如果手指向右拖动（相应页面向左翻动），
//				这时候position大部分时间和目标页面是一致的，只有翻页不成功的情况下最后一次调用才会变为原页面。
//				当直接设置setCurrentItem翻页时，如果是相邻的情况（比如现在是第二个页面，跳到第一或者第三个页面），如果页面向右翻动，大部分时间是和当前页面是一致的，
//				只有最后才变成目标页面；如果向左翻动，position和目标页面是一致的。这和用手指拖动页面翻动是基本一致的。
//				如果不是相邻的情况，比如我从第一个页面跳到第三个页面，position先是0，然后逐步变成1，然后逐步变成2；我从第三个页面跳到第一个页面，position先是1，
//				然后逐步变成0，并没有出现为2的情况。
//				positionOffset是当前页面滑动比例，如果页面向右翻动，这个值不断变大，最后在趋近1的情况后突变为0。如果页面向左翻动，这个值不断变小，最后变为0。
//				positionOffsetPixels是当前页面滑动像素，变化情况和positionOffset一致。
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {//0（END）,1(PRESS) , 2(UP) 。
			}
		});
	}

	public void onTabClicked(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.re_weixin:
			index = 0;
			tv_title.setText("聊天");
			break;
		case R.id.re_contact_list:
			index = 1;
			tv_title.setText("通讯录");
			break;
		case R.id.re_find:
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
		viewpager.setCurrentItem(index);
		currentIndex = index;
	}

}
