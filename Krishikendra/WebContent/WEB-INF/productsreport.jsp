<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="generatedClass.connectionClass"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | DataTables</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  
  
   <script type="text/javascript">   
        function deleteproductsreport(val)
        {
        	var a=val;
        	//alert(a);
        	
        	$("#productsreportID_d").val(a);
        	$("#myModalDelete").modal();
        }
        
             
   </script>
  
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="index" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

  <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="./index" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
               
              </p>
            </a>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Master
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
             <li class="nav-item">
                <a href="expense" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Company Master</p>
                </a>
              </li>
                          <li class="nav-item">
                <a href="stock" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Products</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="expense" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Expense</p>
                </a>
              </li>
         </li>
         </ul>
         
           <li class="nav-item">
            <a href="sale" class="nav-link">
              <i class="nav-icon fas fa-shopping-cart"></i>
              <p>
                Sales
              </p>
            </a>
            
             <li class="nav-item">
            <a href="unit" class="nav-link">
              <i class="nav-icon fas fa-balance-scale"></i>
              <p>
                Unit Master
              </p>
            </a>
            
             
             <li class="nav-item">
            <a href="taxmaster" class="nav-link">
              <i class="nav-icon fas fa-percent"></i>
              <p>
                Tax
              </p>
            </a>
            
         
        <li class="nav-item">
            <a href="registration" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Registered Customer
              </p>
            </a>
            
            
            
            
             <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Employee
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
            
                 <li class="nav-item">
            <a href="empdetails" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Employee Details
              </p>
            </a>
             <li class="nav-item">
            <a href="empattendance" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Employee Attendance
              </p>
            </a>
         </ul>
         
         
         
         <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Reports
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
            
                 <li class="nav-item">
            <a href="salereport" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Sale Report
              </p>
            </a>
             <li class="nav-item">
            <a href="productsreport" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Stock Report
              </p>
            </a>
             <li class="nav-item">
            <a href="expensereport" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Expense Report
              </p>
            </a>
             <li class="nav-item">
            <a href="empreport" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Employee Report
              </p>
            </a>
             <li class="nav-item">
            <a href="empatdreport" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Attendance Report
              </p>
            </a>
            </ul>
                
          <li class="nav nav-treeview">
              <li class="nav-item">
                <a href="pages/examples/lockscreen.html" class="nav-link">
          <i class="fas fa-sign-out-alt nav-icon"></i>
                  <p>Log Out</p>
                </a>
              </li>
            </li>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Products Availability</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href=index.html>Home</a></li>
              <li class="breadcrumb-item active">Products Availability</li>
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
                <h3 class="card-title">Products Availability</h3>
                 <div class="card-tools">
                   <button type="button" id="addNewButton" class="btn btn-success">Add New</button>
                            <button type="button" id="showTableButton" class="btn btn-success">Show Table</button>
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

   <form role="form" action="productsreportInsert">

                  <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Sr No</label>
                        <input class="form-control" type="text" name="SrNo">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Product Name</label>
                          <input class="form-control" type="text" name="ProductName">
                      </div>
                    </div>
                  </div>
                  
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Available Quantity</label>
                          <input class="form-control" type="text" name="AvailableQuantity">
                        </div>
                    </div>
                    
                 <div class="col-sm-6">
                      <div class="form-group">
                        <label>Unit</label>
                          <input class="form-control" type="text" name="unit">
                        </div>
                    </div>
                   </div>
                   
                    <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Packaging</label>
                          <input class="form-control" type="text" name="packaging">
                        </div>
                    </div>
                   
                   
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Purchase Price</label>
                          <input class="form-control" type="text" name="PurchasePrice">
                        </div>
                    </div>
                   </div>
                   
                    <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Purchase Tax</label>
                          <input class="form-control" type="text" name="PurchaseTax">
                        </div>
                    </div>
                                    
                   <div class="col-sm-6">
                      <div class="form-group">
                        <label>Selling Price</label>
                          <input class="form-control" type="text" name="SellingPrice">
                        </div>
                    </div>
                   </div>
                   
                   <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Selling Tax</label>
                          <input class="form-control" type="text" name="SellingTax">
                        </div>
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
                                            
                            
                            
                            
                                            
   <!-- for update  -->
                          <div class="row" id="addNewForm1">
                 <form role="form" action="productsreportUpdate" method="post">
                 
                 <%
                 try{
                                Connection con1=new connectionClass().getConnection();
                        		Statement stm=con1.createStatement();
                        		String sql="select * from productsreport_table where id= '"+id1+ "'";
                        		ResultSet rs=stm.executeQuery(sql);
                        		while(rs.next()){
                        			
                 %>
                 
                    <div class="col-lg-12"> 
             
             <%-- <%System.out.println(id1); %> --%>
                    <input type="hidden" value="<%=id1%>" name="productsreportID">
                    
                    
                    <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Sr No</label>
                        <input class="form-control" type="text" name="SrNo" value="<%=rs.getString("SrNo") %>">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Product Name</label>
                          <input class="form-control" type="text" name="ProductName" value="<%=rs.getString("ProductName") %>">
                      </div>
                    </div>
                    </div>
                    
               
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Available Quanity</label>
                          <input class="form-control" type="text" name="AvailableQuantity" value="<%=rs.getString("AvailableQuantity") %>">
                        </div>
                    </div>
		          <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Unit<label>
                          <input class="form-control" type="text" name="Unit" value="<%=rs.getString("Unit") %>">
                        </div>
                    </div>
                    </div>
				
					
					<div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Packaging</label>
                          <input class="form-control" type="text" name="Packaging" value="<%=rs.getString("Packaging") %>">
                        </div>
                    </div>
					
					
					
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Purchase Price</label>
                          <input class="form-control" type="text" name="PurchasePrice" value="<%=rs.getString("PurchasePrice") %>">
                        </div>
                    </div>
                    </div>
					
					
					<div class="row">
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Purchase Tax</label>
                          <input class="form-control" type="text" name="PurchaseTax" value="<%=rs.getString("PurchaseTax") %>">
                        </div>
                    </div>
					
					
					
                    <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Selling Price</label>
                          <input class="form-control" type="text" name="SellingPrice" value="<%=rs.getString("SellingPrice") %>">
                        </div>
                    </div>
                    </div>
					
					
				<div class="row">
				   <div class="col-sm-6">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Selling Tax</label>
                          <input class="form-control" type="text" name="SellingTax" value="<%=rs.getString("SellingTax") %>">
                        </div>
                    </div>
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
                    <th>Product Name</th>
                    <th>Available Quantity</th>
                    <th>Unit</th>
                    <th>Packaging</th>
                    <th>Purchase Price</th>
                    <th>Purchase Tax</th>
                    <th>Selling Price</th>
                    <th>Selling Tax</th>
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
                                    	String sql = "select * from productsreport_table";
                                    	ResultSet rs= smt.executeQuery(sql);
                                    	while(rs .next()){                                  		
                                    	               
                                    %>
                                        <tr >
                                        	
                                            <td><%=i%><input type="hidden" id="id" value="<%rs.getString("id");%>"> </td> 
                                                                                    
                                        <%--<td id="SrNo_<%rs.getString("id");%>"><%=rs.getString("SrNo") %></td> --%>
                                            <td id="ProductName_<%rs.getString("id");%>"><%=rs.getString("ProductName") %></td>
                                            <td id="AvailableQuantity_<%rs.getString("id");%>"><%=rs.getString("AvailableQuantity") %></td>
                                            <td id="Unit_<%rs.getString("id");%>"><%=rs.getString("Unit") %></td>
                                            <td id="Packaging_<%rs.getString("id");%>"><%=rs.getString("Packaging") %></td>
                                            <td id="PurchasePrice_<%rs.getString("id");%>"><%=rs.getString("PurchasePrice") %></td>
                                            <td id="PurchaseTax_<%rs.getString("id");%>"><%=rs.getString("PurchaseTax") %></td>
                                            <td id="SellingPrice_<%rs.getString("id");%>"><%=rs.getString("SellingPrice") %></td>
                                            <td id="SellingTax_<%rs.getString("id");%>"><%=rs.getString("SellingTax") %></td>
                                            <td>
								
								   <a href="productsreport?id=<%=rs.getString("id")%>" class="btn btn-success">Update</a>  
                            			
					
							</td>
                                            <td>
                                             
                            					<a  onclick="

productsreport(<%=rs.getString("id")%>)" class="btn btn-success text-white">Delete</a>
											
                                            </td>
                                           
                                            
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
                 			   <th>Sr No</th>
                    			<th>Product Name</th>
                    			<th>Available Quantity</th>
                    			<th>Unit</th>
                    			<th>Packaging</th>
                    			<th>Purchase Price</th>
                   				<th>Purchase Tax</th>
                    			<th>Selling Price</th>
                    			<th>Selling Tax</th>
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
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.1.0-pre
    </div>
    <strong>Copyright &copy; 2014-2020 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->



  		 <!-- Delete Modal -->
		  <div class="modal fade" id="myModalDelete" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title" style="text-align: center">Do You Want To Delete ?</h4>
		        </div>
		        <form action="productsreportDelete" method="POST">
		        <div class="modal-body">
		          
		          	<input type="text" id="productsreportID_d" name="productsreportID">
		          	
				    <div class="form-group">
				      <label>Do You Want To Delete ?</label>
				     
				    </div>
				  
				  
		        </div>
		        <div class="modal-footer">
		          <button type="submit" class="btn btn-success dlb mbtn text-white" tabindex="21";">Delete</button>
		          <button type="button" class="btn btn-success clb mbtn text-white" data-dismiss="modal" tabindex="22";">Close</button>
		        </div>
		        </form>
		      </div>
		      
		    </div>
		  </div>



<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });

   $(document).ready(function(){
                                                                        $("#addNewButton").show();
                                                                        $("#showTable").show();
                                                                        $("#addNewForm").hide();
                                                                        $("#showTableButton").hide();


                                                                        $("#addNewButton").click(function(){
                                                                            $("#addNewButton").hide();  
                                                                            $("#showTable").hide();
                                                                            $("#addNewForm").show();
                                                                            $("#showTableButton").show();
                                                                        });
                                                                        $("#showTableButton").click(function(){
                                                                            $("#addNewButton").show();  
                                                                            $("#showTable").show();
                                                                            $("#addNewForm").hide();
                                                                            $("#showTableButton").hide();
                                                                        });
                                                                    });
</script>
</body>
</html>
    