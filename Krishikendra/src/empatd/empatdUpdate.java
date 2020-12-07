package empatd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedClass.connectionClass;

public class empatdUpdate extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	public String empatdID;
	private String employeeName;	
	private String date;
	private String attendance;
	private String inTime;
	private String outTime;
	private String overtime;
	public String getEmpatdID() {
		return empatdID;
	}
	public void setEmpatdID(String empatdID) {
		this.empatdID = empatdID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	
	public String ret="error";
	public String execute() {

		
				
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionClass();
		Connection con=connectionClass.getConnection();
		
		String query = "UPDATE empatd_table SET employeeName=?, date=?, attendance=?, inTime=?, outTime=?, overtime=?  WHERE id=?";
		
		try {
			
		  PreparedStatement pst=con.prepareStatement(query);
		  pst.setString(1, employeeName);
  		  pst.setString(2, date);
  		  pst.setString(3, attendance);
  		  pst.setString(4, inTime);
  		  pst.setString(5, outTime);
  		  pst.setString(6, overtime);
   		  pst.setString(7, empatdID);
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



	
	
	