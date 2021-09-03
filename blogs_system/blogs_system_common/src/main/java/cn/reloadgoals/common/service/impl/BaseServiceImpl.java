package cn.reloadgoals.common.service.impl;

import cn.reloadgoals.common.constants.SystemConstants;
import cn.reloadgoals.common.mapper.IBaseMapper;
import cn.reloadgoals.common.service.IBaseService;
import cn.reloadgoals.common.util.BooleanUtils;
import cn.reloadgoals.common.util.SnowFlake;
import cn.reloadgoals.common.vo.ResponseBean;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author TranbinLee
 * @date 2019/10/4
 */
@Scope("prototype")
public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    protected IBaseMapper<T> mapper;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int save(T entity) throws Exception  {
        return mapper.insert(entity);
    }

    @Override
    public void batchInsert(List list) throws Exception {

    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public int deleteByExample(Object example) throws Exception {
        return mapper.deleteByExample(example);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseBean<?> batchDeleteByIdArray(T entity, Iterable<?> ids) throws Exception {
        if(BooleanUtils.isNotEmpty(ids)) {
            Example example = new Example(entity.getClass());
            example.createCriteria().andIn("id", ids);
            return new ResponseBean(SystemConstants.RESPONSE_SUCCESS,"20000","批量删除成功",mapper.deleteByExample(example));
        }
        return new ResponseBean(SystemConstants.RESPONSE_FAIL,"200002","批量删除失败");
    }

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     * @param entity
     * @param example
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int updateByExampleSelective(T entity,Object example) throws Exception  {
        return mapper.updateByExampleSelective(entity, example);
    }

    /**
     * 当我们开启阿里代码扫描插件时，如果你使用了 Apache BeanUtils.copyProperties 进行属性拷贝，
     * 它会给你一个非常严重的警告。
     * 因为，Apache BeanUtils性能较差，可以使用 Spring BeanUtils 或者 Cglib BeanCopier 来代替
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseBean<?> saveOrUpdate(JSONObject json, T destEntiry) throws Exception {
        Date date = new Date();
        T entity = (T) JSONObject.toJavaObject(json,destEntiry.getClass());
        String id = BeanUtils.getProperty(entity, "id");

        BeanUtils.setProperty(entity, "updateTime", date);
        if(!StringUtils.isEmpty(id)){
            //更新
            Example example = new Example(entity.getClass());
            example.createCriteria().andEqualTo("id", id);
            this.updateByExampleSelective(entity,example);
        }else{
            BeanUtils.setProperty(entity, "id", SnowFlake.generator());
            //保存
            BeanUtils.setProperty(entity, "createTime", date);
            this.save(entity);
        }
        /* 根据id查询对象*/
        entity = this.selectByPrimaryKey(BeanUtils.getProperty(entity, "id"));
        /**由于Apache beanUtil性能问题 这里使用Spring的copy copy转换后的对象到传入的空数据对象*/
        org.springframework.beans.BeanUtils.copyProperties(entity, destEntiry);
        return new ResponseBean(SystemConstants.RESPONSE_SUCCESS,"20000","保存或更新成功");

    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseBean<?> saveOrUpdate(T entity) throws Exception {
        Date date = new Date();
        String id = BeanUtils.getProperty(entity, "id");

        BeanUtils.setProperty(entity, "updateTime", date);
        if(!StringUtils.isEmpty(id)){
            //更新
            Example example = new Example(entity.getClass());
            example.createCriteria().andEqualTo("id", id);
            this.updateByExampleSelective(entity,example);
        }else{
            BeanUtils.setProperty(entity, "id", SnowFlake.generator());
            //保存
            BeanUtils.setProperty(entity, "createTime", date);
            this.save(entity);
        }
        /* 根据id查询对象*/
        T destEntiry = this.selectByPrimaryKey(BeanUtils.getProperty(entity, "id"));
        if(BooleanUtils.isNotEmpty(destEntiry)) {
            /**由于Apache beanUtil性能问题 这里使用Spring的copy copy转换后的对象到传入的空数据对象*/
            org.springframework.beans.BeanUtils.copyProperties(entity, destEntiry);
        }
        return new ResponseBean(SystemConstants.RESPONSE_SUCCESS,"20000","保存或更新成功");
    }

    @Override
    public List<T> select(T entity){
        return mapper.select(entity);
    }

    @Override
    public T selectByPrimaryKey(Object key){
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    @Transactional(readOnly=true, propagation= Propagation.NOT_SUPPORTED)
    public T selectOne(T entity) throws Exception  {
        return mapper.selectOne(entity);
    }

    @Override
    @Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
    public List<T> selectByExample(Example example) throws Exception {
        return mapper.selectByExample(example);
    }
}
