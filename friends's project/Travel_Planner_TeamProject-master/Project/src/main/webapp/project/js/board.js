function nwindow(num,commentID){
		window.name = "commentParant";
		var url= "cityPlan.do?cmd=commentUpdate&num="+num+"&commentID="+commentID;
		window.open(url,"","width=600,height=230,left=300");
}

function fnwindow(num,commentID){
		window.name = "commentParant";
		var url= "cityPlan.do?cmd=freeCommentUpdate&num="+num+"&commentID="+commentID;
		window.open(url,"","width=600,height=230,left=300");
}