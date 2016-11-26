package madx.service.impl;

import madx.dao.JavaFilePathDao;
import madx.dao.JavaLineNumDao;
import madx.dao.LineJdbcDao;
import madx.dao.UserDao;
import madx.entity.*;
import madx.service.CountJavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 统计java行数以及java文件地址等
 * Created by A-mdx on 2016/11/24.
 */
@Service
public class CountJavaServiceImpl implements CountJavaService{
    
    @Autowired
    private JavaFilePathDao pathDao;
    
    @Autowired
    private JavaLineNumDao numDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private LineJdbcDao lineJdbcDao;
    
    @Override
    @Transactional
    public Result count(Integer userid) {
        Result result = new Result();

        UserPO userPO = userDao.findOne(userid);
        
        // 取最近的一条
        JavaLineNumPO lastnumPO = numDao.findOne(numDao.count());
        
        int java_file = 0;
        int java_line = 0;
        
        List<JavaFilePathPO> pathPOs = pathDao.findByuserId(userid);
        for (JavaFilePathPO pathPO : pathPOs){
            Map<String,Integer> map = countNum(pathPO);
            // 如果是 9 ，代表大文件目录，可以统计进总数据中
            if (pathPO.getIsBigPath() == 9){
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
    public Result addPath(String path) {
        return null;
    }

    @Override
    public Result removePath(Integer id) {
        return null;
    }

    @Override
    public Result queryCountList(Map<String,Object> param) {
        Result result = new Result();
        UserPO user = userDao.findOne(Integer.valueOf(param.get("userid")+""));
        if (user == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("user id is not exist!");
            return result;
        }
        List<Map<String,Object>> list = lineJdbcDao.queryLineList(param,false);
        Integer size = (Integer) list.get(0).get("count");
        int totleSize = size == null ? 0 : size;
        
        PageQueryPO pageQueryPO = new PageQueryPO((Integer) param.get("pageSize"),totleSize); 
        int pageNumber = (int) param.get("pageNumber");
        if (pageNumber -1 < 0){
            pageNumber = 0;
        }else{
            pageNumber--;
        }
        pageQueryPO.setPageNumber(pageNumber+1);
        
        param.put("pageNumber",pageNumber);
        
        pageQueryPO.setContent(lineJdbcDao.queryLineList(param,true));
        
        result.setMsg("ok");
        result.setData(pageQueryPO);
        result.setCode(Result.RESULT_SUCCESS);
        
        return result;
    }

    @Override
    public Result queryPathList(Map<String,Object> param) {
        return null;
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
