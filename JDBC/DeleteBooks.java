package com.metacube.jdbc.example;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteBooks {
	public static void main(String[] args) throws IOException {
		getDeletedBooks();
		if(getDeletedBooks())
		System.out.println(DeleteBook.getNumberOfBooksDeleted()+" Book Deleted Successfully");
		else
			System.out.println("No book deleted");
	}
	/* execute query using prepared statement*/
	/*method to get number of books deleted*/
	private static boolean getDeletedBooks() {
		Connection con = null;
		boolean isDeleted=false;
		PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		/*Query to Delete all those books which were not issued in last 1 year. Return the number of books deleted.*/
		String query =	"DELETE FROM books WHERE (books.accession_no NOT IN (SELECT accession_no FROM book_issue) AND DATEDIFF(now(),books.purchase_date)>365) OR books.accession_no IN (SELECT bi.accession_no FROM book_issue bi WHERE DATEDIFF(now(),bi.issue_date)>365 AND (bi.accession_no,bi.issue_date,bi.member_id) IN (SELECT br.accession_no,br.issue_date,br.member_id FROM book_return br));";
		try {
			ps = con.prepareStatement(query);
			//set value of POJO class variable
			if(ps.executeUpdate()>0) {
				isDeleted=true;
				DeleteBook.numberOfBooksDeleted=ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isDeleted;
	}

}
