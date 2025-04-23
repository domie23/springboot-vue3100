package com.dao;

import com.entity.TushuguanzuoweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushuguanzuoweiVO;
import com.entity.view.TushuguanzuoweiView;


/**
 * 图书馆座位
 * 
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
public interface TushuguanzuoweiDao extends BaseMapper<TushuguanzuoweiEntity> {
	
	List<TushuguanzuoweiVO> selectListVO(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
	
	TushuguanzuoweiVO selectVO(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
	
	List<TushuguanzuoweiView> selectListView(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);

	List<TushuguanzuoweiView> selectListView(Pagination page,@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
	
	TushuguanzuoweiView selectView(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
	

}
