package madx.service.impl;

import madx.common.Common;
import madx.common.JdbcCommonEnum;
import madx.dao.JavaFilePathDao;
import madx.dao.JavaLineNumDao;
import madx.dao.UserDao;
import madx.entity.JavaFilePathPO;
import madx.entity.JavaLineNumPO;
import madx.entity.Result;
import madx.entity.UserPO;
import madx.service.CommonJdbcService;
import madx.service.CountJavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 统计java行数以及java文件地址等
 * Created by A-mdx on 2016/11/24.
 */
@Service
public class CountJavaServiceImpl implements CountJavaService{
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private JavaFilePathDao pathDao;
    
    @Autowired
    private JavaLineNumDao numDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private CommonJdbcService commonJdbcService;
    
    @Override
    @Transactional
    public Result count(ServletRequest request) {
        Result result = new Result();
        
        String userid_str = request.getParameter("userid");
        
        if (StringUtils.isEmpty(userid_str)){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 userid 这个参数");
            return result;
        }

        Integer userid = Integer.valueOf(userid_str); 
        
        UserPO userPO = userDao.findOne(userid);
        
        // 取最近的一条
        JavaLineNumPO lastnumPO = numDao.findOne(numDao.count());
        
        int java_file = 0;
        int java_line = 0;
        
        List<JavaFilePathPO> pathPOs = pathDao.findByuserId(userid);
        for (JavaFilePathPO pathPO : pathPOs){
            Map<String,Integer> map = countNum(pathPO);
            // 如果是  ，代表大文件目录，可以统计进总数据中
            if (pathPO.getIsBigPath() == Common.JAVA_FILE_PATH_BIG){
                java_file += map.get("java_file");
                java_line += map.get("java_line");
            }
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("java_file",java_file);
        map.put("java_line",java_line);
        int line_than = java_line - lastnumPO.getLineNum();
        int num_than = java_file - lastnumPO.getFileNum();
        map.put("line_than",0);
        map.put("num_than",num_than);
        
        // 如果跟上次数据相同，并且日期是是当天的,就不要存了。
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        String logDay = sdf.format(lastnumPO.getCreationTime());
        if (line_than != 0 || !today.equals(logDay)){
            JavaLineNumPO newNumPo = new JavaLineNumPO();
            newNumPo.setCreationTime(date);
            newNumPo.setCreator(1);
            newNumPo.setFileNum(java_file);
            newNumPo.setLineNum(java_line);
            newNumPo.setLineThanProvious(line_than);
            newNumPo.setNumThanProvious(num_than);
            
            userPO.setModifier(1);
            userPO.setModifyTime(date);
            userPO.setJavaFile(java_file);
            userPO.setJavaLine(java_line);
            
            numDao.save(newNumPo);
            userDao.save(userPO);
        }
        
        logger.error("你妹啊。");
        logger.info("hhhhhhh");
        logger.debug("debug....");
        
        result.setData(map);
        result.setCode(Result.RESULT_SUCCESS);
        result.setMsg("ok");
        return result;
    }

    @Transactional
    private Map<String,Integer> countNum(JavaFilePathPO pathPO){
        Map<String,Integer> map = new HashMap<>();
        List<String> files = new ArrayList<>();
        queryAllDir(pathPO.getPath(),files);
        int lines = 0;
        for (String fileDir : files){
            try {
                lines += readLine(fileDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        map.put("java_file",files.size());
        map.put("java_line",lines);

        pathPO.setModifier(1);
        pathPO.setModifyTime(new Date());
        pathPO.setNowLine(lines);
        pathPO.setNowNum(files.size());
        
        pathDao.save(pathPO);
        
        return map;
    }
    
    @Override
    public Result addPath(ServletRequest request) {
        Result result = new Result();

        String userid_str = request.getParameter("userid");

        if (StringUtils.isEmpty(userid_str)){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 userid 这个参数");
            return result;
        }
        
        String path = request.getParameter("path");

        Integer userid = Integer.valueOf(userid_str);

        UserPO userPO = userDao.findOne(userid);
        
        //TODO wait for your web...
        
        return result;
    }

    @Override
    public Result removePath(Integer id) {
        return null;
    }

    @Override
    public Result queryCountList(Map<String,Object> param) {
        Result result = new Result();
        
        Object userid = param.get("userid");
        if (userid == null || "".equals(userid.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("param userid is null!");
            return result;
        }
        
        UserPO user = userDao.findOne(Integer.valueOf(param.get("userid")+""));
        if (user == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("user id is not exist!");
            return result;
        }
        
        result.setMsg("ok");
        result.setData(commonJdbcService.query(JdbcCommonEnum.JAVA_LINE_LIST,param));
        result.setCode(Result.RESULT_SUCCESS);
        
        return result;
    }

    @Override
    public Result queryPathList(Map<String,Object> param) {
        Result result = new Result();

        Object userid = param.get("userid");
        if (userid == null || "".equals(userid.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("param userid is null!");
            return result;
        }

        UserPO user = userDao.findOne(Integer.valueOf(param.get("userid")+""));
        if (user == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("user id is not exist!");
            return result;
        }

        result.setMsg("ok");
        result.setData(commonJdbcService.query(JdbcCommonEnum.JAVA_FILE_LIST,param));
        result.setCode(Result.RESULT_SUCCESS);
        
        return result;
    }

    // 统计文件的行数
    private int readLine(String filePath) throws IOException {
        BufferedReader reader = null;
        int line = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            while (reader.readLine() != null){
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("读取文件出错",e);
            throw e;
        }finally {
            reader.close();
        }
        return line; 
    }
    
    // 递归遍历地址
    private void queryAllDir(String path,List<String> filePaths){
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files){
            if (f.isDirectory()){
                queryAllDir(f.getPath(),filePaths);
            }else{
                String fName = f.getAbsolutePath();
                if (fName.endsWith(".java")){
                    filePaths.add(fName);
                }
            }
        }
        
    }

    public static void main(String[] args) {
        CountJavaServiceImpl im = new CountJavaServiceImpl();
        List<String> filePaths = new ArrayList<>();
        im.queryAllDir("C:\\Users\\A-mdx\\Desktop\\java学习\\java_learn",filePaths);
        System.out.println("files --> "+filePaths);

        int lines = 0;
        for (String fileDir : filePaths){
            try {
                int line = im.readLine(fileDir);
                lines += line;
                System.out.println(fileDir+" --> "+line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("size : "+filePaths.size());
        System.out.println("line : "+lines);
        
    }
    
}
