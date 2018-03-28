package service.serviceimp;

import com.sun.org.apache.xpath.internal.operations.Bool;
import controller.ControllerConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapper.UserMapper;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SelectUser;

@Service("selectUserid")
public class SelectUserImp implements SelectUser {

    @Autowired
    private UserMapper testmap;
    //    检测用户是否存在
    public List<UserInfo>selectUser(String name)
    {
        return testmap.selectUserMapper(name);
    }
    //  登录接口
    public Map<String, Object> selectForDoLogin(String name, String pwd) {
        Map<String,Object> map = new HashMap<String, Object>();

        if (pwd == "" || pwd == null)
        {
            map.put(ControllerConfig.code, 0);
            map.put(ControllerConfig.mas, "密码不正确");
            return map;
        }
        if (name == "" || name == null)
        {
            map.put(ControllerConfig.code, 0);
            map.put(ControllerConfig.mas, "用户名为空");
            return map;
        }


        List<UserInfo> listModelName = selectUser(name);
        if (listModelName.size() < 1)
        {
            map.put(ControllerConfig.code, 0);
            map.put(ControllerConfig.mas, "用户不存在");
            return map;

        }
        List<UserInfo> listmodel = testmap.selectUserMapperForLogin(name,pwd);
        if (listmodel.size() >= 1)
        {
            UserInfo userinfo = listmodel.get(0);
            map.put(ControllerConfig.code, 1);
            map.put(ControllerConfig.mas, "登录成功");
            map.put(ControllerConfig.data, userinfo);
            return map;
        }
        else
        {
            map.put(ControllerConfig.code, "0");
            map.put(ControllerConfig.mas, "密码错误");
            return map;
        }

    }
    //  注册接口
    public Map<String, Object> insertUserForRegist(String name,
                                                   String pwd,
                                                   String sex,
                                                   String age,
                                                   String idCard,
                                                   String staffNum,
                                                   String phone,
                                                   String department,
                                                   String post,
                                                   String headImagePatch,
                                                   String telephone,
                                                   String mail,
                                                   String bossName,
                                                   int bossid)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        List<UserInfo> listModelName = selectUser(name);
        if (listModelName.size() <= 1)
        {
           Bool type = testmap.insertUser(name,pwd,sex,age,idCard,staffNum,phone,department,post,headImagePatch,
                telephone,mail,
                    bossName,bossid);
            map.put(ControllerConfig.code, type);
            map.put(ControllerConfig.mas, "用户存入成功");
            return map;
        }
        else
        {
            map.put(ControllerConfig.code, 0);
            map.put(ControllerConfig.mas, "用户已存在");
            return map;

        }

    }

}
