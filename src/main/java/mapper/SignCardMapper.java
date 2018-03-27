package mapper;

import org.apache.ibatis.annotations.Param;

public interface SignCardMapper {
    public void insertCardRecord(@Param("userid") int userid,
                                 @Param("years") String years,
                                 @Param("months") String  months,
                                 @Param("days") String days,
                                 @Param("time") String time,
                                 @Param("state") int state,
                                 @Param("limits") String limits,
                                 @Param("location") String location,
                                 @Param("signType") int signType);




}
