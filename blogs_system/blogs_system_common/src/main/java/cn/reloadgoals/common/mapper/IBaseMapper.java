package cn.reloadgoals.common.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author TranbinLee
 * @date 2019/10/4
 */
@RegisterMapper
public interface IBaseMapper<T> extends Mapper<T>,tk.mybatis.mapper.additional.insert.InsertListMapper<T> {

}
