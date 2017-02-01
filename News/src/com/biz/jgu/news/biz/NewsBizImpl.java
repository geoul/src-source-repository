package com.biz.jgu.news.biz;

import java.util.ArrayList;
import java.util.List;

import com.biz.jgu.news.vo.NewsVO;

public class NewsBizImpl implements NewsBiz {
	
	private List<NewsVO> newsList; //멤버변수
	
	public NewsBizImpl() {
		newsList = new ArrayList<NewsVO>(); //멤버변수 초기화
	}
	
	@Override
	public List<NewsVO> queryAllNews() {
		return newsList;
	}

	@Override
	public void addNewNews(NewsVO newNews) {
		newsList.add(newNews);
	}

}
