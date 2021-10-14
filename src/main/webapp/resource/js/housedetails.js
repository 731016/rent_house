window.addEventListener('load',function(){

	$(function () {
		$.ajax({
			type: 'post',
			dataType: 'json',
			cache:false,
			url: '/login',
			cache: false,
			success: function (data) {
				let object = data.object;
				if (object !== undefined) {
					// TODO :点击账户名进入账户信息页面
					$('#topright #login').text(object.account).prop('href','javascript;');
					// TODO: exit账户，删除session
					$('#topright #register').text('退出').prop('href','/exit');
				} else {
					$('#topright #login').text('登录').prop('href','login.jsp');
					$('#topright #register').text('注册').prop('href','register.jsp');
				}
			},
			error: function (res) {
				$('body').innerText(res.responseText);
			}
		});
	});

	let big=document.getElementById("big");
	let small=document.getElementsByClassName("small");
	for (let i = 0; i < small.length; i++) {
		small[i].onclick=function(){
			big.src=this.src;
		}
	}
	
});