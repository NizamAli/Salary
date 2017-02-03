$(function(){
	
	$(window).keypress(function(e) {
	    if(e.which == 13) {
	        $("#print").click();
	    }
	});
	
	$('#dos').datepicker({
	      format: 'yyyy-mm-dd',
	      endDate: '+0d',
	      autoclose: true,
	      
	});
	    
   $('#dob').datepicker({
      format: 'yyyy-mm-dd',
      endDate: '+0d',
      autoclose: true,
      
    }).on('changeDate', function (ev) {
        $('#dob').change();
    });
    
   $('.divDA').hide();
   var dob;

   $('#dob').change(function () {
	    dob = $('#dob').val();
	    setDateOfRetirement();
	});
   
   $('#daPercent').val('14.5')
   
   function calculateDA() {
	   var daPer = $('#daPercent').val();
	   var p = $('#pay').val();
	   var da = '';
	   if(p) {
		   da = (parseFloat(p) * parseFloat(daPer))/100;
	   }
	   da = Math.round(da * 100) / 100
	   $('#spnDa').val(da)
	   $('.divDA').show();
   }
   $('#daPercent').blur(function() {
	   calculateDA();
	   netPay();
   })
   
   function netPay() {
	   var sum = 0;
	   $('.add').each(function() {
	     sum += parseFloat(this.value) || 0;
	   });
	   
	   var minus = 0;
	   $('.sub').each(function() {
		     minus += parseFloat(this.value) || 0;
	   });
	   
	   $('#netPay').val(parseFloat(sum) - parseFloat(minus));
   }
   
   var hraPercent = '';
   
   function getHRAPercent(location) {
	   if(location == 1)
		    hraPercent = '12';
	   else if(location ==2)
		   hraPercent = '14.5';
	   else if(location ==3)
		   hraPercent = '20';
	   return hraPercent;
   }
   
   function calculateHRA() {
	   var location = $('.locationPicker option:selected').attr('id');
	   var per = getHRAPercent(location);
	   var p = $('#pay').val();
	   var hra = '';
	   if(p) {
		   hra = (parseFloat(p) * parseFloat(per))/100;
	   }
	   hra = Math.round(hra * 100) / 100
	   $('#hra').val(hra)
   }
   
   function calculateDetails() {
	   calculateHRA();
   }
   
   $('.locationPicker').change(function() {
	   calculateHRA();
	   netPay();
   });
   $('.add, .sub').blur(function() {
	   var i = $(this).attr("id");
	   var v =$(this).val();
	   $('#'+i).val(Math.round(v * 100) / 100);
	   calculateDetails();
	   calculateDA();
	   netPay();
   })
	 
   $('.datepicker').on('changeDate', function(ev){
	    $(this).datepicker('hide');
	});
   
   $('#dp3').datepicker();
   
   
	
	function setDateOfRetirement() {
		
		d = dob.split("-");
		var yr = d[0];
		var m = d[1];
		var d = d[2];
		var birthDate = new Date(yr,m, d);
		//console.log("DOB:"+birthDate)
		var x = 720;
		if(d == 1)
			x = 719;
		 
		var newDate = new Date();
		birthDate.setMonth(birthDate.getMonth() + x,0);
		//console.log("Retirement Date :"+birthDate)
		var d1 = birthDate.getDate();
		var m1 =  birthDate.getMonth();
		m1 += 1;  // JavaScript months are 0-11
		var y1 = birthDate.getFullYear();

		$("#dor").text(y1 + "-" + m1 + "-" + d1);
	}
	
	$('#empName').val('Nizam');
	$('.locationPicker option:selected').val('INDIA');
	$('#cadre').val('SOFTWARE');
	$('#office').val('DOHA');
	$('.purposePicker option:selected').val('IT');
	$('#pay').val('9999999');
	$('#spnDa').val('123');
	$('#hra').val('12');
	$('#hmAllowance').val('8766');
	$('#ccAllowance').val('76');
	$('#ir').val('353');
	$('#ifAny').val('3535');
	$('#pf').val('35345');
	$('#pfLoan').val('6767');
	$('#apgli').val('3536');
	$('#apgliLoan').val('79');
	$('#gis').val('33');
	$('#pTax').val('6569');
	$('#ehs').val('423');
	$('#lic').val('353');
	$('#it').val('665');
	$('#swfEwf').val('464');
	$('#relieffund').val('97');
	$('#ifAnyDeductions').val('2424');
	$('#dob').val('1987-06-22');
	$('#dos').val('2017-02-03');
	$('#dor').text('2097-06-22');
	$('#netPay').val('9876588');
	
	$('#print').click(function(){
		
		
		
		
		
		var name = $('#empName').val();
		var location = $('.locationPicker option:selected').val();
		var cadre = $('#cadre').val();
		var office = $('#office').val();
		var purpose = $('.purposePicker option:selected').val();
		var pay = $('#pay').val();
		var da = $('#spnDa').val();
		var hra = $('#hra').val();
		var hmAllowance = $('#hmAllowance').val();
		var ccAllowance = $('#ccAllowance').val();
		var ir = $('#ir').val();
		var ifAny = $('#ifAny').val();
		var pf = $('#pf').val();
		var pfLoan = $('#pfLoan').val();
		var apgli = $('#apgli').val();
		var apgliLoan = $('#apgliLoan').val();
		var gis = $('#gis').val();
		var pTax = $('#pTax').val();
		var ehs = $('#ehs').val();
		var lic = $('#lic').val();
		var it = $('#it').val();
		var swf = $('#swfEwf').val();
		var reliefFund = $('#relieffund').val();
		var deductionsIfAny = $('#ifAnyDeductions').val();
		var dob = $('#dob').val();
		var dos = $('#dos').val();
		var dor = $('#dor').text();
		var netPay = $('#netPay').val();
		
		var data = "name="+name+"&location="+location+"&cadre="+cadre;
		data += "&office="+office+"&purpose="+purpose+"&pay="+pay;
		data += "&da="+da+"&hra="+hra+"&hmAllowance="+hmAllowance;
		data += "&ccAllowance="+ccAllowance+"&ir="+ir+"&payIfAny="+ifAny;
		data += "&pf="+pf+"&pfLoan="+pfLoan+"&apgli="+apgli;
		data += "&apgliLoan="+apgliLoan+"&gis="+gis+"&pTax="+pTax;
		data += "&ehs="+ehs+"&lic="+lic+"&it="+it;
		data += "&reliefFund="+reliefFund+"&swf="+swf+"&deductionsIfAny="+deductionsIfAny;
		data += "&netPay="+netPay+"&dob="+dob+"&dos="+dos+"&dor="+dor;
		$.ajax({
	        url: 'CertServlet',
	        dataType: 'json',
	        type: 'post',
	        contentType: 'application/x-www-form-urlencoded',
	        data: data,
	        success: function( data, textStatus, jQxhr ){
	        	console.log(data)
	            $('#response pre').html( data );
	        },
	        error: function( jqXhr, textStatus, errorThrown ){
	            console.log( errorThrown );
	        }
	    });
	});
	

	
});