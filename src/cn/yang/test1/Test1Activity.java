package cn.yang.test1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.yang.test.R;

public class Test1Activity extends FragmentActivity {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test1);
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
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, contactfragment, "contact")
				.add(R.id.fragment_container, chatfragment, "chat")
				.add(R.id.fragment_container, disconverfragment, "discover")
				.add(R.id.fragment_container, mefragment, "me").hide(contactfragment).hide(disconverfragment)
				.hide(mefragment).commit();
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
	}

	private void initView() {

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
		getSupportFragmentManager().beginTransaction().hide(fragments.get(currentIndex)).show(fragments.get(index))
				.commit();
		currentIndex = index;
	}

}
