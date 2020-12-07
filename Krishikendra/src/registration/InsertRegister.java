package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import generatedClass.connectionClass;


public class InsertRegister extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
	private String SrNo;	
	private String FullName;
	private String DateOfBirth;
	private String MobileNo;
	private String City;
	private String Farm;
	public String getSrNo() {
		return SrNo;
	}
	public void setSrNo(String srNo) {
		SrNo = srNo;
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



//private String AvailableQuantity;
	
public String ret="error";
public String execute() {
	
// System.out.println("in iser"+AvailableQuantity);
	HttpServletRequest request=ServletActionContext.getRequest();
	request.getSession();
	
	// new connectionClass();
	// Connection con1 = connectionClass.getConnection();
	Connection con1=new  connectionClass().getConnection();
	
	String query = "INSERT INTO register_table (SrNo, FullName, DateOfBirth, MobileNo, City, Farm) VALUES(?, ?, ?, ?, ?, ?)";
	try  {
			
        		  PreparedStatement pst = con1.prepareStatement(query);
        		  pst.setString(1, SrNo);
        		  pst.setString(2, FullName);
        		  pst.setString(3, DateOfBirth);
        		  pst.setString(4, MobileNo);
        		  pst.setString(5, City);
        		  pst.setString(6, Farm);
        		        		

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


