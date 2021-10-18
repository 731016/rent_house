window.addEventListener('load',function(){
	cocoMessage.config({
		duration: 2000,
	});
	initialTable();
	let no=document.getElementsByClassName("no");
	let state=document.getElementsByClassName("state");
	//根据状态显示启用禁用
	for (var j = 0; j < state.length; j++) {
		if(state[j].innerHTML==-1){
			no[j].innerHTML="启用";
		}else{
			no[j].innerHTML="禁用";
		}
	}
	//禁用启用变换
	for (var i = 0; i < no.length; i++) {
		no[i].onclick=function(){
			let sta=this.parentElement.previousElementSibling;
			let na=this.parentElement.parentElement.firstChild.nextElementSibling.innerHTML;
			let noo=this.innerHTML;
			if(confirm('确定要'+noo+' '+na+' 吗')){
				if(sta.innerHTML==1){
					this.innerHTML="启用";
					sta.innerHTML=-1;
				}else{
					this.innerHTML="禁用";
					sta.innerHTML=1;
				}
			}
		}
	}


	// let chkall=document.getElementById("chkall");
	// let chk=document.getElementsByClassName("chk");

	// // 全选
	// chkall.onclick=function(){
	// 	for (var i = 0; i < chk.length; i++) {
	// 		chk[i].checked=this.checked;
	// 	}
	// }
	// for (var i = 0; i < chk.length; i++) {
	// 	chk[i].onclick=function(){
	// 		for (var j = 0; j < chk.length; j++) {

	// 			if(chk[j].checked==false){
	// 				chkall.checked=false;
	// 				break;
	// 			}else{
	// 				chkall.checked=true;
	// 			}
	// 		}
	// 	}
	// }
});
function initialTable() {
	$('#tbody').children().remove();
	$.ajax({
		type:'post',
		async:false,
		url:'/userlist',
		dataType:'json',
		success:function (data) {
			let json = data.object;
			$.each(json,function () {
				let $tr = $('<tr>\n' +
					'<td class="td">'+this.userName+'</td>\n' +
					'<td>'+this.account+'</td>\n' +
					'<td>'+this.phone+'</td>\n' +
					'<td>'+this.email+'</td>\n' +
					'<td class="state">'+this.state+'</td>\n' +
					'<td><a href="#" class="no">'+(this.state==='1'?"禁用":"启用")+'</a></td>\n' +
					'</tr>');
				$('#tbody').append($tr);
			})
		}
	})
}