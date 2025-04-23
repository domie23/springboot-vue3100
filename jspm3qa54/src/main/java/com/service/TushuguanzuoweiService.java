package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushuguanzuoweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TushuguanzuoweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TushuguanzuoweiView;


/**
 * 图书馆座位
 *
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
public interface TushuguanzuoweiService extends IService<TushuguanzuoweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuguanzuoweiVO> selectListVO(Wrapper<TushuguanzuoweiEntity> wrapper);
   	
   	TushuguanzuoweiVO selectVO(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
   	
   	List<TushuguanzuoweiView> selectListView(Wrapper<TushuguanzuoweiEntity> wrapper);
   	
   	TushuguanzuoweiView selectView(@Param("ew") Wrapper<TushuguanzuoweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuguanzuoweiEntity> wrapper);
   	

}

