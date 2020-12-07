package expense;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class InsertExpense extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String srNo;	
	private String monthlyExpense;
	private String monthlyRent;
	
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
	
	public String ret="error";
	public String execute() {
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession();
		
		// new connectionClass();
		// Connection con1 = connectionClass.getConnection();
		Connection con1=new  connectionClass().getConnection();
		
		String query = "INSERT INTO expense_table (srNo, monthlyExpense, monthlyRent) VALUES(?, ?, ?)";
		try  {
			
	        		  PreparedStatement pst = con1.prepareStatement(query);
	        		  pst.setString(1, srNo);
	        		  pst.setString(2, monthlyExpense);
	        		  pst.setString(3, monthlyRent);
	        		  
	        		  
	      		

	        		  pst.executeUpdate();
	      		

	        		  
	        		  request.getSession().setAttribute("successmsg", "Data Saved");
	  				  
	        		  ret="success";
	        		  pst.close();
	        		  con1.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	ret="error";
	    }
	    
		return ret;
	}
}


	
	