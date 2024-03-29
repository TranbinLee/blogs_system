package cn.reloadgoals.common.service;

import cn.reloadgoals.common.vo.ResponseBean;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/4
 */
public interface IBaseService<T> {
    /**
     * 新增
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param entity
     * @return
     * @throws Exception
     */
    int save(T entity) throws Exception ;

    /**
     * 插入
     * 批量插入数据
     * @param list
     * @throws Exception
     */
    void batchInsert(List<T> list) throws Exception ;
    /**
     * 删除
     * 根据example条件删除数据
     * @param example
     * @return
     * @throws Exception
     */
    int deleteByExample(Object example) throws Exception ;

    @Transactional(rollbackFor=Exception.class)
    ResponseBean<?> batchDeleteByIdArray(T entity, Iterable<?> ids) throws Exception;

    /**
     * 修改
     * 根据example条件更新数据
     * @param entity
     * @param example
     * @return
     * @throws Exception
     */
    int updateByExampleSelective(T entity,Object example) throws Exception ;


    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor=Exception.class)
    ResponseBean<?> saveOrUpdate(JSONObject json, T destEntiry) throws Exception;

    @Transactional(rollbackFor=Exception.class)
    ResponseBean<?> saveOrUpdate(T entity) throws Exception;

    /**
     * 查询
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param entity
     * @return
     * @throws Exception
     */
    List<T> select(T entity) throws Exception ;

    /**
     * 查询
     * 根据主键查询数据
     * @param key
     * @return
     * @throws Exception
     */
    T selectByPrimaryKey(Object key) throws Exception ;



    /**
     * 查询
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param entity
     * @return
     * @throws Exception
     */
    T selectOne(T entity) throws Exception ;

    /**
     * 查询
     * 根据example条件查询数据
     * @param example
     * @return
     * @throws Exception
     */
    List<T> selectByExample(Example example) throws Exception ;

    //    /**
//     * 根据id数组删除数据
//     * @param claszz
//     * @param ids
//     * @return
//     * @throws Exception
//     */
//    StatusBean<?> batchDeleteByIdArray(T entity,Iterable<?> ids) throws Exception;


//    /**
//     * 保存或更新数据
//     * @param json
//     * @return
//     * @throws Exception
//     */
//    StatusBean<?> saveOrUpdate(JSONObject json, T entity) throws Exception ;
//
//    /**
//     * 保存或更新数据
//     * @return
//     * @throws Exception
//     */
//    StatusBean<?> saveOrUpdate(T entity) throws Exception ;

//    /**
//     * 分页查询
//     * @param paramMap
//     * @param clazz
//     * @return
//     * @throws Exception
//     */
//    LayUiPageVO<T> queryByPage(JSONObject json,Class<?> clazz) throws Exception ;

}
