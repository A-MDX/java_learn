
/**
 * 系统宏变量定义
 */

/** *公共的宏变量定义** */
(function () {
    posturl = {};
    posturl.baseUrl = 'http://localhost:8080/';
    
})();

/** *关于 result code 说明*/
(function () {
    result = {};
    result.success = 50;
    result.error = 0;
    result.param_error = 5;
})();

/**
 * 自定义分页。
 */
var pagination = function(data){

    $('.pagination').empty();
    
    var pageNumber = eval(data.pageNumber);
    var pageSize = eval(data.pageSize);
    var totalPageSize = eval(data.totalPageSize);
    var totalSize = data.totalSize;

    $('.pagination').append('<li><a id="pagination-li-prev" >Prev</a></li>');
    
    for (var i = 0; i< totalPageSize; i++){
        $('.pagination').append('<li><a id="pagination-li-'+(i+1)+'" onclick="load('+(i+1)+')">'+(i+1)+'</a></li>')
    }

    $('.pagination').append('<li><a id="pagination-li-next" >Next</a></li>');
    
    // 分页系统
    if (pageSize == pageNumber && pageNumber == 1){
        
        
    }else{
        switch (pageNumber){
            case 1:
                $('#pagination-li-1').attr('onclick','');
                $('#pagination-li-next').bind('click',function () {
                    // alert(1);
                    load(2);
                });
                break;
            case totalPageSize:
                $('#pagination-li-'+totalPageSize).prop('onclick','');
                
                $('#pagination-li-prev').bind('click',function () {
                    load(pageNumber-1);
                });
                break;
            default:
                $('#pagination-li-'+pageNumber).prop('onclick','');
                $('#pagination-li-prev').bind('click',function () {
                    load(pageNumber-1);
                });
                $('#pagination-li-next').bind('click',function () {
                    load(pageNumber+1);
                });
                break;
        }
        
    }
    
    // 当前页面，颜色变一下
    $('#pagination-li-'+pageNumber).css("background-color","#bbb");
    
    
}
