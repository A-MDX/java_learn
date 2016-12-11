
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
                utilFunction.pagination(data);

                // 清空
                $('#java-path-list').empty();

                data = data.content;
                for(var i =0;i<data.length;i++){
                    
                    // 去除 null... 
                    utilFunction.deleteNullStr(data[i]);
                    
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
                    if (data[i]["is_active"] == constant.STATUS_YES){
                        str += '<a class="fa fa-times" title="停用，失活"></a>'
                    }else if(data[i]["is_active"] == constant.STATUS_NO){
                        str += '<a class="fa fa-check" title="启用，激活"></a>'
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
            utilFunction.jInfo('出错了 load 出错。')
            console.log(e);
        }
    });
}


// 以下 为执行

utilFunction.initFixCodeSelect(constant.JAVA_FILE_PATH+2,"is_big_path");

load(1);

