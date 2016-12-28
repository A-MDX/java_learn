
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
    
    console.log('json --> '+json);
    
    $.ajax({
        url:posturl.baseUrl+"eat/type/list",
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

                    str += '<td align="center">';

                    str += '<a class="fa fa-cog" onclick="modify('+data[i]["id"]+')" title="修改"></a>';
                    
                                        
                    var pic = data[i]["picture"];
                    // console.log(pic);
                    if (pic != '' && pic != 'null'){
                        // str += '&nbsp;<a class="fa fa-file-image-o" onclick="showPic('+data[i]["picture"]+')" title="修改"></a>';
                        str += '&nbsp;&nbsp;<a class="fa fa-file-image-o" onclick="showPic('+id+')" title="查看图片"></a>';
                        str += '<input id="pic_id_'+id+'" type="text" style="display: none;" value="'+pic+'"/>'
                    }
                    str += '</td>';
                    
                    str += '</tr>';
                    $('#eat-type-list').append(str);
                }
            }
            
        },
        error:function(e){
            console.log(e);
        } 
    });
}

initFixCodeSelect(constant.STATUS,"select_status");

var modify = function (id) {
    console.log(id);
    
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

