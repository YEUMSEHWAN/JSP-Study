
/*ID체크*/
function idCheck(id) {
	if(id == "") {
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();
	}else {
	 url = "cityPlan.do?cmd=idCheck&id="+id;
	 window.open(url, "post", "width=300, height=150");	
	}
}

/*닉네임 체크*/
function nickCheck(nick) {
	if(nick == ""){
		alert("닉네임을 입력해주세요.");
		document.regForm.nick.focus();
	}else {
		url ="cityPlan.do?cmd=nickCheck&nick="+nick;
		window.open(url, "post", "width=300, height=150");
	}	
	
}


/*유효성 검사 이메일 비밀번호 맞는지*/
function inputCheck() {
	/*아이디 먼저 검사*/
	if(document.regForm.id.value==""){
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();
		return;
	}
	
	if(document.regForm.pass.value==""){
		alert("비밀번호를 입력해주세요.");
		document.regForm.pass.focus();
		return;
	}
	
	if(document.regForm.repass.value==""){
		alert("비밀번호를 똑같이 입력해주세요.");
		document.regForm.repass.focus();
		return;
	}
	/*비밀번호 2개 일치 체크 */
	if(document.regForm.pass.value !=document.regForm.repass.value){
		alert("비밀번호가 일치 하지 않습니다.");
		document.regForm.repass.focus();
		return;
	}
	
	if(document.regForm.nick.value==""){
		alert("닉네임을 입력해주세요.");
		document.regForm.nick.focus();
		return;
	}
	
	if(document.regForm.email.value==""){
		alert("email을 입력해주세요.");
		document.regForm.email.focus();
		/*중지*/
		return;
	}
	
	/*email 유효성 검사 */
	var str = document.regForm.email.value;
	var atPos = str.indexOf("@");
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos +1 < dotPos && dotPos + 1 < eMailSize){
	}else{	
		alert("E-Mail 주소 형식이 잘못 되었습니다. \n\r 다시 입력 해주세요.");
		document.regForm.email.focus();
		return;
	}
	document.regForm.submit();
}

//뒤로가기
function backbutton() {
	history.back();
}

//구글 로그인 api

//회원 정보 수정 유효성 검사
function updateCheck(){
	
	if(document.regForm.pass.value==""){
		alert("비밀번호를 입력해주세요.");
		document.regForm.pass.focus();
		/*중지*/
		return;
	}
	if(document.regForm.repass.value==""){
		alert("비밀번호를 똑같이 입력해주세요.");
		document.regForm.repass.focus();
		/*중지*/
		return;
	}
	if(document.regForm.pass.value !=document.regForm.repass.value){
		alert("비밀번호가 일치 하지 않습니다.");
		document.regForm.repass.focus(); /*비밀번호를 repass에 focus로 맞춘다.*/
		/*중지*/
		return;
	}
	document.regForm.submit();
}

// 프로필 수정 페이지로 이동
function replaceLink() {
	location.replace('cityPlan.do?cmd=modifyForm');
}

//로그아웃
function logout() {
	if(confirm("정말 로그아웃 하시겠습니까?")) {
		location.href = "<c:url value ='cityPlan.do?cmd=logout'/>";

	}
	
function refocus() {
	document.deleteForm.pass.focus();
}

//비밀번호 찾기 2022-09-26

function pw_search() {
	var frm=document.findPwResult;
	
	if(frm.id.value.length<1){
		alert("아이디를 올바르게 입력해주세요.");
		return;
	}
	
	if(frm.email.value.length <1){
		alert("이메일을 올바르게 입력해주세요.");
		return;
	}
/*	
	frm.method="post";
	frm.action="cityPlan.do?cmd=findPwResult"; //넘어가는 화면
	frm.submit(); //등록 될수 있는 조건이면 조건 보낸다.*/
}

//로그인시
var loginOut = function(){
	var btnLogin = document.getElementById('btnLogin');
	
if(btnLogin != null){
	btnLogin.onclick = function(){
		var frm = document.form_log; //name가져옴
		frm.action = '/project/cityPlan.do?cmd=login';
		frm.submit();
	}
	}
	
}

}
