
// 随机种类 
var randomType = function () {
    
    $.ajax({
        url : posturl.baseUrl+"eat/random/type",
        type : "get",
        async : false,
        dataType : 'json',
        success : function (data) {
            console.log(data);
            if (data.code == result.success){
                data = data.data;
                var pic = data['picture'];
                
                swal({
                    title: "Sweet!",
                    text: "This is food type here~~~",
                    imageUrl: pic,
                    imageSize : "350x350",
                    timer : 1500,
                    showConfirmButton : false
                });

                var id = data['id'];
                $('#search_type').val(id);
                $('#type_id').val(id);

                $('#div_pic_type').empty();
                $('#div_pic_type').append('<img src="'+pic+'" class="img-responsive center-block">')

            }else {
                swal("Fail","There has some wrong thing."+data.msg,"error");
            }
            
        },
        error : function (e) {
            console.log(e);
            swal("Fail","There has some wrong things.Enter F12 to see.","error");
        }
    });
    
}

// 直接随机菜单
var randomOnlyMenu = function () {
    $.ajax({
        url : posturl.baseUrl+"eat/random/onlymenu",
        type : "get",
        dataType : 'json',
        success : function (data) {
            console.log(data);
            if (data.code == result.success){
                data = data.data;

                menuObj = data;
                
                var pic = data['picture'];

                swal({
                    title: "Sweet!",
                    text: "This is food type here~~~",
                    imageUrl: pic,
                    imageSize : "350x350",
                    timer : 1500,
                    showConfirmButton : false
                });

                $('type_id').val();
            }else {
                swal("Fail","There has some wrong things."+data.msg,"error");
            }

        },
        error : function (e) {
            console.log(e);
            swal("Fail","There has some wrong things.Enter F12 to see.","error");
        }
    });
}

var randomMenu = function () {
    var type_id = $('#type_id').val();
    
    if (type_id == ''){
        randomType();
        type_id = $('#type_id').val();
        if (type_id == ''){
            swal("Fail","I can't find type_id...","error");
            return;
        }
    }

    var json = {};
    
    json['type'] = type_id;
    
    $.ajax({
        url : posturl.baseUrl+"eat/random/menu",
        type : "post",
        data : json,
        dataType : 'json',
        success : function (data) {
            console.log(data);
            if (data.code == result.success){
                data = data.data;
                
                menuObj = data;
                
                var pic = data['picture'];

                swal({
                    title: "Sweet!",
                    text: "This is food type here~~~",
                    imageUrl: pic,
                    imageSize : "350x350",
                    timer : 1500,
                    showConfirmButton : false
                });
                
                $('#div_pic_menu').empty();
                $('#div_pic_menu').append('<img src="'+pic+'" class="img-responsive center-block" >');
                
            }else {
                swal("Fail","There has some wrong things.\n"+data.msg,"error");
            }

        },
        error : function (e) {
            console.log(e);
            swal("Fail","There has some wrong things.Enter F12 to see.","error");
        }
    });
    
}

var resetType = function () {
    $('#search_type').val('');
    $('#type_id').val('');
    $('#div_pic_type').empty();
    $('#div_pic_type').append('<img src="http://ww4.sinaimg.cn/mw1024/7d191febgw1fbln33qmrrj20500503yg.jpg" class="img-responsive center-block">');
}


var menuObj = {};
var showMenuInfo = function () {
    var id = menuObj['id'];
    if (id == null || id == ''){
        return;
    }

    swal({
        title: "Sweet!",
        text: "This is food type here~~~",
        imageUrl: menuObj['picture'],
        imageSize : "350x350"
        
    });
    
}

var initEatTypeSelect = function (id) {
    // var result = true;
    $.ajax({
        url: posturl.baseUrl + "eat/menu/type",
        type: "post",
        async : false,
        dataType: 'json',
        success: function (data) {
            // console.log(data);
            if (data.code == result.success) {

                $('#'+id).empty();
                $('#'+id).append('<option value="">  食物类型  </option>');

                data = data.data;
                for (var i=0;i<data.length;i++){
                    $('#'+id).append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
                }
                // result = true;
            } else {
                jInfo("初始化食物类型下拉选失败。" + data.msg, info.danger);
                // result = false;
            }
        },
        error: function (e) {
            console.log(e);
            jInfo("初始化食物类型下拉选失败", info.danger);
            // result = false;
        }
    });
    // return result;
}
initEatTypeSelect('search_type');


