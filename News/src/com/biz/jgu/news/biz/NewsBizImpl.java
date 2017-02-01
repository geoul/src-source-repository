package com.biz.jgu.news.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.jgu.news.dao.NewsDao;
import com.biz.jgu.news.dao.NewsDaoImpl;
import com.biz.jgu.news.vo.NewsVO;

public class NewsBizImpl implements NewsBiz {
	
	private Scanner input;
	private NewsDao newsDao;
	
	
	public NewsBizImpl() {
		input = new Scanner(System.in);
		newsDao = new NewsDaoImpl();
	}
	
	@Override
	public void queryAllNews() {
		List<NewsVO> newsList = newsDao.queryAllNews();
		for( NewsVO news : newsList) {
			System.out.printf("뉴스 제목 : %s, 언론사 : %s, 기자이름 : %s\n", 
					news.getTitle(), news.getPress(), news.getName());
		}
	}

	@Override
	public void addNewNews() {
		NewsVO newsVO;
		System.out.println("새로운 기사를 등록하세요.");
		System.out.println("뉴스 제목을 입력하세요.");
		String titleTemp = input.next();
		System.out.println("언론사를 입력하세요.");
		String pressTemp = input.next();
		System.out.println("기자 이름을 입력하세요.");
		String nameTemp = input.next();
		
		newsVO = new NewsVO();
		newsVO.setTitle(titleTemp);
		newsVO.setPress(pressTemp);
		newsVO.setName(nameTemp);
		
		newsDao.addNewNews(newsVO);
	}

}
