package controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.serviceimp.SelectUserImp;


@Controller
public class Login {

    @Resource(name = "selectUserid")
    private SelectUserImp selectuserimp;


    /**
     * 登录
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String login() {
        int i = 1;
        i++;
        System.out.println("i=" + i);
        return "hhhhh";
    }
     */
    /**
     * 检测用户是否存在
     */
    @RequestMapping(value = "/doLogin", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody//使用这个注解可以让接口在app端访问，而不是在网页中访问
    public Map<String, Object> getLoginUser(@RequestParam Map<String,Object> mapApply) {

        String userName = mapApply.get(ControllerConfig.name).toString();
        String password = mapApply.get(ControllerConfig.password).toString();
        Map<String, Object> map = selectuserimp.selectForDoLogin(userName, password);
        return map; //封装为json返回给客户端

    }


    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> userResgister(@RequestParam Map<String, Object> mapRes) {

        int bossid = Integer.parseInt(mapRes.get(ControllerConfig.bossid).toString());
        Map<String, Object> map_ = selectuserimp.insertUserForRegist(
                mapRes.get(ControllerConfig.name).toString(),
                mapRes.get
                        (ControllerConfig.password).toString(),
                mapRes.get(ControllerConfig.sex).toString(),
                mapRes.get(ControllerConfig.age).toString(),
                mapRes.get(ControllerConfig.idcard).toString(),
                mapRes.get(ControllerConfig.staffNum).toString(),
                mapRes.get(ControllerConfig.phone).toString(),
                mapRes.get(ControllerConfig.department).toString(),
                mapRes.get(ControllerConfig.post).toString(),
                mapRes.get(ControllerConfig.headImagePatch).toString(),
                mapRes.get(ControllerConfig.telephone).toString(),
                mapRes.get(ControllerConfig.mail).toString(),
                mapRes.get(ControllerConfig.bossName).toString(),
                bossid
        );
        return map_;

    }


    /*
    修改用户信息
     */
    @RequestMapping(value = "/updateUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> updateUserInfo(@RequestParam Map<String,Object> mapRes)
    {

        int bossid = Integer.parseInt(mapRes.get(ControllerConfig.bossid).toString());
        int userid = Integer.parseInt(mapRes.get(ControllerConfig.id).toString());
        Map<String, Object> map_ = selectuserimp.updateUser(
                userid,
                mapRes.get(ControllerConfig.name).toString(),
                mapRes.get
                        (ControllerConfig.password).toString(),
                mapRes.get(ControllerConfig.sex).toString(),
                mapRes.get(ControllerConfig.age).toString(),
                mapRes.get(ControllerConfig.idcard).toString(),
                mapRes.get(ControllerConfig.staffNum).toString(),
                mapRes.get(ControllerConfig.phone).toString(),
                mapRes.get(ControllerConfig.department).toString(),
                mapRes.get(ControllerConfig.post).toString(),
                mapRes.get(ControllerConfig.headImagePatch).toString(),
                mapRes.get(ControllerConfig.telephone).toString(),
                mapRes.get(ControllerConfig.mail).toString(),
                mapRes.get(ControllerConfig.bossName).toString(),
                bossid
        );
        return map_;
    }

}
