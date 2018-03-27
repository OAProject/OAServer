package controller;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.CardRecordImp;


@Controller
public class CardRecord {

    /**
     *签卡
     * CardRecordid就是@service的id，必须一致
     */
    @Resource(name = "CardRecordid")
    private CardRecordImp cardRecordImp;

    @RequestMapping(value = "/CardRecord",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> timeCardRecord(@RequestParam Map<String,Object> mapTimeCard)
    {
        Map<String, Object> map_ = new HashMap<String, Object>();

        int userid = Integer.parseInt(mapTimeCard.get(ControllerConfig.userid).toString());
        int state = Integer.parseInt(mapTimeCard.get(ControllerConfig.state_).toString());
        String limits = mapTimeCard.get(ControllerConfig.limits).toString();
        String location = mapTimeCard.get(ControllerConfig.location).toString();
        int signType = Integer.parseInt(mapTimeCard.get(ControllerConfig.signType).toString());

        cardRecordImp.insertTimeCrad(userid,state,limits,location,signType);
        map_.put(ControllerConfig.mas,"已签到");
        return map_;
    }

}
