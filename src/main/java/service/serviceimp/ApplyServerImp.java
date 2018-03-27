package service.serviceimp;

import com.sun.org.apache.xpath.internal.operations.Bool;
import controller.ControllerConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapper.ApplyMapper;
import model.ApplyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("applyServerImpid")
public class ApplyServerImp {

    @Autowired
    private ApplyMapper applyMapper;
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
                                  String applyCode)
    {
        Bool success = applyMapper.intsertApply(userid,applyState,type,state,name,auditid,auditName,commitTime,beginTime,
                 endTime,
            reason,
            interval,receiverid,receiverName,applyCode);

        Map<String, Object> map = new HashMap<String, Object>();

        if (success == true)
        {
            map.put(ControllerConfig.code,"200");
            map.put(ControllerConfig.mas,"申请成功");
        }
        else
        {
            map.put(ControllerConfig.code,"400");
            map.put(ControllerConfig.mas,"申请失败");
        }
       return map;
    }

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
                                     String applyCode)
    {
        Bool success = applyMapper.updateApply(userid,applyState,type,state,name,auditid,
                auditName,commitTime,beginTime,endTime,reason,
                interval,receiverid,receiverName,applyCode);

        Map<String, Object> map = new HashMap<String, Object>();

        if (success == true)
        {
            map.put(ControllerConfig.code,"200");
            map.put(ControllerConfig.mas,"更改申请成功");
        }
        else
        {
            map.put(ControllerConfig.code,"400");
            map.put(ControllerConfig.mas,"更改申请失败");
        }
        return map;

    }

    public List<ApplyModel> getSelectApplyServer(int userid,
                                                 String applyState,
                                                 String state,
                                                 int auditid,
                                                 String commitTime,
                                                 String beginTime,
                                                 String endTime,
                                                 int receiverid,
                                                 String applyCode)
    {
        List<ApplyModel> listApply = new ArrayList<ApplyModel>();
        listApply = applyMapper.selectApply(userid,applyState,state,auditid,commitTime,beginTime,endTime,receiverid,applyCode);
        return listApply;
    }
}
