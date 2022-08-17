package com.ysh.practice;

public class Book {
	String title;
	String author;
	
	void show() {
		System.out.println(title + " " + author);
	}
	
	public Book() {
		this("","");
		System.out.println("생성자 호출됨");
	}
	public Book(String title) {//생성자
		this(title,"작자 미상");
		
	}
	public Book(String title, String author) {//생성자
	this.title =title;
	this.author = author;
	}
	
	public static void main(String[] args) {
		//생성자 Book(String t)호출
		Book loveStory = new Book("춘향전");
		
		//생성자 Book(String t, String a) 호출
		Book littlePrince = new Book("어린왕자", "생텍쥐페리");
		
		Book emptyBook = new Book();
		
		littlePrince.show();
		
		
		
	}

}
