package com.metacube.jdbc.example;

public class DeleteBook {
	static int numberOfBooksDeleted=0;
	public static int getNumberOfBooksDeleted() {
		return numberOfBooksDeleted;
	}
	public static void setNumberOfBooksDeleted(int numberOfBooksDeleted) {
		DeleteBook.numberOfBooksDeleted = numberOfBooksDeleted;
	}
}
