package expensereport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateExpenseReport extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String expenserepID;
	public String srNo;
	public String monthlyExpense;
	public String monthlyRent;
	
		
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getMonthlyExpense() {
		return monthlyExpense;
	}
	public void setMonthlyExpense(String monthlyExpense) {
		this.monthlyExpense = monthlyExpense;
	}
	public String getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public String getExpenserepID() {
		return expenserepID;
	}
	public void setExpenserepID(String expenserepID) {
		this.expenserepID = expenserepID;
	}
	public String ret="error";
	public String execute() {

		System.out.println("in update............"+expenserepID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE expensereport_table SET srNo=?, monthlyExpense=?, monthlyRent=?  WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, srNo);		
    		  pst.setString(2, monthlyExpense);
    		  pst.setString(3, monthlyRent);
    		  pst.setString(4, expenserepID);
    		  pst.executeUpdate();
			
    		  request.getSession().setAttribute("Success", "Data Saved");

   
    		pst.close();
    		con.close();
    		    		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("Try Again");
			ret="error";
		}
		
		
		return "success";
	}

	
}
