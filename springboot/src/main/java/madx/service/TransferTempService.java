package madx.service;

import madx.dao.JavaLineNumDao;
import madx.dao.LineDayOldDao;
import madx.entity.JavaLineNumPO;
import madx.entity.LineDayOldPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 临时，将以前的一部分数据存入
 * Created by A-mdx on 2016/11/26.
 */
@Service
public class TransferTempService {
    
    @Autowired
    private LineDayOldDao lineDayOldDao;
    
    @Autowired
    private JavaLineNumDao javaLineNumDao;
    
    public void transDate(){
        List<LineDayOldPO> oldPOs = lineDayOldDao.findAll();
        for (int i = 0;i<oldPOs.size();i++){
            LineDayOldPO old = oldPOs.get(i);
            JavaLineNumPO lnew = new JavaLineNumPO();
            
            lnew.setCreationTime(old.getCreateTime());
            lnew.setFileNum(old.getJavaFileNum());
            lnew.setLineNum(old.getJavaLine());
            lnew.setLineThanProvious(old.getIncreaseLine());
            lnew.setNumThanProvious(old.getIncreaseFile());
            
            lnew.setCreator(2);
            System.out.println("create -- > "+lnew);
            save(lnew);
        }
    }
    
    @Transactional
    public void save(JavaLineNumPO po){
        try {
            javaLineNumDao.save(po);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
