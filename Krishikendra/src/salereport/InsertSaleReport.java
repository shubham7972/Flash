package salereport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import generatedClass.connectionClass;

public class InsertSaleReport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String billDate;	
	private String billNumber;
	private String productName;
	private String packaging;
	private String quantity;
	private String rate;
	private String unit;
	private String discount;
	
	
	
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String ret="error";
	public String execute() {
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession();
		
		// new connectionClass();
		// Connection con1 = connectionClass.getConnection();
		Connection con1=new  connectionClass().getConnection();
		
		String query = "INSERT INTO sale_report (billDate, billNumber, productName, packaging, quantity, rate, unit, discount) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try  {
  			
	        		  PreparedStatement pst = con1.prepareStatement(query);
	        		  pst.setString(1, billDate);
	        		  pst.setString(2, billNumber);
	        		  pst.setString(3, productName);
	        		  pst.setString(4, packaging);
	        		  pst.setString(5, quantity);
	        		  pst.setString(6, rate);
	        		  pst.setString(7, unit);
	        		  pst.setString(8, discount);
	        		  
	      		

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

