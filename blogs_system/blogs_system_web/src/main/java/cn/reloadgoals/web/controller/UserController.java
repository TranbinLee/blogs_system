package cn.reloadgoals.web.controller;

import cn.reloadgoals.common.constants.SystemConstants;
import cn.reloadgoals.common.controller.CommonController;
import cn.reloadgoals.common.vo.ResponseBean;
import cn.reloadgoals.model.model.UserBean;
import cn.reloadgoals.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/3
 */
@RestController
@RequestMapping("user")
public class UserController extends CommonController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("allUsers")
    public ResponseBean allUsers(){
       List<UserBean> list  = iUserService.findAllUsers();
       if(!CollectionUtils.isEmpty(list)){
           return new ResponseBean(SystemConstants.RESPONSE_SUCCESS,"success","查询成功!",list);
       }else{
           return new ResponseBean(SystemConstants.RESPONSE_FAIL,"fail","查询失败！");
       }
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("addUser")
    public ResponseBean addUser(UserBean userBean) throws Exception{
        return  iUserService.addUser(userBean);
    }
}
