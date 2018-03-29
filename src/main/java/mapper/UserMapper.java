package mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import java.util.Map;
import model.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

public List<UserInfo> selectUserMapper(@Param("name") String name);

public List<UserInfo> selectUserMapperForLogin(@Param("name") String name,@Param("pwd") String pwd);

public boolean insertUser(@Param("name") String name,
                       @Param("pwd") String pwd,
                       @Param("sex") String sex,
                       @Param("age") String age,
                       @Param("idCard") String idCard,
                       @Param("staffNum") String staffNum,
                       @Param("phone") String phone,
                       @Param("department") String department,
                       @Param("post") String post,
                       @Param("headImagePatch") String headImagePatch,
                       @Param("telephone") String telephone,
                       @Param("mail") String mail,
                       @Param("bossName") String bossName,
                       @Param("bossid") int bossid);

public boolean updateUser(@Param("id") int id,
                          @Param("name") String name,
                          @Param("pwd") String pwd,
                          @Param("sex") String sex,
                          @Param("age") String age,
                          @Param("idCard") String idCard,
                          @Param("staffNum") String staffNum,
                          @Param("phone") String phone,
                          @Param("department") String department,
                          @Param("post") String post,
                          @Param("headImagePatch") String headImagePatch,
                          @Param("telephone") String telephone,
                          @Param("mail") String mail,
                          @Param("bossName") String bossName,
                          @Param("bossid") int bossid);

}






