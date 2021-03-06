<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="generatedClass.connectionClass"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


 
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.dataTables.min.css">
 
<script type="text/javascript">   
   
        function deleteSalereport(val)
        {
        	//alert(11);
        	var a=val;
        	//alert(a);
        	
        	$("#salereportID_d").val(a);
        	$("#myModalDelete").modal();
        }
        
</head>
<body>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Sale Report</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href=index.html>Home</a></li>
              <li class="breadcrumb-item active">Sale Report</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>



    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">


            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Sale Report</h3>
                 <div class="card-tools">
                   <button type="button" id="addNewButton" class="btn btn-info">Add New</button>
                            <button type="button" id="showTableButton" class="btn btn-info">Show Table</button>
              <button type="button" class="btn btn-tool" data-card-widget="collapse">
                <i class="fas fa-minus"></i>
              </button>
              <button type="button" class="btn btn-tool" data-card-widget="remove">
                <i class="fas fa-times"></i>
              </button>
            </div>
              </div>
              <!-- /.card-header -->

              <div class="card-body">
 <!-- Start Struts Validation -->
			 
										 <s:if test="hasActionErrors()">
											<div class="errorDiv">
												<div class="alert alert-error has-error" role="alert">
													<s:actionerror/>
												</div>
											</div>
										</s:if>
										
										<%if(request.getSession().getAttribute("successmsg")!=null){ %>
										<div class="welcome">
										  <div class="alert alert-success has-success" role="alert">
										 <%=request.getSession().getAttribute("successmsg")%>
										  </div>
										  </div>
										<%request.getSession().removeAttribute("successmsg"); } %>
										
										<!-- End Struts Validation -->
               <div id="addNewForm">

  <form role="form" action="saleInsert">

                  <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Bill Date</label>
                        <input class="form-control" type="date" name="billDate">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Bill Number</label>
                          <input class="form-control" type="number" name="billNumber">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Product Name</label>
                          <input class="form-control" type="text" name="productName">
                        </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Packaging</label>
                          <select class="form-control" name="packaging" >
                              <option value="0">Select Packaging Type</option>
                              <option>A</option>
                              <option>B</option>
                              <option>C</option>
                              <option>D</option>
                          </select>
                        </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Quantity</label>
                          <input class="form-control" type="number" name="quantity" required>
                        </div>
                    </div>
                     <div class="col-sm-6">
                      <div class="form-group">
                        <label>Rate</label>
                        <input class="form-control" type="text"  name="rate"></div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Unit</label>
                        <input class="form-control" type="number"  name="unit">
                    </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Discount</label>
                        <input class="form-control" type="text"  name="discount"></div>
                    </div>
                  </div>
                   <div class="col-md-12"  style="text-align: center;" >
                                                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                                            </div>
                                            </form>
                </div>
                </div>
               
            
    
                <div class="card-body">
                
                     <%
                                            String id1=request.getParameter("id");
                                            if(id1!=null){
                                            %>
                                            
                                           < 
   <!-- for update  --> 
                          <div class="row" id="addNewForm1">
                 <form role="form" action="saleUpdate" method="post">
                 
                 <%
                 try{
                                Connection con1=new connectionClass().getConnection();
                        		Statement stm=con1.createStatement();
                        		String sql="select * from sale_report where id= '"+id1+ "'";
                        		ResultSet rs=stm.executeQuery(sql);
                        		while(rs.next()){
                        			
                 %>
                 
               
             
           <%System.out.println(id1); %>
                    <input type="text" value="<%=id1%>" name="salereportID">
                    </div>
                    
                      <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Bill Date</label>
                        <input class="form-control" type="date" name="billDate" value="<%=rs.getString("billDate") %>">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Bill Number</label>
                          <input class="form-control" type="text" name="billNumber" value="<%=rs.getString("billNumber") %>">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Product Name</label>
                          <input class="form-control" type="text" name="productName" value="<%=rs.getString("productName") %>">
                        </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Packaging</label>
                          <select class="form-control" name="packaging" >
                              <option ><%=rs.getString("packaging") %></option>
                              <option>A</option>
                              <option>B</option>
                              <option>C</option>
                              <option>D</option>
                          </select>
                        </div>
                    </div>
                  </div>
           
                  <div class="row">
                    <div class="col-sm-6">
                     <div class="form-group">
                        <label>Quantity</label>
                          <input class="form-control" type="number" name="quantity" value="<%=rs.getString("quantity") %>">
                        </div>
                    </div>
                     <div class="col-sm-6">
                      <div class="form-group">
                        <label>Rate</label>
                        <input class="form-control" type="text"  name="rate" value="<%=rs.getString("rate") %>"></div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Unit</label>
                        <input class="form-control" type="number"  name="unit" value="<%=rs.getString("unit") %>">
                    </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Discount</label>
                        <input class="form-control" type="text"  name="discount" value="<%=rs.getString("discount") %>"></div>
                    </div>
                  </div>
                   <div class="col-md-12"  style="text-align: center;" >
                    <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                    </div>
                         
                    
                          
                           
                           <%
                           		} // end of while
                           			
                           			rs.close();
                           		    stm.close();
                           		    con1.close();
                 }catch(Exception e){
                	 e.printStackTrace();
                 }
                              
                           %>
                         </form>
                         </div>
                                 
                                 
                          <% 
                                            }  // end of if
                          %>       
                                 </div>
                                 
                
                
                 
            

            
            <div class="card">
                 <div id="showTable">
                 
                  <!-- Start Struts Validation -->
			 
										 <s:if test="hasActionErrors()">
											<div class="errorDiv">
												<div class="alert alert-error has-error" role="alert">
													<s:actionerror/>
												</div>
											</div>
										</s:if>
										
										<%if(request.getSession().getAttribute("successmsg")!=null){ %>
										<div class="welcome">
										  <div class="alert alert-success has-success" role="alert">
										 <%=request.getSession().getAttribute("successmsg")%>
										  </div>
										  </div>
										<%request.getSession().removeAttribute("successmsg"); } %>
										
										<!-- End Struts Validation -->
             
              <div class="card-body">

                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                  				<th>Sr no</th>
                   			    <th>Bill Date</th>
                                <th>Bill Number</th>
                                <th>Product Name</th>
                                <th>Packaging</th>
                                <th>Quantity</th>
                                <th>Rate</th>
                                <th>Unit</th>
                                <th>Discount</th>
                                <th>Edit</th>
                                <th>Delete</th>        
                  </tr>
                  </thead>
                 <tbody>
                                    <%
                                    int i=1;
                                    try{
                                   Connection con=new connectionClass().getConnection();
                                   Statement smt=con.createStatement();
                                    	String sql = "select * from sale_report";
                                    	ResultSet rs= smt.executeQuery(sql);
                                    	while(rs .next()){                                  		
                                    	               
                                    %>
                                        <tr >
                                        	
                                            <td><%=i%><input type="hidden" id="id" value="<%rs.getString("id");%>"> </td> 
                                                                                    
                                            <td id="billDate_<%rs.getString("id");%>"><%=rs.getString("billDate") %></td>
                                            <td id="billNumber_<%rs.getString("id");%>"><%=rs.getString("billNumber") %></td>
                                            <td id="productName_<%rs.getString("id");%>"><%=rs.getString("productName") %></td>
                                            <td id="packaging_<%rs.getString("id");%>"><%=rs.getString("packaging") %></td>
                                            <td id="quantity_<%rs.getString("id");%>"><%=rs.getString("quantity") %></td>
                                            <td id="rate_<%rs.getString("id");%>"><%=rs.getString("rate") %></td>
                                            <td id="unit_<%rs.getString("id");%>"><%=rs.getString("unit") %></td>
                                            <td id="discount_<%rs.getString("id");%>"><%=rs.getString("discount") %></td>
                                             
                                          
                                            
                                        </tr>
                                                                               
                                            <%
                                            i++;
                                    	    }  //end of while
                                    	    	
                                    	    	rs.close();
                                    	        smt.close();
                                    	        con.close();
                                    	        
                                       } catch(Exception e){
                                            e.printStackTrace();
                                            
                                            }
                                            %>
                                        </tbody>
						
                  <tfoot>
                  <tr>
                  				<th>Sr no</th>
                    			<th>Bill Date</th>
                                <th>Bill Number</th>
                                <th>Product Name</th>
                                <th>Packaging</th>
                                <th>Quantity</th>
                                <th>Rate</th>
                                <th>Unit</th>
                                <th>Discount</th>
                                <th>Edit</th>
                                <th>Delete</th>        
                    </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
   <script type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.print.min.js"></script>
  
  <script>
 <!--  <script type="text/javascript"> -->
$(document).ready(function() {
	    $('#example1').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'copy', 'csv', 'excel', 'pdf', 'print'
	        ]
	    } );
	} );
</script>
</body>
</html>