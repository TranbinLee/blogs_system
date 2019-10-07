var indexVue = new Vue({
	el:"#appContent",
	data:{
		allUsers:[]
	},
	beforeMount: function(){
		var _this = this;
		$.ajax({
			type: 'GET',
			url: "http://127.0.0.1:9001/user/allUsers",
			// dataType: 'JSONP',
			// JSONP:"callback",
			data:{
			},
			success: function(data){
			
			_this._data.allUsers = data.data;
			console.info(data.data);
			},
			beforeSend:function(){
			console.log('发送之前调用');
			                },
			error: function(XMLHttpRequest, textStatus, errorThrown){
			console.info(XMLHttpRequest+"——1——"+textStatus+"——2——"+errorThrown);	
			}
		})
		
	},
	
	methods:{
		
	}
	
});