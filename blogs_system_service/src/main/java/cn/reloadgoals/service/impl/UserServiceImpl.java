package cn.reloadgoals.service.impl;

import cn.reloadgoals.common.constants.SystemConstants;
import cn.reloadgoals.common.service.impl.BaseServiceImpl;
import cn.reloadgoals.common.vo.ResponseBean;
import cn.reloadgoals.model.mapper.IUserMapper;
import cn.reloadgoals.model.model.UserBean;
import cn.reloadgoals.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/3
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<UserBean> implements IUserService  {

    @Autowired
    private IUserMapper iUserMapper;


    @Override
    public List<UserBean> findAllUsers() {
        List<UserBean> list = iUserMapper.selectUsers();
        return list;
    }

    @Override
    public ResponseBean addUser(UserBean userBean) throws Exception{
        this.saveOrUpdate(userBean);
        return new ResponseBean(SystemConstants.RESPONSE_SUCCESS,"20000");
    }
}
