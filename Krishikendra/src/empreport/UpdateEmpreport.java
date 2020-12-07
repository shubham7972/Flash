package empreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateEmpreport extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String emprepID;
	public String firstName;
	public String MiddleName;
	public String lastName;
	public String mobileNo;
	public String designation;
	public String salary;
	public String localAddress;
	public String PermanentAddress;
	
	
	
	public String getEmprepID() {
		return emprepID;
	}
	public void setEmprepID(String emprepID) {
		this.emprepID = emprepID;
	}
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
		return PermanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}
	
	public String ret="error";
	public String execute() {

		System.out.println("in update............"+emprepID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE empreport_table SET firstName=?, MiddleName=?, lastName=?, mobileNo=?, designation=?, salary=?, localAddress=?, PermanentAddress=?  WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, firstName);		
    		  pst.setString(2, MiddleName);
    		  pst.setString(3, lastName);
    		  pst.setString(4, mobileNo);
    		  pst.setString(5, designation);
    		  pst.setString(6, salary);
    		  pst.setString(7, localAddress);
    		  pst.setString(8, PermanentAddress);
    		  pst.setString(9, emprepID);
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



	
	