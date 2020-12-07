package productsreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class UpdateProductsReport extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String SrNo;
	public String ProductName;
	public String AvailableQuantity;
	public String Unit;
	public String Packaging;
	public String PurchasePrice;
	public String PurchaseTax;
	public String SellingPrice;
	public String SellingTax;
	public String productsreportID;
	
	
	
	public String ret="error";
	public String execute() {

		System.out.println("in update............"+productsreportID);
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE productsreport_table SET SrNo=?, ProductName=?, AvailableQuantity=?, Unit=?, Packaging=?, PurchasePrice=?, PurchaseTax=?, SellingPrice=?, SellingTax=? WHERE id=?";
		
		try {
			
			PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, SrNo);		
    		  pst.setString(2, ProductName);
    		  pst.setString(3, AvailableQuantity);
    		  pst.setString(4, Unit);
    		  pst.setString(5, Packaging);
    		  pst.setString(6, PurchasePrice);
    		  pst.setString(7, PurchaseTax);
    		  pst.setString(8, SellingPrice);
    		  pst.setString(9, SellingTax);
    		  pst.setString(10, productsreportID);
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

	
	
	
	