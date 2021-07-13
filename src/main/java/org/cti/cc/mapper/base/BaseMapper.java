package org.cti.cc.mapper.base;

import java.util.List;
import java.util.Map;


public interface BaseMapper<T> {

    /**
     * 查询总数
     *
     * @param params
     * @return
     */
    Long selectCountByMap(Map<String, Object> params);

    /**
     * 分页
     *
     * @param params
     * @return
     */
    List<T> selectListByMap(Map<String, Object> params);


    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);


    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
}
