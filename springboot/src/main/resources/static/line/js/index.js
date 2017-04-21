
// init 统计模块
$(function () {
    $('#count_dialog').dialog({
        autoOpen: false,
        show: {
            effect: "drop",
            duration: 500
        },
        hide: {
            effect: "flod",
            duration: 500
        },
        height: 250,
        width: 300,
        modal: true,
        buttons : {
            "确认": function () {
                var userid = $('#count_dialog_userid').val();
                if (userid == ''){
                    jInfo("要选择用户",info.warning);
                    return;
                }
                $.ajax({
                    url : posturl.baseUrl+'/line/line/count',
                    data : {'userid':userid},
                    type : 'get',
                    dataType : 'json',
                    timeout:10000,//超时时间设置为10秒；
                    beforeSend:function(){
                        $('#loadDialog').show();
                    },
                    success : function (data) {
                        $('#loadDialog').hide();
                        console.log(data);
                      if (data.code != result.success){
                          jInfo("统计失败。"+data.msg,info.danger);
                      }else {
                          // success... 
                          $('#count_dialog').dialog('close');
                          data = data.data;

                          swal({
                              title: "Success!",
                              text: "<p style='font-family: \"微软雅黑\";'>这里是统计结果:\n" +
                              "当前用户名称 ：<span style='color:red;'>"+data['user_name']+"</span><br>" +
                              "当前文件数目 ：<span style='color:red;'>"+data['java_file']+"</span><br>" +
                              "当前java行数 ：<span style='color:red;'>"+data['java_line']+"</span>",
                              type: "success",
                              confirmButtonText: "Cool",
                              html : true
                          });
                          
                          
                          // $('#count_dialog_result_name').html(data['user_name']);
                          // $('#count_dialog_result_java_file').html(data['java_file']);
                          // $('#count_dialog_result_java_line').html(data['java_line']);
                          // $('#count_dialog_result').dialog('open');
                          
                      }
                       
                    },
                    error : function (e) {
                        jInfo('出错',info.danger);
                        console.log(e);
                    }
                });
            },
            "取消" : function () {
                $(this).dialog('close');
            }
            
        }
    });
    
    
    
});

var open_count_dialog = function () {
    
    $('#count_dialog_userid').empty();
    $('#count_dialog_userid').append('<option value="">选择</option>');
    initUserSelect("count_dialog_userid");
    $('#count_dialog').dialog('open');
}

$(function () {
    $.ajax({
       url : posturl.baseUrl+'line/user/msg',
        type : 'get',
        dataType : 'json',
        success : function (data) {
            console.log(data);
            if (data.code == result.success){
                $('#index_user_msg').empty();
                data = data.data;
                for (var i=0;i<data.length;i++){
                    var str = '<tr>';
                    str += '<td>'+data[i]['id']+'</td>';
                    str += '<td>'+data[i]['name']+'</td>';
                    str += '<td>'+data[i]['javaLine']+'</td>';
                    str += '</tr>';
                    $('#index_user_msg').append(str);
                }
            }else {
                jInfo('加载user 信息失败',info.danger);
            }
        },
        error : function (e) {
            jInfo("修改失败,点击f12调试吧。",info.danger);
            console.log(e);
        }
    });
});

