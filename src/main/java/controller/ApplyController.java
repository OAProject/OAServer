package controller;

import java.util.*;
import javax.annotation.Resource;
import model.ApplyModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.ApplyServerImp;

@Controller
public class ApplyController {
    /*
     * ResponseBody:调用commitApply，会调用commitApplyFor方法
     * RequestParam：网络请求调用到这的参数
     * RequestMapping：定义地址路径和网路请求方式
     */
    @Resource(name = "applyServerImpid")
    private ApplyServerImp applyServerImp;
    @RequestMapping(value = "/commitApply" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> commitApplyFor(@RequestParam Map<String,Object> mapApply) {

        int userid = Integer.parseInt(mapApply.get(ControllerConfig.userid).toString());
        int auditid = Integer.parseInt(mapApply.get(ControllerConfig.auditid).toString());
        int receiverid = Integer.parseInt(mapApply.get(ControllerConfig.receiverid).toString());
        Map<String, Object> map = applyServerImp.insertApplyServer(
                userid,
                mapApply.get(ControllerConfig.applyState).toString(),
                mapApply.get(ControllerConfig.type).toString(),
                mapApply.get(ControllerConfig.state_).toString(),
                mapApply.get(ControllerConfig.name).toString(),
                auditid,
                mapApply.get(ControllerConfig.auditName).toString(),
                mapApply.get(ControllerConfig.commitTime).toString(),
                mapApply.get(ControllerConfig.beginTime).toString(),
                mapApply.get(ControllerConfig.endTime).toString(),
                mapApply.get(ControllerConfig.reason).toString(),
                mapApply.get(ControllerConfig.interval).toString(),
                receiverid,
                mapApply.get(ControllerConfig.receiverName).toString(),
                mapApply.get(ControllerConfig.applyCode).toString()
        );

        return map;
    }
    @RequestMapping(value = "/updateApply",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> updateApplyFor(@RequestParam Map<String,Object> mapApply){
        new HashMap<String, Object>();
        int userid = Integer.parseInt(mapApply.get(ControllerConfig.userid).toString());
        int auditid = Integer.parseInt(mapApply.get(ControllerConfig.auditid).toString());
        int receiverid = Integer.parseInt(mapApply.get(ControllerConfig.receiverid).toString());
        Map<String, Object> map = applyServerImp.updateApplyServer(
                userid,
                mapApply.get(ControllerConfig.applyState).toString(),
                mapApply.get(ControllerConfig.type).toString(),
                mapApply.get(ControllerConfig.state_).toString(),
                mapApply.get(ControllerConfig.name).toString(),
                auditid,
                mapApply.get(ControllerConfig.auditName).toString(),
                mapApply.get(ControllerConfig.commitTime).toString(),
                mapApply.get(ControllerConfig.beginTime).toString(),
                mapApply.get(ControllerConfig.endTime).toString(),
                mapApply.get(ControllerConfig.reason).toString(),
                mapApply.get(ControllerConfig.interval).toString(),
                receiverid,
                mapApply.get(ControllerConfig.receiverName).toString(),
                mapApply.get(ControllerConfig.applyCode).toString()
        );

        return map;
    }

    @RequestMapping(value = "/getApply",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getApplyFor(@RequestParam Map<String ,Object> mapApply){

        Map<String,Object> map = new HashMap<String, Object>();

        List<ApplyModel> listApply = new ArrayList<ApplyModel>();



        int userid = 0;
        if (getMapFor(mapApply,ControllerConfig.userid) != null)
        {
            userid =  Integer.parseInt(getMapFor(mapApply,ControllerConfig.userid));
        }
        int auditid = 0;
        if (getMapFor(mapApply,ControllerConfig.auditid) != null)
        {
            auditid =  Integer.parseInt(getMapFor(mapApply,ControllerConfig.auditid));
        }
        int receiverid = 0;
        if (getMapFor(mapApply,ControllerConfig.receiverid) != null)
        {
            receiverid =  Integer.parseInt(getMapFor(mapApply,ControllerConfig.receiverid));
        }

        String state = getMapFor(mapApply,ControllerConfig.state_);
        String applyState = getMapFor(mapApply,ControllerConfig.applyState);
        String commitTime = getMapFor(mapApply,ControllerConfig.commitTime);
        String beginTime = getMapFor(mapApply,ControllerConfig.beginTime);
        String endTime = getMapFor(mapApply,ControllerConfig.endTime);




        String applyCode = getMapFor(mapApply,ControllerConfig.applyCode);

        listApply = applyServerImp.getSelectApplyServer(userid,applyState,state,auditid,commitTime,beginTime,endTime,receiverid,
                applyCode);
        map.put(ControllerConfig.data,listApply);
        if (listApply.size()>0)
        {
            map.put(ControllerConfig.code,"200");
            map.put(ControllerConfig.mas,"查询成功");
        }
        else
        {
            map.put(ControllerConfig.code,"400");
            map.put(ControllerConfig.mas,"暂无数据");

        }
        return map;

    }

    private String getMapFor(Map<String,Object> map,String keys)
    {
        String result = null;
        if (map.get(keys) != null)
        {
          return  map.get(keys).toString();
        }

        return result;
    }

}
