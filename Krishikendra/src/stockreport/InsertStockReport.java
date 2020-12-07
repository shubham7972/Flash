package stockreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import generatedClass.connectionClass;

public class InsertStockReport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String SrNo;	
	private String ProductName;
	private String AvailableQuantity;
	
	
	
	public String getSrNo() {
		return SrNo;
	}
	public void setSrNo(String srNo) {
		SrNo = srNo;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getAvailableQuantity() {
		return AvailableQuantity;
	}
	public void setAvailableQuantity(String availableQuantity) {
		AvailableQuantity = availableQuantity;
	}
	//private String AvailableQuantity;
	
public String ret="error";
public String execute() {
	
System.out.println("in iser"+AvailableQuantity);
	HttpServletRequest request=ServletActionContext.getRequest();
	request.getSession();
	
	// new connectionClass();
	// Connection con1 = connectionClass.getConnection();
	Connection con1=new  connectionClass().getConnection();
	
	String query = "INSERT INTO stock_report (SrNo, ProductName, AvailableQuantity) VALUES(?, ?, ?)";
	try  {
			
        		  PreparedStatement pst = con1.prepareStatement(query);
        		  pst.setString(1, SrNo);
        		  pst.setString(2, ProductName);
        		  pst.setString(3, AvailableQuantity);
        		        		

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


