window.addEventListener('load',function(){
	let big=document.getElementById("big");
	let small=document.getElementsByClassName("small");
	for (var i = 0; i < small.length; i++) {
		small[i].onclick=function(){
			big.src=this.src;
		}
	}
	
});