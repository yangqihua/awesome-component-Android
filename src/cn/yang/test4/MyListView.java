package cn.yang.test4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.yang.test.R;

public class MyListView extends ListView implements OnScrollListener {
	
	private View footer;
	private LinearLayout footerLayout;
	private ProgressBar progressBar;
	private TextView tv_loadMore;
	
	
	private int totalItemCount;
	
	private int lastVisibleItem;
	
	private boolean isLoading;
	
	private OnLoadMore onLoadMore;
	
	public void setOnLoadMore(OnLoadMore onLoadMore) {
		this.onLoadMore = onLoadMore;
	}

	public MyListView(Context context) {
		super(context);
		initView(context);
	}
	

	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}
	
	public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context);
	}
	
	@SuppressLint("InflateParams")
	private void initView(Context context) {
		isLoading = false;
		footer = LayoutInflater.from(context).inflate(R.layout.pulltorefresh_footer_test4, null);
		footerLayout = (LinearLayout) footer.findViewById(R.id.footer_layout);
		progressBar = (ProgressBar) footer.findViewById(R.id.progressbar);
		tv_loadMore = (TextView) footer.findViewById(R.id.tv_loadmore);
		tv_loadMore.setText("加载更多");
		progressBar.setVisibility(View.GONE);
		this.addFooterView(footer);
		this.setOnScrollListener(this);
	}
	
	public void loadComplete(){
		isLoading = false;
		tv_loadMore.setText("加载更多");
		progressBar.setVisibility(View.GONE);
	}


	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if (totalItemCount==lastVisibleItem && scrollState==SCROLL_STATE_IDLE) {
			if (!isLoading) {
				isLoading = true;
				tv_loadMore.setText("正在加载更多...");
				progressBar.setVisibility(View.VISIBLE);
				//加载更多操作:
				onLoadMore.onLoad();
			}
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		this.lastVisibleItem = firstVisibleItem+visibleItemCount;
		this.totalItemCount = totalItemCount;
		Log.e("scroll", "lastVisibleItem="+lastVisibleItem+",totalItemCount="+totalItemCount);
	}
	
	public interface OnLoadMore{
		public void onLoad();
	}
	
}
