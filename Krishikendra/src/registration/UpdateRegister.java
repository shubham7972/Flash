package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;


public class UpdateRegister extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
	public String regID;
	public String srNo;
	public String FullName;
	public String DateOfBirth;
	public String MobileNo;
	public String City;
	public String Farm;
	
	public String getRegID() {
		return regID;
	}
	public void setRegID(String regID) {
		this.regID = regID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getFarm() {
		return Farm;
	}
	public void setFarm(String farm) {
		Farm = farm;
	}
	

	

	public String ret="error";
	public String execute() {

				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE register_table SET SrNo=?, FullName=?, DateOfBirth=?, MobileNo=?, City=?, Farm=? WHERE id=?";
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, srNo);		
    		  pst.setString(2, FullName);
    		  pst.setString(3, DateOfBirth);
    		  pst.setString(4, MobileNo);
    		  pst.setString(5, City);
    		  pst.setString(6, Farm);
    		  pst.setString(7, regID);
    	
    		  pst.executeUpdate();
			

   
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

