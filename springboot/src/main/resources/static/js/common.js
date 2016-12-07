
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
    
    if (totalPageSize <= 5){
        for (var i = 0; i< totalPageSize; i++){
            $('.pagination').append('<li><a id="pagination-li-'+(i+1)+'" onclick="load('+(i+1)+')">'+(i+1)+'</a></li>')
        }
    }else {
        // 大于 5 页 的情况时，比较复杂, 目前数据量较少，还没法测试，过些天看看。
        //TODO wait test...
        
        if (pageNumber <= 3){
            // 照旧
            for (var i = 0; i <= 5; i++){
                $('.pagination').append('<li><a id="pagination-li-'+(i+1)+'" onclick="load('+(i+1)+')">'+(i+1)+'</a></li>')
            }
            $('.pagination').append('<li><a>...</a></li>');
            $('.pagination').append('<li><a id="pagination-li-'+totalPageSize+'" onclick="load('+totalPageSize+')">'+totalPageSize+'</a></li>')
        }else if (pageNumber >= (totalPageSize-3)){
            $('.pagination').append('<li><a id="pagination-li-1" onclick="load(1)">1</a></li>');
            $('.pagination').append('<li><a>...</a></li>')
            for (var i = totalPageSize-5; i< totalPageSize; i++){
                $('.pagination').append('<li><a id="pagination-li-'+(i+1)+'" onclick="load('+(i+1)+')">'+(i+1)+'</a></li>')
            }
        }else {
            $('.pagination').append('<li><a id="pagination-li-1" onclick="load(1)">1</a></li>');
            $('.pagination').append('<li><a>...</a></li>');

            for (var i = pageNumber-2; i <= pageNumber+2; i++){
                $('.pagination').append('<li><a id="pagination-li-'+(i+1)+'" onclick="load('+(i+1)+')">'+(i+1)+'</a></li>')
            }
            
            $('.pagination').append('<li><a>...</a></li>');
            $('.pagination').append('<li><a id="pagination-li-'+totalPageSize+'" onclick="load('+totalPageSize+')">'+totalPageSize+'</a></li>')
            
        }
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

//添加时间,初始化时间
var initTime = function(){
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
        festival:true,
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };

    laydate.skin('default');  //加载皮肤，参数lib为皮肤名 
};
