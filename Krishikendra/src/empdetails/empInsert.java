package empdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class empInsert extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String firstName;	
	private String MiddleName;
	private String lastName;
	private String mobileNo;
	private String designation;
	private String salary;
	private String localAddress;
	private String PermanentAddress;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	private String permanentAddress;

	public String ret="error";
	public String execute() {
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession();
		
		// new connectionClass();
		// Connection con1 = connectionClass.getConnection();
		Connection con1=new  connectionClass().getConnection();
		
		String query = "INSERT INTO emp_table (firstName, MiddleName, lastName, mobileNo, designation, salary, localAddress, PermanentAddress) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try  {
  			
	        		  PreparedStatement pst = con1.prepareStatement(query);
	        		  pst.setString(1, firstName);
	        		  pst.setString(2, MiddleName);
	        		  pst.setString(3, lastName);
	        		  pst.setString(4, mobileNo);
	        		  pst.setString(5, designation);
	        		  pst.setString(6, salary);
	        		  pst.setString(7, localAddress);
	        		  pst.setString(8, PermanentAddress);
	        		  
	      		

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