
var load = function(page){
    if (page == null){
        page = 1
    }
    
    var json = {};
    $('.form-search').find('.input_search').each(function(){
        json[this.name] = $(this).val();
    });
    
    json['page'] = page;
    json['page.size'] = 2;
    
    // console.log('json --> '+json);
    
    $.ajax({
        url:posturl.baseUrl+"line/line/list",
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
                $('#java-line-list').empty();
                
                data = data.content;
                for(var i =0;i<data.length;i++){
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
                    str += '<td>'+data[i]["creation_time_str"]+'</td>';
                    str += '<td>'+data[i]["file_num"]+'</td>';
                    str += '<td>'+data[i]["line_num"]+'</td>';
                    str += '<td>'+data[i]["num_than_provious"]+'</td>';
                    str += '<td>'+data[i]["line_than_provious"]+'</td>';
                    str += '<td>'+data[i]["creator"]+'</td>';
                    str += '</tr>';
                    $('#java-line-list').append(str);
                }
            }
            
        },
        error:function(e){
            console.log(e);
        } 
    });
}

load(1);

initTime();