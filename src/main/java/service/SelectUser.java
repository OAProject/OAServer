package service;

import java.util.List;
import java.util.Map;
import model.UserInfo;

public interface SelectUser {
    public List<UserInfo>selectUser(String name);
    public Map<String, Object> selectForDoLogin(String name, String pwd);

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
                                                   int bossid);
}
