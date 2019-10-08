window.onload=function(){
	/* 检查是否有session */
	$.ajax({
		url:"checkcookie.jsp",
		success:function(e){
			var result=e.replace(/\s/g, "");
			if(result=="ok"){
				window.location.href="login.jsp"
			}
		}
	})
	/* 退出 */
	$(".exitbtn").on("click",function(){
		$.ajax({
			url:"exit.jsp",
			success:function(e){
				var result=e.replace(/\s/g, "");
				if(result=="ok"){
					window.location.href="login.jsp"
				}
			}
		})
		
	})
	
	/* 查询 */
	var tbody = document.querySelector("tbody")
	var zong = document.querySelector(".zong")
	ajax({
		url:"ajax.jsp",
		dataType:"json",
		success:function(e){
			var uname=e[e.length-1]["sessionname"]
			var uid=e[e.length-1]["sessionuid"]
			$(".wun").html(uname)
			var data=e;
			for(var i=0;i<data.length-1;i++){
				var tr = document.createElement("tr")
				$(tr).attr("id",data[i].id)
				var sex="男"
				if(data[i].sex==0){
					sex="女"
				}
				var td=""
				td+="<td class='id' >"+data[i].id+"</td>"
				td+="<td class='usname'>"+data[i].name+"</td>"
				td+="<td class='sex'>"+sex+"</td>"
				td+="<td class='age'>"+data[i].age+"</td>"
				td+="<td class='score'>"+data[i].score+"</td>"
				td+="<td class='uid' >"+data[i].uid+"</td>"
				td+=`<td class='caozuo'>
					<button type="button" class="delbtn btn btn-danger ">删除</button>
					<button type="button" class="editbtn btn btn-default ">编辑</button>
					</td>`
				tr.innerHTML=td;
				tbody.appendChild(tr);
			}
			zong.style.display="none";
		}
	})
	
	/* 添加 */
	var addbtn=document.querySelector(".addbtn");
	addbtn.onclick=function(){
		zong.style.display="block";
		$.ajax({
			url:"add.jsp",
			success:function(e){
				a=e.indexOf(",")
				id=e.substring(0,a)
				uid=e.substring(a+1,e.length)
				if(e!=null){
					var tr = document.createElement("tr")
					$(tr).attr("id",id)
					var td=""
					td+=`<td class='id'>`+id+`</td>
						<td class='usname'>`+''+`</td>
						<td class='sex'>`+'女'+`</td>
						<td class='age'>`+0+`</td>
						<td class='score'>`+0+`</td>
						<td class='uid' >`+uid+`</td>
						<td class='caozuo'>
							<button type="button" class="delbtn  btn btn-danger ">删除</button>
							<button type="button" class="editbtn btn btn-default ">编辑</button>
						</td>`
					tr.innerHTML=td
					tbody.appendChild(tr);
					zong.style.display="none";
					
				}else{
					console.log("error")
				}
			}
		})
		
	}
	/* 删除 */
	$("table").on("click",".delbtn",function(){
		zong.style.display="block";
		var tr=$(this).parents("tr")
		var id =tr.attr("id")
		$.ajax({
			url:"del.jsp",
			data:{
				id:id
			},
			success:function(e){
				var result=e.replace(/\s/g, "");
				if(result=="ok"){
					tr.remove()
					zong.style.display="none";
				}else{
					alert("删除错误")
				}
			}
		})
		
		
	})
	
	/* 编辑 */
	$("table").on("click",".editbtn",function(){
		var tr=$(this).parents("tr")
		id=tr.attr("id")
		usname=tr.children(".usname")
		age=tr.children(".age")
		sex=tr.children(".sex")
		nan=sex.text()
		score=tr.children(".score")
		
		var text=$(this).text();
		var oldname=usname.text(),oldage=age.text(),oldsex=$('input:radio:checked').val(),oldscore=score.text()
		
		if(text=="保存"){
			zong.style.display="block";
			$(this).text("编辑")
			
			$.ajax({
				url:"edit.jsp",
				data:{
					id:id,
					name:oldname,
					age:oldage,
					sex:oldsex,
					score:oldscore
				},
				success:function(e){
					zong.style.display="none";
					
				}
			})
			usname.removeAttr("contenteditable", true)
			age.removeAttr("contenteditable", true)
			score.removeAttr("contenteditable", true)
			if(oldsex=="1"){
				
				$(sex).text("男")
			}else{
				
				$(sex).text("女")
			}	
			
			return;
		}
		
		if(text=="编辑"){
			$(this).text("保存")
				usname.attr("contenteditable", true)
				age.attr("contenteditable", true)
				score.attr("contenteditable", true)
				$(sex).html('<input type="radio" id="nsex" value="1" name="xsex">男<br><input type="radio" value="0" id="vsex" name="xsex">女')
				if(nan=="男"){
					$("#nsex").attr("checked","checked")
				}else{
					$("#vsex").attr("checked","checked")
				}
				
				return;
		}
		
		
	})
	
			
}