
var load = function(page){
    if (page == null){
        page = 1
    }

    var json = {};
    $('.form-search').find('.input_search').each(function(){
        json[this.name] = $(this).val();
    });

    json['page'] = page;
    json['page.size'] = 3;

    // console.log('json --> '+json);

    $.ajax({
        url:posturl.baseUrl+"line/path/list",
        data:json,
        type:'post',
        dataType:'json',
        success:function (data) {
            console.log(data);
            if (data.code == result.success){
                data = data.data;

                // 分页系统
                pagination(data);

                // 清空
                $('#java-path-list').empty();

                data = data.content;
                for(var i =0;i<data.length;i++){
                    
                    // 去除 null... 
                    deleteNullStr(data[i]);
                    
                    var userid = data[i]["id"];
                    
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
                    str += '<td>'+data[i]["id"]+'</td>';
                    str += '<td>'+data[i]["user"]+'</td>';
                    str += '<td>'+data[i]["path"]+'</td>';
                    str += '<td>'+data[i]["is_big_path"]+'</td>';

                    str += '<td>'+data[i]["modify_time"]+'</td>';
                    
                    str += '<td>'+data[i]["now_num"]+'</td>';
                    str += '<td>'+data[i]["now_line"]+'</td>';
                    
                    str += '<td>'+data[i]["creation_time"]+'</td>';
                    str += '<td>'+data[i]["is_active_str"]+'</td>';
                    str += '<td>'+data[i]["remark"]+'</td>';
                    
                    str += '<td align="center">';
                    
                    var temp_str = userid;
                    if (data[i]["is_active"] == constant.STATUS_YES){
                        temp_str += ","+constant.STATUS_NO;
                        str += '<a class="fa fa-times" onclick="changeStatus('+temp_str+')" title="停用，失活"></a>'
                    }else if(data[i]["is_active"] == constant.STATUS_NO){
                        temp_str += ","+constant.STATUS_YES;
                        str += '<a class="fa fa-check" onclick="changeStatus('+temp_str+')" title="启用，激活"></a>'
                    }else {
                        str += '<a class="fa fa-frown-o" title="嗯？"></a>'
                    }
                    str += '</td>';
                    
                    str += '</tr>';
                    $('#java-path-list').append(str);
                }
            }

        },
        error:function(e){
            jInfo('出错了 ,load 出错',info.danger)
            console.log(e);
        }
    });
}

// add_new_path 新增地址
$(function () {
   $('#add_new_path').dialog({
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
               $('.form-horizontal').find(".require").each(function () {
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
               $('.form-horizontal').find(".form-control").each(function () {
                   var val = $(this).val().trim();
                   json[this.name] = val;
               });
               console.log(json);
               $.ajax({
                   url : posturl.baseUrl+"line/path/add",
                   type : "post",
                   data : json,
                   dataType : 'json',
                   success : function (data) {
                       console.log(data);
                       if (data.code == result.success){
                           load(1);
                           jInfo("新增成功",info.success);
                           $('#add_new_path').dialog('close');
                       }else{
                           jInfo("新增失败。"+data.msg,info.danger);
                       }
                   }
               })
           },
           "取消" : function () {
               $(this).dialog("close");
           }
       }
   });
});

$(function () {
    $('#sure_is_active').dialog({
        autoOpen: false,
        show: {
            effect: "explode",
            duration: 500
        },
        hide: {
            effect: "blind",
            duration: 500
        },
        height: 250,
        width: 250,
        modal: true,
        buttons : {
            "确认" : function () {
                var id = $('#sure_is_active_id').html();
                var status = $('#sure_is_active_status').html();
                console.log(id,status);
                $.ajax({
                    url : posturl.baseUrl+'/line/path/status/change',
                    type : 'post',
                    data : {"id":id,"isActive":status},
                    dataType : 'json',
                    success : function (data) {
                        console.log(data);
                        if (data.code == result.success){
                            jInfo("修改成功",info.success);
                            load(1);
                            $('#sure_is_active').dialog('close');
                        }else {
                            jInfo("修改失败了。"+data.msg,info.danger);
                        }
                    },
                    error : function (e) {
                        jInfo("修改失败,点击f12调试吧。",info.danger);
                        console.log(e);
                    }
                });
            },
            "取消" : function () {
                $(this).dialog("close");
            }
        }
    });
});

var changeStatus = function (id,status) {
    
    $('#sure_is_active_id').html(id);
    $('#sure_is_active_status').html(status);
    if (status == constant.STATUS_NO){
        $('#sure_is_active_status_str').html("启用状态");
        $('#sure_is_active_status_str1').html(' 停用 ');
    }else{
        $('#sure_is_active_status_str').html("停用状态");
        $('#sure_is_active_status_str1').html(' 启用 ');
    }
    
    $('#sure_is_active').dialog('open');
    
    return;
    
}

var openDialog = function () {
    // 初始化 用户选择下拉选
    $('#add_userid').empty();
    $('#add_userid').append("<option>选择用户</option>")
    initUserSelect("add_userid");
    // 初始化 路径下拉选
    initFixCodeSelect(constant.JAVA_FILE_PATH,"add_is_big_path");
    
    $('#add_new_path').dialog("open");
}

// 以下 为执行

initFixCodeSelect(constant.JAVA_FILE_PATH+2,"is_big_path");

load(1);

