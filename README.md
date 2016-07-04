# awesome-component-Android
收集了现在app的一些主流组件，小框架，工具类，技巧等，适合快速开发（学习），**绝对干货！！！**
如果您觉得有用，欢迎star，如果有问题，欢迎Issue！大家一起学习交流。

##1.目前的功能或特性

* 1.四个fragment实现导航栏
* 2.一个viewpager和四个fragment实现导航栏
* 3.一个fragment和四个viewpager实现导航栏
* 4.实现下拉刷新和上拉加载更多效果
* 5.仿各大主流app的下拉选择菜单
* 6.实现图片轮转广告栏
* 7.两行代码实现万能ListView适配器
</ul>

MainActivity进入后的界面：<br/>

![image](http://119.29.4.130/screenshots/awesome-component-Android/main.jpg)


##2.功能介绍和演示

* 四个fragment实现导航栏

    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test1.gif)<br/><br/>

* 一个viewpager和四个fragment实现导航栏

    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test2.gif)<br/><br/>
    
* 一个fragment和四个viewpager实现导航栏
    
    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test3.gif)<br/><br/>
    
* 实现下拉刷新和上拉加载更多效果
    
    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test4.gif)<br/><br/>

* 仿各大主流app的下拉选择菜单
    
    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test5.gif)<br/><br/>

* 实现图片轮转广告栏
    
    ![image](http://119.29.4.130/screenshots/awesome-component-Android/test6.gif)<br/><br/>

* 两行代码实现万能ListView适配器(ListViewAdapter):
    * 复制cn.yang.utils包中的CommonAdapter和ViewHolder到自己的项目中
    * 构造adapter(调用类似下面的代码)
    ```java
        adapter = new CommonAdapter<News>(this, newsList, R.layout.item_list_test4) {
    		@Override
			public void convert(ViewHolder holder, News mNews) {
				holder.setText(R.id.title, mNews.getTitle()).setText(R.id.content, mNews.getContent())
						.setImageResource(R.id.imageView1, mNews.getImgId());
			}
		};
    ```
    * 其中newsList替换成你的数据，item_list_test4替换成你的listView布局文件
    * 详细代码参照cn.yang.test4中的Test4Activity

    
* [顶部viewpager参考这里](https://github.com/CaMnter/EasySlidingTabs.git)
