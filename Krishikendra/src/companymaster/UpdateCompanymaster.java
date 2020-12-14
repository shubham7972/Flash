package companymaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateCompanymaster extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String cmasterID;
	public String companyname;	
	public String companyaddress;
	public String country;
	public String emailid;
	public String registrationno;
	public String gstno;
	public String contactno1;
	public String contactno2;
	public String state;
	public String city;
	public String postalcode;
	public String companywebsite;
	public String bankname;
	public String accountno;
	public String getCmasterID() {
		return cmasterID;
	}
	public void setCmasterID(String cmasterID) {
		this.cmasterID = cmasterID;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getRegistrationno() {
		return registrationno;
	}
	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}
	public String getGstno() {
		return gstno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	public String getContactno1() {
		return contactno1;
	}
	public void setContactno1(String contactno1) {
		this.contactno1 = contactno1;
	}
	public String getContactno2() {
		return contactno2;
	}
	public void setContactno2(String contactno2) {
		this.contactno2 = contactno2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCompanywebsite() {
		return companywebsite;
	}
	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	
	
	public String ret="error";
	public String execute() {

		System.out.println("in update............"+cmasterID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE cmaster_table SET companyname=?, companyaddress=?, country=?, emailid=?, registrationno=?, gstno=?, contactno1=?, contactno2=?, state=?, city=?, postalcode=?, companywebsite=?, bankname=?, accountno=?  WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, companyname);		
    		  pst.setString(2, companyaddress);
    		  pst.setString(3, country);
    		  pst.setString(4, emailid);
    		  pst.setString(5, registrationno);
    		  pst.setString(6, gstno);
    		  pst.setString(7, contactno1);
    		  pst.setString(8, contactno2);
    		  pst.setString(9, state);
    		  pst.setString(10, city);
    		  pst.setString(11, postalcode);
    		  pst.setString(12, companywebsite);
    		  pst.setString(13, bankname);
    		  pst.setString(14, accountno);
    		  pst.setString(15, cmasterID);
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

	
	