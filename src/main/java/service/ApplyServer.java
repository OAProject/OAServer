package service;

import java.util.List;
import java.util.Map;
import model.ApplyModel;

public interface ApplyServer {
    public Map<String, Object> insertApplyServer(int userid,
                                                 String applyState,
                                                 String type,
                                                 String state,
                                                 String name,
                                                 int auditid,
                                                 String auditName,
                                                 String commitTime,
                                                 String beginTime,
                                                 String endTime,
                                                 String reason,
                                                 String interval,
                                                 int receiverid,
                                                 String receiverName,
                                                 String applyCode);
    public Map<String, Object> updateApplyServer(int userid,
                                     String applyState,
                                     String type,
                                     String state,
                                     String name,
                                     int auditid,
                                     String auditName,
                                     String commitTime,
                                     String beginTime,
                                     String endTime,
                                     String reason,
                                     String interval,
                                     int receiverid,
                                     String receiverName,
                                     String applyCode);

    public List<ApplyModel> getSelectApplyServer(int userid,
                                                 String applyState,
                                                 String state,
                                                 int auditid,
                                                 String commitTime,
                                                 String beginTime,
                                                 String endTime,
                                                 int receiverid,
                                                 String applyCode);
    
}
