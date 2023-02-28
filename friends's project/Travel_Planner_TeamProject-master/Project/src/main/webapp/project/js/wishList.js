var mP = document.getElementsByClassName('mP');
var wL = document.getElementsByClassName("wL");
var al = document.getElementById('wishList_makePlan');
function myPlanClick() {
	for(var i = 0; i < mP.length; i++) {
		mP[i].style.display = 'inline-block';
	}
	for(var i = 0; i < wL.length; i++) {
		wL[i].style.display = 'none';
	}
	al.style.display = 'block';
}
function wishListClick() {
	for(var i = 0; i < mP.length; i++) {
		mP[i].style.display = 'none';
	}
	for(var i = 0; i < wL.length; i++) {
		wL[i].style.display = 'inline-block';
	}
	al.style.display = 'none';
}
