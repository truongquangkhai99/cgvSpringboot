 function closeModel(){
    	  $('#exampleModaltest').modal('hide');
      }
	  function getSchedule(id){
	    	var nameID = "schedule" + id;
	    	$.ajax({
	    		  url: "/user/get-list-schedule",
	    		  type:"get",
	    		  data:{
	    			idFilm:id
	    		  },
	    		  success: function(data){
	    		
	    			  var row = document.getElementById(nameID);
	    			  var html = "<option selected value="+0+">Chọn lịch chiếu</option>"
	    			  html+=data;
            		  row.innerHTML = html;
	    		  }
	    		});
	    	
	    }
	  function getShowtime(id){
		  	var nameID = "schedule" + id;
			var nameIDShow = "showtime" + id;
		  	var idSchedule = document.getElementById(nameID).value;
	    	$.ajax({
	    		  url: "/user/get-list-show-time",
	    		  type:"get",
	    		  data:{
	    			  idSchedule:idSchedule 
	    		  },
	    		  success: function(data){
	    			  var row = document.getElementById(nameIDShow);
	    			  var html = "<option selected value="+0+">Chọn suất chiếu</option>"
	    			  html+=data;
          		  	   row.innerHTML = html;
	    		  }
	    		});
	    	
	    }
		  function getRoom(id){
				var nameID = "room" + id;
		    	$.ajax({
		    		  url: "/user/get-list-room",
		    		  type:"get",
		    		  success: function(data){
		    			  var row = document.getElementById(nameID);
		    			  var html = "<option selected value="+0+">Chọn phòng</option>"
		    			  html+=data;
	        		  	   row.innerHTML = html;
		    		  }
		    		});
		    	
		    }
		  function getSeat(id){
			  var nameIDSchedule = "schedule" + id;
			  var nameIDShowtime = "showtime" + id;
			  var nameIDRoom = "room" + id;
			  var idSchedule = document.getElementById(nameIDSchedule).value;
			  var idShowtime = document.getElementById(nameIDShowtime).value;
			  var idRoom = document.getElementById(nameIDRoom).value;
			  var nameID = "seat" + id;
		    	$.ajax({
		    		  url: "/user/get-list-seat",
		    		  type:"get",
		    		  data:{
		    			  idFilm:id,
		    			  idSchedule:idSchedule,
		    			  idShowtime:idShowtime,
		    			  idRoom:idRoom
		    		  },
		    		  success: function(data){
		    			  var row = document.getElementById(nameID);
		    			  var html = "<option selected value="+0+">Chọn ghế</option>"
		    			  html+=data;
	      		  	   row.innerHTML = html;
		    		  }
		    		});
		    	
		    }
		  function bookticket(idFilm){
			   var nameBtn = "btn-close" + idFilm;
			   var nameError = "resultError" + idFilm;
			   var nameIDmodel = "#exampleModa" + idFilm
			   var nameIdSchedule = "schedule" + idFilm;
			   var nameIdShowtime = "showtime" + idFilm;
			   var nameIdRoom = "room" + idFilm;
			   var nameIdSeat = "#seat" + idFilm
			   var idSchedule = document.getElementById(nameIdSchedule).value;
			   var idShowtime = document.getElementById(nameIdShowtime).value;
			   var idRoom = document.getElementById(nameIdRoom).value;
			   var idSeat = $(nameIdSeat).val();
				
		    	$.ajax({
		    		  url: "/user/bookticket",
		    		  type:"post",
		    		  data:{
		    			  idSchedule:idSchedule ,
		    			  idShowtime:idShowtime,
		    			  idRoom:idRoom,
		    			  idFilm:idFilm,
		    			  idSeat:JSON.stringify(idSeat)
		    		  },
		    		  success: function(data){
		    			  var tongtien = 0;
		    			  var row = document.getElementById("result");
		    			  var row1 = document.getElementById(nameError);
		    			  var dataHTML = '';
		    			  if(data.status == "ErrorEmpty"){
		    				  row1.innerHTML=data.message
		    			  }else if(data.status == "Success"){
										 
		    				  dataHTML+=`<p ><span style="font-weight:bold">Tên phim : </span>`+data.listName.filmName+`</p><br>
										<p ><span style="font-weight:bold">Lịch chiếu : </span>`+data.listName.scheduleName+`</p><br>
										<p ><span style="font-weight:bold">Suất chiếu : </span>`+data.listName.showtimeName+`</p><br>
										<p ><span style="font-weight:bold">Phòng chiếu : </span>`+data.listName.roomName+`</p><br>`
								dataHTML+=`<span style="font-weight:bold">Ghế : `			
							  for(var i = 0; i<data.nameSeat.length ;i++){
								dataHTML+=`<span>`+data.nameSeat[i]+" "+`</span>`
								tongtien = tongtien + 65000	;
							 }	
							 dataHTML+=`<p style="margin-top: 25px" ><span style="font-weight:bold">Tổng tiền : </span>`+tongtien+` VND</p><br>`
							 dataHTML+=`<p style="margin-top: 30px"><span >⚠️ Lưu ý  : Đơn hàng đã đặt thành công vui lòng chụp lại màn hình và đưa cho nhân viên khi thanh toán tại rạp</span></p><br>`		  
		    				  row.innerHTML = dataHTML;
		    				  document.getElementById(nameBtn).click();
		              		  $(document).ready(function(){
		              		    	 $('#exampleModaltest').modal('show');
		              		  });
		              		
		    			  }else if(data.status == "ErrorLogin"){
		    				  dataHTML+=data.message;
		    				  row.innerHTML = dataHTML;
			              		 
		    				  document.getElementById(nameBtn).click();
		              		  $(document).ready(function(){
		              		    	 $('#exampleModaltest').modal('show');
		              		  });
		              		
		    			  }
		    			 
		    		  }
		    		
		    		});
		    	
		    }
