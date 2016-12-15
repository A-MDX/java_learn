
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
                    success : function (data) {
                        console.log(data);
                      if (data.code != result.success){
                          jInfo("统计失败。"+data.msg,info.danger);
                      }else {
                          // success... 
                          // TODO .. 
                          
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
    
    $('#count_dialog_userid').append('<option value="">选择</option>');
    initUserSelect("count_dialog_userid");
    $('#count_dialog').dialog('open');
}

