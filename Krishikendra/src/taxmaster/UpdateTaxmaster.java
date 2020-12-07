package taxmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateTaxmaster extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String taxmasterID;
	public String srNo;
	public String taxName;
	public String percentage;
	public String getTaxmasterID() {
		return taxmasterID;
	}
	public void setTaxmasterID(String taxmasterID) {
		this.taxmasterID = taxmasterID;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	public String ret="error";
	public String execute() {

		System.out.println("in update............"+taxmasterID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE taxmaster_table SET srNo=?, taxName=?, percentage=? WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, srNo);		
    		  pst.setString(2, taxName);
    		  pst.setString(3, percentage);
    		  pst.setString(4, taxmasterID);
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

	
	
	
	
	