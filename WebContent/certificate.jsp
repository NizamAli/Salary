<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SALARY CERTIFICATE</title>

<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">

<link href="css/bootstrap-datepicker.css" rel="stylesheet">
<link href="css/themes.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="js/jquery-ui.min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/certificate.js"></script>


</head>
<body>
	<div class="container">
		<div class="panel panel-default">
    		<div class="panel-heading text-center">SALARY CERTIFICATE</div>
    		<div class="panel-body">
    			<div class="col-md-12">
    				<div class="col-md-9">
    					<form>
							<br/>
							<div class="form-group row">
							
								<div class="col-md-3"><label for="empName" class="col-form-label">NAME OF THE EMPLOYEE</label></div>
				  				<div class="col-md-4"><input type="text" class="form-control" id="empName"
										placeholder="NAME OF THE EMPLOYEE"></div>
							</div>
							<div class="form-group row">
								<div class="col-md-3"><label for="empName" class="col-form-label">LOCATION</label></div>
				  				<div class="col-md-3">
				  					<select class="locationPicker">
									  <option id="1">RURAL</option>
									  <option id="2">URBAN</option>
									  <option id="3">METROPOLITAN</option>
									</select>
				  				</div>
				  				<div class="col-md-2">
				  					
				  				</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3"><label for="CADRE" class="col-form-label">CADRE</label></div>
								<div class="col-sm-3"><input type="text" class="form-control" id="cadre"
										placeholder="CADRE">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3"><label for="OFFICE NAME" class="col-form-label">OFFICE NAME</label></div>
								<div class="col-sm-3">    <textarea class="form-control" id="office" placeholder="OFFICE NAME"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3"><label for="PURPOSE OF CERTIFICATE" class="col-form-label">PURPOSE OF CERTIFICATE</label></div>
								<div class="col-sm-2">  
									<select class="purposePicker">
									  <option>LOAN</option>
									  <option>SURETY</option>
									  <option>OTHERS</option>
									</select>
									  
								</div>
							</div>
							
							<ul class="nav nav-tabs">
							    <li class="active"><a data-toggle="tab" href="#salary">SALARY</a></li>
							    <li><a data-toggle="tab" href="#deductions">DEDUCTIONS</a></li>
							    
							  </ul>
							
							  <div class="tab-content">
							    <div id="salary" class="tab-pane fade in active">
							    
								     <div class="form-group row">
								     	<br/>
										<div class="col-md-3"><label for="PAY" class="col-form-label">PAY</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" id="pay" placeholder="PAY">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="DA" class="col-form-label">DA PERCENT</label></div>
										<div class="col-sm-2">   <input type="number" class="form-control" step="any" id="daPercent"  placeholder="DA PERCENT">
											
										</div>
										<div class="col-sm-1" class="divDA"><label for="DA" class="col-form-label">DA</label></div>
										<div class="col-sm-2" class="divDA"><input type="number" step="any" class="form-control add" disabled="disabled" id="spnDa" placeholder="HRA"></div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="HRA" class="col-form-label">HRA</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" disabled="disabled" id="hra" placeholder="HRA">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="HM ALLOWANCE" class="col-form-label">HM ALLOWANCE</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" id="hmAllowance" >
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="CC ALLOWANCE" class="col-form-label">CC ALLOWANCE</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" id="ccAllowance" >
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="IF ANY" class="col-form-label">IF ANY</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" id="ifAny" placeholder="IF ANY">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="IF ANY" class="col-form-label">IR</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control add" id="ir" placeholder="IR">
										</div>
									</div>
							      
							    </div>
							    <div id="deductions" class="tab-pane fade">
							      
							      <div class="form-group row">
								     	<br/>
										<div class="col-md-3"><label for="PF" class="col-form-label">PF</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="pf" placeholder="PF">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="PFLOAN" class="col-form-label">PF LOAN</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="pfLoan" placeholder="PF LOAN">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="APGLI" class="col-form-label">APGLI</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="apgli" placeholder="APGLI">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="APGLI LOAN" class="col-form-label">APGLI LOAN</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="apgliLoan" placeholder="APGLI LOAN">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="LIC" class="col-form-label">GIS</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="gis" placeholder="GIS">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="P TAX" class="col-form-label">P TAX</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="pTax" placeholder="P TAX">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="EHS" class="col-form-label">EHS</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="ehs" placeholder="EHS">
										</div>
									</div>
									
									
									<div class="form-group row">
										<div class="col-md-3"><label for="LIC" class="col-form-label">LIC</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="lic" placeholder="LIC">
										</div>
									</div>
									
									
							      
							      	<div class="form-group row">
										<div class="col-md-3"><label for="IT" class="col-form-label">IT</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="it" placeholder="IT">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="SWF/EWF" class="col-form-label">SWF/EWF</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="swfEwf" placeholder="SWF/EWF">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="RELIEF FUND" class="col-form-label">RELIEF FUND</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="relieffund" placeholder="RELIEF FUND">
										</div>
									</div>
									
									<div class="form-group row">
										<div class="col-md-3"><label for="IF ANY " class="col-form-label">IF ANY</label></div>
										<div class="col-sm-2">   <input type="number" step="any" class="form-control sub" id="ifAnyDeductions" placeholder="IF ANY">
										</div>
									</div>
									
							    </div>
							    
							  </div>
							  <br>
							  
							  <div class="form-group row">
								<div class="col-md-3"><label for="TOTAL" class="col-form-label">NET PAY (GROSS-DEDUCTIONS)</label></div>
								<div class="col-sm-2">    
									<input type="number" step="any" id="netPay" class="form-control" placeholder="NET PAY"  disabled="disabled"> 
								</div>
							</div>
							
							  <div class="form-group row">
								<div class="col-md-3"><label for="DATE OF SUBMISSION" class="col-form-label">APPOINTMENT DATE</label></div>
								<div class="col-sm-1">    
									<input type="text" id="dos" class="span2 datepicker" placeholder="DATE OF APPOINTMENT"  > 
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-3"><label for="DATE OF SUBMISSION" class="col-form-label">DATE OF BIRTH</label></div>
								<div class="col-sm-2">    
									<input type="text" id="dob" class="span2 datepicker" placeholder="DATE OF BIRTH"  > 
		
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-3"><label for="DATE OF SUBMISSION" class="col-form-label">DATE OF RETIREMENT</label></div>
								<div class="col-sm-2">  
								<span id="dor"></span> 
		
								</div>
							</div>
							
							  <div class="form-group row">
								<div class="offset-sm-2 col-sm-10">
									<button  id="print" class="btn btn-primary">PRINT</button>
								</div>
							</div>
							
							
							
							
						</form>
    				</div>
    				<div class="col-md-2">
    					<img alt="" src="images/Ajijulla.jpg" style="width:250px;height:200px;">
    					<br/>
    					<label for="DATE OF SUBMISSION" class="col-form-label">SHAIK AZEEZUR RAHMAN M.A (Eng) B.Ed</label>
    					<br>
    					<label for="DATE OF SUBMISSION" class="col-form-label">PRESIDENT, STU AP RAYACHOTY</label>
    				</div>
    			</div>
    			
    		</div>
		  </div>
		
	</div>
</body>
</html>