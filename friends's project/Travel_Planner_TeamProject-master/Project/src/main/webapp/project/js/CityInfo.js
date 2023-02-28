var currentMenu;
var menuLinks = document.querySelectorAll('.menu-link');

function clickMenuHandler(){
    if (currentMenu){
        currentMenu.classList.remove('menu-active');  
    }   
    this.classList.add('menu-active');
    currentMenu = this;
}


for (var i = 0; i < menuLinks.length; i++){    /* 단점: 메뉴가 백만개라면....? 또한 addEventListener는 시스템 성능에 악영향을 끼친다고 함 */
    menuLinks[i].addEventListener('click', clickMenuHandler);        
};



function SearchAll() {
	var asia = document.getElementsByClassName("btn1");
	var america = document.getElementsByClassName("btn2");
	var europe = document.getElementsByClassName("btn3");
	
	for(var i = 0; i < asia.length; i++) {
   		asia[i].style.display = 'inline-block';
	}
	for(var j = 0; j < america.length; j++) {
   		america[j].style.display = 'inline-block';
	}
	for(var k = 0; k < europe.length; k++) {
   		europe[k].style.display = 'inline-block';
	}
};
function SearchAsia() {
	var asia = document.getElementsByClassName("btn1");
	var america = document.getElementsByClassName("btn2");
	var europe = document.getElementsByClassName("btn3");
	for(var i = 0; i < asia.length; i++) {
   		asia[i].style.display = 'inline-block';
	}
	for(var j = 0; j < america.length; j++) {
   		america[j].style.display = 'none';
	}
	for(var k = 0; k < europe.length; k++) {
   		europe[k].style.display = 'none';
	}
};
function SearchAmerica() {
	var asia = document.getElementsByClassName("btn1");
	var america = document.getElementsByClassName("btn2");
	var europe = document.getElementsByClassName("btn3");
	for(var i = 0; i < asia.length; i++) {
   		asia[i].style.display = 'none';
	}
	for(var j = 0; j < america.length; j++) {
   		america[j].style.display = 'inline-block';
	}
	for(var k = 0; k < europe.length; k++) {
   		europe[k].style.display = 'none';
	}
};
function SearchEurope() {
	var asia = document.getElementsByClassName("btn1");
	var america = document.getElementsByClassName("btn2");
	var europe = document.getElementsByClassName("btn3");
	for(var i = 0; i < asia.length; i++) {
   		asia[i].style.display = 'none';
	}
	for(var j = 0; j < america.length; j++) {
   		america[j].style.display = 'none';
	}
	for(var k = 0; k < europe.length; k++) {
   		europe[k].style.display = 'inline-block';
	}
};

function fnMove(){
    var offset = $("#submitBtn").offset();
    $('html, body').animate({scrollTop : offset.top-100}, 1000);
};
function topMove(){
    var offset = $("#submitBtn").offset();
    $('html, body').animate({scrollTop : offset.top-800}, 1000);
};

