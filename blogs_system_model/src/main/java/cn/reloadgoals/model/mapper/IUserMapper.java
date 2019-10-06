package cn.reloadgoals.model.mapper;

import cn.reloadgoals.common.mapper.IBaseMapper;
import cn.reloadgoals.model.model.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/3
 */
@Mapper
public interface IUserMapper extends IBaseMapper<UserBean> {

    @Select("select * from T_USER")
    List<UserBean> selectUsers();
}
