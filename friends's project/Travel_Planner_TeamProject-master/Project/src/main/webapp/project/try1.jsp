<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="base.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>추천사이트</title>

<script type="text/javascript" src="js/try.js"></script>
<link rel="stylesheet" type="text/css" href="css/try.css">
</head>
<body>
   <div class="recobttn">
		<div onclick="ViewLayerss('mep1'); ViewLayersss('explainname1'); ViewLayerssss('explain1'); ">영국</div>
		<div onclick="ViewLayerss('mep2'); ViewLayersss('explainname2'); ViewLayerssss('explain2'); ">일본</div>
		<div onclick="ViewLayerss('mep3'); ViewLayersss('explainname3'); ViewLayerssss('explain3'); " >중국</div>
		<div onclick="ViewLayerss('mep4'); ViewLayersss('explainname4'); ViewLayerssss('explain4'); " >스페인</div>
		<div onclick="ViewLayerss('mep5'); ViewLayersss('explainname5'); ViewLayerssss('explain5'); " >미국</div>
	</div>
   
	<div class="meps">
		<c:forEach var="array" items="${array }" varStatus="status">  
	    	<div id="mep${status.count}" class="reccity"></div>
		</c:forEach>
	</div>
	
	<div class="explainnames">
		<c:forEach var="array" items="${array }" varStatus="status">
			<div id="explainname${status.count}" class="explain">
				${array.getKoreaname()}
				<br>
			</div>
		</c:forEach>
	</div>
	<br>
	<br>
	<div class="explaincss">
	<c:forEach var="array" items="${array }" varStatus="status">
	<div id="explain${status.count}" class="explains">
		<div class="explains_title">
			1. ${array.getPin1explainname()}
		</div>
		<br>
		${array.getPin1explain()}
		<br>
		↓
		<br>
		<div class="explains_title">
			2. ${array.getPin2explainname()}
		</div>
		<br>
		${array.getPin2explain()}
		<br> 
		↓
		<br>
		<div class="explains_title">
			3. ${array.getPin3explainname()}
		</div>
		<br>
		${array.getPin3explain()}
		<br>
		↓
		<br>
		<div class="explains_title">
			4. ${array.getPin4explainname()}
		</div>
		<br>
		${array.getPin4explain()}
		<br>
		↓
		<br>
		<div class="explains_title">
			5. ${array.getPin5explainname()}
		</div>
		<br>
		${array.getPin5explain()}
		<br>
	</div>
	
	</c:forEach>
	</div>
	

	<script type="text/javascript">
	function initMap() {

	<c:forEach var="array" items="${array}" varStatus="status">  
            const map${status.count} = new google.maps.Map(document.getElementById("mep${status.count}"), {
				mapId: "4d7ece8ee77fe4c0", 
                zoom: 12,
                center: { lat:${array.getMainlongitude()}, lng:${array.getMainlatitude()} },
				panControl: false, /* 기본 설정들 off */
  				zoomControl: false,
  				mapTypeControl: false,
 				scaleControl: false,
 				streetViewControl: false,
 				overviewMapControl: false
            });
            for (var i = 0; i < locations${status.count}.length; i++) {
                var marker = new google.maps.Marker({
                    map: map${status.count},
                    label: locations${status.count}[i].place,
                    position: new google.maps.LatLng(locations${status.count}[i].lat, locations${status.count}[i].lng),
                });
            }

	 </c:forEach> 
        }
		
	<c:forEach var="array" items="${array}" varStatus="status">  
        const locations${status.count} = [
            { place:"1", lat: ${array.getPin1longitude()}, lng: ${array.getPin1latitude()} },
            { place:"2", lat: ${array.getPin2longitude()}, lng: ${array.getPin2latitude()} },
            { place:"3", lat: ${array.getPin3longitude()}, lng: ${array.getPin3latitude()} },
            { place:"4", lat: ${array.getPin4longitude()}, lng: ${array.getPin4latitude()} },
            { place:"5", lat: ${array.getPin5longitude()}, lng: ${array.getPin5latitude()} }
        ];
	 </c:forEach> 
	
	   
	</script>
	  
    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCY1oDgXTf55jiJBGLsiTsCgf9DyrlU66E&callback=initMap&libraries=&v=weekly" defer></script>
</body>

</html>