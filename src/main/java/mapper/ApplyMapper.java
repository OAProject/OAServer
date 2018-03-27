package mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.List;
import model.ApplyModel;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {

    public Bool intsertApply(@Param("userid") int userid,
                             @Param("applyState") String applyState,
                             @Param("type") String type,
                             @Param("state") String state,
                             @Param("name") String name,
                             @Param("auditid") int auditid,
                             @Param("auditName") String auditName,
                             @Param("commitTime") String commitTime,
                             @Param("beginTime") String beginTime,
                             @Param("endTime") String endTime,
                             @Param("reason") String reason,
                             @Param("interval") String interval,
                             @Param("receiverid") int receiverid,
                             @Param("receiverName") String receiverName,
                             @Param("applyCode") String applyCode);


    public Bool updateApply(@Param("userid") int userid,
                           @Param("applyState") String applyState,
                           @Param("type") String type,
                           @Param("state") String state,
                           @Param("name") String name,
                           @Param("auditid") int auditid,
                           @Param("auditName") String auditName,
                           @Param("commitTime") String commitTime,
                           @Param("beginTime") String beginTime,
                           @Param("endTime") String endTime,
                           @Param("reason") String reason,
                           @Param("interval") String interval,
                           @Param("receiverid") int receiverid,
                           @Param("receiverName") String receiverName,
                           @Param("applyCode") String applyCode);



    public List<ApplyModel> selectApply(@Param("userid") int userid,
                                        @Param("applyState") String applyState,
                                        @Param("state") String state,
                                        @Param("auditid") int auditid,
                                        @Param("commitTime") String commitTime,
                                        @Param("beginTime") String beginTime,
                                        @Param("endTime") String endTime,
                                        @Param("receiverid") int receiverid,
                                        @Param("applyCode") String applyCode);






}
