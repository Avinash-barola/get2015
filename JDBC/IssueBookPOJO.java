package com.metacube.jdbc.example;

public class IssueBooks {
	static boolean isIssued=false;
	public boolean getIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		IssueBooks.isIssued = isIssued;
	}
}
