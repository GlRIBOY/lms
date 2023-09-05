<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커에 인포윈도우 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:900px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=be69ac7566e3657e37fe9e85b3b2ae7a"></script>
<script>
let p ='${param.p}';//파라메터 중에 p의 값을 읽어들이겠다.
let q = '${param.q}';
let r = '${param.r}';
let s = '${param.s}';
let t = '${param.t}';
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(p, q), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(p, q); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div style="padding:5px;">'+r+'<br>('+s+')<br><a href="https://map.kakao.com/link/map/'+r+'('+s+')'+t+','+p+','+q+'" style="color:blue" target="_blank">큰지도보기</a>'+
'<a href="https://map.kakao.com/link/to/'+r+'('+s+')'+t+','+p+','+q+'" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(p, q); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>
</html>