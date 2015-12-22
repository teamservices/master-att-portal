<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accenture Services Page</title>
</head>
<style>
h2 {
    text-align: center;
    color: blue;
}
  p:hover {
    background: yellow;
  }
</style>
<body>
<h2>Services offered by Accenture</h2>
 <b>Services to ATT has been classified into two groups. They are:</b>
<c:forEach items="${catagory}" var="_cat">
              <div class="clickable" data-classification="true" id="${_cat.cId}" style="color: brown;"><c:out value="${_cat.cName}" /></div>
              <div class="clickable" data-fnareas="true" id="cList_${_cat.cId}" style="color: blue;"></div>
              <div class="clickable" data-platform="true" id="pList_${_cat.cId}" style="color: red;"></div>
              <div id="dList_${_cat.cId}" style="color: green;"></div>
</c:forEach>
</body>

  <script type="text/javascript">

       function getAreasList(cId) {
               $.ajax({
                      type: "GET",
                      url: "getFnAreas",
                      dataType:'json',
                      data: "id=" + cId,
                      success: function(response){
                            showFnList(response);
                      },
                      error: function(e){
                            console.log('Error:', e);
                      }
               });
        }

       function getPlatformList(cId) {
               $.ajax({
                      type: "GET",
                      url: "getPlatforms",
                      dataType:'json',
                      data: "id=" + cId,
                      success: function(response){
                            showPfList(response,cId);
                      },
                      error: function(e){
                            console.log('Error:', e);
                      }
               });
        }

       function getDomainList(cId,pId) {
          alert(pId);
               $.ajax({
                      type: "GET",
                      url: "getDomains",
                      dataType:'json',
                      data: "cId=" + cId + "&pId="+pId,
                      success: function(response){
                    	 showDomainList(response,cId);
                      },
                      error: function(e){
                            console.log('Error:', e);
                      }
               });
       }

       function showFnList(response){
          for ( var i = 0, len = response.length; i < len; ++i) {
               var fl = response[i];
               $('#cList_'+fl.cId).append("<li>" + fl.fName+ "</li>");
              }
          $('#cList_'+fl.cId).append("<b> Click here to know more</b>");
       }

       function showPfList(response, cId){
          for ( var i = 0, len = response.length; i < len; ++i) {
               var pf = response[i];
               $('#pList_'+cId).append("<li id="+ pf.pId +">" + pf.pName+ "</li>");
              }
       }
       
       function showDomainList(response, cId){
           for ( var i = 0, len = response.length; i < len; ++i) {
                var dl = response[i];
                $('#dList_'+cId).append("<li>" + dl.dName+ "</li>");
              }
        }
         
       $('.clickable').off('click').on('click', function(e) {

           if($(this).data('classification')){
                  var cId = this.id;
                  getAreasList(cId);
           }

           if($(this).data('fnareas')){
        	  var cId = this.id;
        	  var cId = cId.split(/[_ ]+/).pop(); 
               getPlatformList(cId);
       		}
           
           if($(this).data('platform')){
               var cId = this.id;
               var pId;
               cId = cId.split(/[_ ]+/).pop();
               //TODO
               getDomainList(cId,2);
        	}
   		});

   </script>

</html>

