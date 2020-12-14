package companymaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class DeleteCompanymaster extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String cmasterID;

	public String getCmasterID() {
		return cmasterID;
	}

	public void setCmasterID(String cmasterID) {
		this.cmasterID = cmasterID;
	}
	
	public String ret="error";
	public String execute() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		String query="delete from cmaster_table where id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, cmasterID);
			pst.executeUpdate();
			
			
			request.getSession().setAttribute("successmsg", "Data Deleted");
			ret="success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret="error";
		}
		
		return ret;
	}
	
	

	
}
