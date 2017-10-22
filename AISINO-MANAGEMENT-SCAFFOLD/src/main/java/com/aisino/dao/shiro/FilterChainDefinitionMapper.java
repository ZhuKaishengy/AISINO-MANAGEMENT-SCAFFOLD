package com.aisino.dao.shiro;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aisino.domain.shiro.FilterChainDefinition;
import com.aisino.domain.shiro.FilterChainDefinitionExample;

public interface FilterChainDefinitionMapper {
    int countByExample(FilterChainDefinitionExample example);

    int deleteByExample(FilterChainDefinitionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FilterChainDefinition record);

    int insertSelective(FilterChainDefinition record);

    List<FilterChainDefinition> selectByExample(FilterChainDefinitionExample example);

    FilterChainDefinition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FilterChainDefinition record, @Param("example") FilterChainDefinitionExample example);

    int updateByExample(@Param("record") FilterChainDefinition record, @Param("example") FilterChainDefinitionExample example);

    int updateByPrimaryKeySelective(FilterChainDefinition record);

    int updateByPrimaryKey(FilterChainDefinition record);
    
    List<FilterChainDefinition> selectAllOrderByIdDesc();
}