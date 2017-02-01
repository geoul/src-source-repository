package com.biz.jgu.news.biz;

import java.util.List;
import com.biz.jgu.news.vo.NewsVO;

public interface NewsBiz {
	
	/**
	 * 전체 뉴스 기사 제목 조회
	 * @return 전체 뉴스 기사 제목
	 */
	public List<NewsVO> queryAllNews();
	
	/**
	 * 뉴스 기사 제목 등록
	 * @param newNews 새로운 기사
	 */
	public void addNewNews(NewsVO newNews);
	
}
