
var load = function(page){
    if (page == null){
        page = 1;
    }
    
    var json = {};
    $('.form-search').find('.input_search').each(function(){
        json[this.name] = $(this).val();
    });
    
    json['page'] = page;
    json['page.size'] = 5;
    
    $.ajax({
        url:posturl.baseUrl+"eat/type/list",
        data:json,
        type:'post',
        dataType:'json',
        success:function (data) {
            if (data.code == result.success){
                data = data.data;
                
                // 分页系统
                pagination(data);

                // 清空
                $('#eat-type-list').empty();
                
                data = data.content;
                for(var i =0;i<data.length;i++){

                    // 去除 null... 
                    deleteNullStr(data[i]);
                    
                    var str = '';
                    switch ((i+1) % 3){
                        case 0:
                            str += '<tr class="success">';
                            break;
                        case 1:
                            str += '<tr class="warning">';
                            break;
                        case 2:
                            str += '<tr class="info">';
                            break;
                        default:
                            str += '<tr>';
                    }
                    var id = data[i]["id"];
                    str += '<td>'+id+'</td>';
                    str += '<td><a onclick="showPic('+id+')" >'+data[i]["name"]+'</a></td>';
                    str += '<td>'+data[i]["code_name"]+'</td>';
                    str += '<td>'+data[i]["max_dian"]+'</td>';
                    str += '<td>'+data[i]["now_dian"]+'</td>';
                    str += '<td>'+data[i]["creation_time"]+'</td>';
                    
                    str += '<td>'+data[i]["modify_time"]+'</td>';
                    str += '<td>'+data[i]["remark"]+'</td>';

                    str += '<td align="center"><strong>';

                    str += '<a class="fa fa-cog" onclick="modify('+data[i]["id"]+')" title="修改"></a>';
                    
                                        
                    var pic = data[i]["picture"];
                    // console.log(pic);
                    if (pic != '' && pic != 'null'){
                        // str += '&nbsp;<a class="fa fa-file-image-o" onclick="showPic('+data[i]["picture"]+')" title="修改"></a>';
                        str += '&nbsp;&nbsp;<a class="fa fa-file-image-o" onclick="showPic('+id+')" title="查看图片"></a>';
                        str += '<input id="pic_id_'+id+'" type="text" style="display: none;" value="'+pic+'"/>'
                    }
                    str += '</strong></td>';
                    
                    str += '</tr>';
                    $('#eat-type-list').append(str);
                }
            }
            
        },
        error:function(e){
            console.log(e);
            jInfo("修改失败,点击f12调试吧。",info.danger);
        } 
    });
}

// add_new_type 新增类型
$(function () {
    $('#add_new_type').dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: 500
        },
        hide: {
            effect: "explode",
            duration: 500
        },
        height: 350,
        width: 500,
        modal: true,
        buttons : {
            "确认新增" : function () {
                var require = true;
                $('#add_new_type').find(".require").each(function () {
                    var val = $(this).val().trim();
                    if (val == null || val == ''){
                        require = false;
                    }
                });
                if (!require){
                    jInfo("有必填项没有填写完成。",info.warning);
                    return;
                }
                var json = {};
                $('#add_new_type').find(".form-control").each(function () {
                    var val = $(this).val().trim();
                    json[this.name] = val;
                });
                console.log(json);
                $.ajax({
                    url : posturl.baseUrl+"eat/type/add",
                    type : "post",
                    data : json,
                    dataType : 'json',
                    success : function (data) {
                        console.log(data);
                        if (data.code == result.success){
                            load(1);
                            jInfo("新增成功",info.success);
                            $('#add_new_type').dialog('close');
                        }else{
                            jInfo("新增失败。"+data.msg,info.danger);
                        }
                    }
                });
            },
            "取消" : function () {
                $(this).dialog("close");
            }
        }
    });
});

