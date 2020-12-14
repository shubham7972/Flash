package companymaster;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class InsertCompanymaster extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String companyname;	
	private String companyaddress;
	private String country;
	private String emailid;
	private String registrationno;
	private String gstno;
	private String contactno1;
	private String contactno2;
	private String state;
	private String city;
	private String postalcode;
	private String companywebsite;
	private String bankname;
	private String accountno;
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
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession();
		
		// new connectionClass();
		// Connection con1 = connectionClass.getConnection();
		Connection con1=new  connectionClass().getConnection();
		
		String query = "INSERT INTO cmaster_table (companyname, companyaddress, country, emailid, registrationno, gstno, contactno1, contactno2, state, city, postalcode, companywebsite, bankname, accountno) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try  {
  			
	        		  PreparedStatement pst = con1.prepareStatement(query);
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


	

	