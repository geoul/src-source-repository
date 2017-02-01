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
		
		while( true ) {
			System.out.println("========== 뉴스 제목 조회 ==========");
			System.out.println("1. 전체 뉴스 조회");
			System.out.println("2. 뉴스 등록");
			System.out.println("===================================");
			System.out.println("메뉴를 선택하세요.");
			
			chooseMenu = input.nextInt();
			
			if( chooseMenu == 1 ) {
				newsBiz.queryAllNews();
			}
			else if( chooseMenu == 2 ) {
				newsBiz.addNewNews();
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
