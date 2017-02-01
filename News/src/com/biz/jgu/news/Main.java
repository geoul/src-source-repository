package com.biz.jgu.news;

import java.util.List;
import java.util.Scanner;

import com.biz.jgu.news.biz.NewsBiz;
import com.biz.jgu.news.biz.NewsBizImpl;
import com.biz.jgu.news.vo.NewsVO;

public class Main {

	public void start() {
		
		NewsBiz newsBiz = new NewsBizImpl();
		
		Scanner input = new Scanner(System.in);
		int chooseMenu = 0;
		
		List<NewsVO> newsList = null;
		NewsVO newsVO = null;
		
		// 임시로 데이터를 받을 변수들
		String titleTemp = "";
		String pressTemp = "";
		String nameTemp = "";
		
		while( true ) {
			System.out.println("========== 뉴스 제목 조회 ==========");
			System.out.println("1. 전체 뉴스 조회");
			System.out.println("2. 뉴스 등록");
			System.out.println("===================================");
			System.out.println("메뉴를 선택하세요.");
			
			chooseMenu = input.nextInt();
			
			if( chooseMenu == 1 ) {
				newsList = newsBiz.queryAllNews();
				for( NewsVO news : newsList) {
					System.out.printf("뉴스 제목 : %s, 언론사 : %s, 기자이름 : %s\n", 
							news.getTitle(), news.getPress(), news.getName());
				}
			}
			else if( chooseMenu == 2 ) {
				System.out.println("새로운 기사를 등록하세요.");
				System.out.println("뉴스 제목을 입력하세요.");
				titleTemp = input.next();
				System.out.println("언론사를 입력하세요.");
				pressTemp = input.next();
				System.out.println("기자 이름을 입력하세요.");
				nameTemp = input.next();
				
				newsVO = new NewsVO();
				newsVO.setTitle(titleTemp);
				newsVO.setPress(pressTemp);
				newsVO.setName(nameTemp);
				
				newsBiz.addNewNews(newsVO);
			}
			else {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
