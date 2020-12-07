package stockreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateStockReport extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String stockID;
	public String srNo;
	public String productName;
	public String availableQuantity;
	public String unit;
	public String packaging;
	public String purchasePrice;
	public String purchaseTax;
	public String sellingPrice;
	public String sellingTax;
	
	
		
	public String getStockID() {
		return stockID;
	}
	public void setStockID(String stockID) {
		this.stockID = stockID;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchaseTax() {
		return purchaseTax;
	}
	public void setPurchaseTax(String purchaseTax) {
		this.purchaseTax = purchaseTax;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getSellingTax() {
		return sellingTax;
	}
	public void setSellingTax(String sellingTax) {
		this.sellingTax = sellingTax;
	}
	public String ret="error";
	public String execute() {

				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE stock_report SET srNo=?, productName=?, availableQuantity=?, unit=?, packaging=?, purchasePrice=?, purchaseTax=?, sellingPrice=?, sellingTax=?  WHERE id=?";
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, srNo);		
    		  pst.setString(2, productName);
    		  pst.setString(3, availableQuantity);
    		  pst.setString(4, unit);
    		  pst.setString(5, packaging);
    		  pst.setString(6, purchasePrice);
    		  pst.setString(7, purchaseTax);
    		  pst.setString(8, sellingPrice);
    		  pst.setString(9, sellingTax);
    		  pst.setString(10, stockID);
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

