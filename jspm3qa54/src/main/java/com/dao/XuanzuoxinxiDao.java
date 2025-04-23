package com.dao;

import com.entity.XuanzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuanzuoxinxiVO;
import com.entity.view.XuanzuoxinxiView;


/**
 * 选座信息
 * 
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
public interface XuanzuoxinxiDao extends BaseMapper<XuanzuoxinxiEntity> {
	
	List<XuanzuoxinxiVO> selectListVO(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
	
	XuanzuoxinxiVO selectVO(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
	
	List<XuanzuoxinxiView> selectListView(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);

	List<XuanzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
	
	XuanzuoxinxiView selectView(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
	

}
