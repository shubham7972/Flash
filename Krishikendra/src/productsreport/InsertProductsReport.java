package productsreport;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class InsertProductsReport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String SrNo;	
	private String ProductName;
	private String AvailableQuantity;
	private String Unit;
	private String Packaging;
	private String PurchasePrice;
	private String PurchaseTax;
	private String SellingPrice;
	private String SellingTax;
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
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getPackaging() {
		return Packaging;
	}
	public void setPackaging(String packaging) {
		Packaging = packaging;
	}
	public String getPurchasePrice() {
		return PurchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		PurchasePrice = purchasePrice;
	}
	public String getPurchaseTax() {
		return PurchaseTax;
	}
	public void setPurchaseTax(String purchaseTax) {
		PurchaseTax = purchaseTax;
	}
	public String getSellingPrice() {
		return SellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		SellingPrice = sellingPrice;
	}
	public String getSellingTax() {
		return SellingTax;
	}
	public void setSellingTax(String sellingTax) {
		SellingTax = sellingTax;
	}
	
	public String ret="error";
	public String execute() {
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession();
		
		// new connectionClass();
		// Connection con1 = connectionClass.getConnection();
		Connection con1=new  connectionClass().getConnection();
		
		String query = "INSERT INTO productsreport_table (SrNo, ProductName, AvailableQuantity, Unit, Packaging, PurchasePrice, PurchaseTax, SellingPrice, SellingTax) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?)";
		try  {
  			
	        		  PreparedStatement pst = con1.prepareStatement(query);
	        		  pst.setString(1, SrNo);
	        		  pst.setString(2, ProductName);
	        		  pst.setString(3, AvailableQuantity);
	        		  pst.setString(4, Unit);
	        		  pst.setString(5, Packaging);
	        		  pst.setString(6, PurchasePrice);
	        		  pst.setString(7, PurchaseTax);
	        		  pst.setString(8, SellingPrice);
	        		  pst.setString(9, SellingTax);
	        		  
	      		

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


	
	
	