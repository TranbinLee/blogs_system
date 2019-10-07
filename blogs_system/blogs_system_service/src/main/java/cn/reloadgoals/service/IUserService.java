package cn.reloadgoals.service;

import cn.reloadgoals.common.service.IBaseService;
import cn.reloadgoals.common.vo.ResponseBean;
import cn.reloadgoals.model.model.UserBean;

import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/3
 */
public interface IUserService extends IBaseService<UserBean> {
    List<UserBean> findAllUsers();

    ResponseBean addUser(UserBean userBean) throws Exception;
}
