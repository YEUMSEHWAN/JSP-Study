function idCheck(id) {
	if (id == "") {
		alert("아이디를 입력해주세요.");
		document.login.userID.focuse();
	} else {
		url = "idCheck.jsp?userID=" + id;
		window.open(url, "post", "width = 300, height = 150");
	}
}
function inputCheck() {
	if (document.regForm.userID.value == "") {
		alert("아이디를 입력해주세요.");
		document.regForm.userID.focus();
		return;
	}
	if (document.regForm.userPassword.value == "") {
		alert("비밀번호를를 입력해주세요.");
		document.regForm.userPassword.focus();
		return;
	}
	if (document.regForm.userEmail.value == "") {
		alert("이메일를 입력해주세요.");
		document.regForm.userEmail.focus();
		return;
	}
	//이메일 형식 검사.
	var str = documnet.regForm.userEamil.value
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 &&
		commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
	else {
		alert("E-mail 주소 형식이 잘못 되었습니다.\n\r 다시 입력해 주세요.");
		document.regForm.userEmail.focus();
		return;
	}

	if (document.regForm.userName.value == "") {
		alert("이름를 입력해주세요.");
		document.regForm.userName.focus();
		return;
	}
	if (document.regForm.userJumin.value == "") {
		alert("주민번호를 입력해주세요.");
		document.regForm.userJumin.focus();
		return;
	}
	if (document.regForm.userAlchol.value == "") {
		alert("알코올 선호도를 입력해주세요.");
		document.regForm.userAlchol.focus();
		return;
	}
	document.login.submit();

}

function updateCheck() {

	if (document.regForm.pass.value = "") {
		alert("비밀번호를 입력해주세요.");
		document.regForm.pass.focus();
		return;
	}

	if (document.regForm.repass.value = "") {
		alert("비밀번호를 동일하게 입력해주세요.");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.psss != document.regForm.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.email.value == "") {
		alert("이메일을 입력해주세요.");
		document.regForm.email.focus();
		return;
	}

	//이메일 형식 검사
	var str = document.regForm.email.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;

	if (atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
	else {
		alert("E-mail 주소 형식이 잘못 되었습니다.\n\r 다시 입력해 주세요.");
		document.regForm.email.focus();
		return;
	}
	if (document.regForm.alchol.value = "") {
		alert("선호하는 알코올을 입력해주세요.");
		document.regForm.alchol.focus();
		return;
	}
	document.regForm.submit();





}

