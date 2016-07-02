package cn.yang.test4;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import cn.yang.test.R;
import cn.yang.test4.MyListView.OnLoadMore;
import cn.yang.utils.CommonAdapter;
import cn.yang.utils.ViewHolder;

public class Test4Activity extends Activity {

	private SwipeRefreshLayout mSwipeLayout;
	private MyListView mListView;

	private List<News> newsList;

	private CommonAdapter<News> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test4);
		initData();
		initView();
		initListView();
		initSwipeLatout();
	}

	private void initData() {
		newsList = new ArrayList<Test4Activity.News>();
		for (int i = 0; i < 8; i++) {
			News news = new News("titile" + i, "content" + i, R.drawable.weixin_pressed);
			newsList.add(news);
		}
	}

	private void initView() {
		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.refreshlayout);
		mListView = (MyListView) findViewById(R.id.listview);
	}

	private void initListView() {
		adapter = new CommonAdapter<News>(this, newsList, R.layout.item_list_test4) {
			@Override
			public void convert(ViewHolder holder, News mNews) {
				holder.setText(R.id.title, mNews.getTitle()).setText(R.id.content, mNews.getContent())
						.setImageResource(R.id.imageView1, mNews.getImgId());
			}
		};
		mListView.setAdapter(adapter);
		
		mListView.setOnLoadMore(new OnLoadMore() {
			@Override
			public void onLoad() {
				loadNextPagerDatas();
			}
		});
	}

	protected void loadNextPagerDatas() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					News news = new News("上拉加载更多 title" + i, "上拉加载更多 content" + i, R.drawable.weixin_pressed);
					newsList.add(news);
				}
				mListView.loadComplete();
				adapter.notifyDataSetChanged();
			}
		}, 2000);
	}

	private void initSwipeLatout() {
		mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright);
		mSwipeLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				loadRecentDatas();
			}
		});
	}

	protected void loadRecentDatas() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					News news = new News("下拉刷新 title" + i, "下拉刷新 content" + i, R.drawable.weixin_pressed);
					newsList.add(news);
				}
				mSwipeLayout.setRefreshing(false);
				adapter.notifyDataSetChanged();
			}
		}, 2000);
		
	}

	class News {
		private String title;
		private String content;
		private int imgId;

		public News(String title, String content, int imgId) {
			super();
			this.title = title;
			this.content = content;
			this.imgId = imgId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getImgId() {
			return imgId;
		}

		public void setImgId(int imgId) {
			this.imgId = imgId;
		}

	}

}
