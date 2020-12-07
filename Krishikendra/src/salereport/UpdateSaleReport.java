package salereport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateSaleReport extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String salereportID;
	public String billDate;
	public String billNumber;
	public String productName;
	public String packaging;
	public String quantity;
	public String rate;
	public String unit;
	public String discount;

		
	public String getSalereportID() {
		return salereportID;
	}
	public void setSalereportID(String salereportID) {
		this.salereportID = salereportID;
	}
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

		System.out.println("in update............"+salereportID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE sale_report SET billDate=?, billNumber=?, productName=?, packaging=?, quantity=?, rate=?, unit=?, discount=?  WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, billDate);		
    		  pst.setString(2, billNumber);
    		  pst.setString(3, productName);
    		  pst.setString(4, packaging);
    		  pst.setString(5, quantity);
    		  pst.setString(6, rate);
    		  pst.setString(7, unit);
    		  pst.setString(8, discount);
    		  pst.setString(9, salereportID);
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
