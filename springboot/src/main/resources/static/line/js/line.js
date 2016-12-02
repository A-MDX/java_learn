
var load = function(page){
    if (page == null){
        page = 1
    }
    
    $.ajax({
        url:posturl.baseUrl+"line/line/list",
        data:{'page':page,'userid':1},
        type:'post',
        dataType:'json',
        success:function (data) {
            console.log(data);
            if (data.code == result.success){
                data = data.data;
                $('.pagination').pagination({
                    jumppage : false,
                    pageSize : false,
                    totalPages : data.totalPageSize,
                    currentPage : data.pageNumber,
                    page : function(page) {
                        load(page);
                    }
                });
                data = data.content;
                for(var i =0;i<data.length;i++){
                    var str = '<tr>';
                    str += '<td>'+data[i]["id"]+'</td>';
                    str += '<td>'+data[i]["creation_time_str"]+'</td>';
                    str += '<td>'+data[i]["file_num"]+'</td>';
                    str += '<td>'+data[i]["line_num"]+'</td>';
                    str += '<td>'+data[i]["num_than_provious"]+'</td>';
                    str += '<td>'+data[i]["line_than_provious"]+'</td>';
                    str += '<td>'+data[i]["creator"]+'</td>';
                    str += '</tr>'
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
