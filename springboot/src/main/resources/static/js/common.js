
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

/** *关于 某些常量 说明*/
(function () {
    
    constant = {};
    // 统计行数，大路径
    constant.JAVA_FILE_PATH = 1001;
    
    constant.STATUS = 1002;
    constant.STATUS_YES = 10021001;
    constant.STATUS_NO = 10021002;
    
})();

/**  将一些通用 工具类方法，加上一些标记，使代码看着没那么乱。 **/
(function () {
    utilFunction = {};
    
    // 删除对象中的空值 
    utilFunction.deleteNullStr = deleteNullStr;
    // 查询 fixCode，然后初始化下拉选
    utilFunction.initFixCodeSelect = initFixCodeSelect;
    // 自定义分页。
    utilFunction.pagination = pagination;
    // bootstrap alert.
    utilFunction.jInfo = jInfo;
    // 时间选择器初始化
    utilFunction.initTime = initTime;
    
})();

/**
 * 删除对象中的空值
 * @param data
 */
var deleteNullStr = function (data) {
    for (var key in data){
        if (data[key] == null){
            data[key] = '';
        }
    }
}

/**
 * 查询 fixCode，然后初始化下拉选
 */
var initFixCodeSelect = function (codeType,id) {
    $.ajax({
        url : posturl.baseUrl+"util/fixCode",
        data : {"codeType":codeType},
        type : 'get',
        dataType : 'json',
        success : function (data) {
            if (data.code != result.success){
                jInfo(data.msg+",下拉框初始化失败");
                return;
            }
            data = data.data;
            for (var i = 0;i < data.length; i++){
                $('#'+id).append('<option value="'+data[i]["code"]+'">  '+data[i]["codeName"]+'  </option>')
            }
        }
    });
}

/**
 * bootstrap alert.
 * @param msg
 */
var jInfo = function (msg) {
    $('.container').append('<div class="alert alert-danger alert-dismissable">' +
        '<button type="button" class="close" data-dismiss="alert" aria-hidden="true"> &times;</button>' +
        ' <strong>错误！</strong> '+msg+'。' +
        '</div>');
    
}

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
        // 大于 5 页 的情况时，可以正常显示。已经测试过，成功。
        
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