// modify_type_dialog 修改类型
$(function () {
    $('#modify_type_dialog').dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: 500
        },
        hide: {
            effect: "explode",
            duration: 500
        },
        height: 450,
        width: 500,
        modal: true,
        buttons : {
            "重置点数" : function () {
                var id = $('#modify_id').val();
                console.log(id);
                $.ajax({
                    url : posturl.baseUrl+"eat/type/reset",
                    type : "post",
                    data : {"id" : id},
                    dataType : 'json',
                    success : function (data) {
                        console.log(data);
                        if (data.code == result.success){
                            jInfo("重置点数成功",info.success);
                            load(1);
                            $('#modify_type_dialog').dialog('close');
                        }else {
                            jInfo("重置点数失败了。"+data.msg,info.danger);
                        }
                    },
                    error : function (e) {
                        console.log(e);
                        jInfo("修改失败,点击f12调试吧。",info.danger);
                    }
                });
            },
            "启/停用" : function () {
                var status = typeObj.status;
                var str = '';
                
                if (status == constant.STATUS_YES){
                    str = 'Now status is <span style="color:#F8BB86">yes</span>.';
                    status = constant.STATUS_NO;
                }else{
                    str = 'Now status is <span style="color:#F8BB86">no</span>.';
                    status = constant.STATUS_YES;
                }

                swal({
                    title: str+'<span style="color:red;">Sure?</span>',
                    text: "You will not be able to recover this imaginary file!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "Yes, change it!",
                    cancelButtonText: "No, cancel plx!",
                    closeOnConfirm: false,
                    closeOnCancel: false,
                    html: true
                }, function(isConfirm){
                    if (isConfirm) {
                        
                        var json = {};
                        json['modify_id'] = typeObj.id;
                        json['modify_status'] = status;
                        
                        $.ajax({
                            url : posturl.baseUrl+"eat/type/modify",
                            type : "post",
                            data : json,
                            // async : false,
                            dataType : 'json',
                            success : function (data) {
                                console.log(data);
                                if (data.code == result.success){
                                    swal("Change!", "This status has been change.", "success");
                                    load(1);
                                    $('#modify_type_dialog').dialog('close');
                                }else{
                                    swal("Warning!", "Change fail...", "error");
                                }
                            },
                            error : function (e) {
                                console.log(e);
                                jInfo("查找修改的对象失败,点击f12调试吧。",info.danger);
                                swal("Warning!", "Change fail...", "error");
                            }
                        });
                        
                        
                    } else {
                        swal({
                            title : "Cancelled",
                            text : "This status will be continue :)",
                            type : "error",
                            timer : 2000,
                            showConfirmButton : false
                        });
                    }
                });
                
            },
            "确认修改" : function () {
                
                var json = {};
                $('#modify_type_dialog').find(".form-control").each(function () {
                    var val = $(this).val().trim();
                    json[this.name] = val;
                });
                // console.log(json);
                
                var length = Object.getOwnPropertyNames(json).length;
                for(var key in json){
                    if(json[key] == null || json[key] == ''){
                        delete json[key];
                        length--;
                        continue;
                    }
                    // 没有更改，则不再提交。
                    if(json[key] == typeOld[key]){
                        delete json[key];
                        length--;
                    }
                }
                if (length <= 0){
                    swal('Oh! No.','There is no change for submit.','warning');
                    return;
                }
                json['modify_id'] = typeObj.id;
                console.log(json);
                
                $.ajax({
                    url : posturl.baseUrl+"eat/type/modify",
                    type : "post",
                    data : json,
                    dataType : 'json',
                    success : function (data) {
                        console.log(data);
                        if (data.code == result.success){
                            load(1);
                            jInfo("修改成功",info.success);
                            $('#modify_type_dialog').dialog('close');
                        }else{
                            jInfo("新增失败。"+data.msg,info.danger);
                        }
                    }
                });
            },
            "取消" : function () {
                $(this).dialog("close");
            }
        }
    });
});

initFixCodeSelect(constant.STATUS,"select_status");

var addType = function () {
    $('#add_new_type').dialog('open');
}

// 一个全局的修改对象
var typeObj = {};
var typeOld = {};

var modify = function (id) {
    console.log(id);
    
    var canModify = true;

    $.ajax({
        url : posturl.baseUrl+"eat/type/one",
        type : "post",
        data : {"id" : id},
        async : false,
        dataType : 'json',
        success : function (data) {
            // console.log(data);
            if (data.code == result.success){
                // jInfo("重置点数成功",info.success);
                typeObj = data.data;
            }else {
                jInfo("寻找当前条目失败。"+data.msg,info.danger);
                canModify = false;
            }
        },
        error : function (e) {
            console.log(e);
            jInfo("查找修改的对象失败,点击f12调试吧。",info.danger);
            canModify = false;
        }
    });

    console.log(typeObj);

    if (!canModify){
        // 未能加载数据，则不能修改
        return;
    }

    // 添值
    $('#modify_id').val(typeObj.id);
    $('#modify_name').val(typeObj.name);
    $('#modify_max_dian').val(typeObj.maxDian);
    $('#modify_now_dian').val(typeObj.nowDian);
    $('#modify_picture').val(typeObj.picture);
    $('#modify_remark').val(typeObj.remark);
    
    $('#modify_type_dialog').find('.form-control').each(function () {
        typeOld[this.name] = $(this).val(); 
    });
    
    // console.log('typeOld -> '+typeOld);
    // console.log(typeOld);
    
    $('#modify_type_dialog').dialog('open');
    
};

var showPic = function (id) {
    var pic = $('#pic_id_'+id).val();
    // console.log(pic);
    if (pic == null){
        return;
    }
    swal({   
        title: "Sweet!",
        text: "This is food here~~~",
        imageUrl: pic,
        imageSize : "200x200"
    });
};

load(1);

