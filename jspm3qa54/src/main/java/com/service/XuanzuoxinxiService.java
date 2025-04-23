package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuanzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuanzuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanzuoxinxiView;


/**
 * 选座信息
 *
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
public interface XuanzuoxinxiService extends IService<XuanzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuanzuoxinxiVO> selectListVO(Wrapper<XuanzuoxinxiEntity> wrapper);
   	
   	XuanzuoxinxiVO selectVO(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
   	
   	List<XuanzuoxinxiView> selectListView(Wrapper<XuanzuoxinxiEntity> wrapper);
   	
   	XuanzuoxinxiView selectView(@Param("ew") Wrapper<XuanzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuanzuoxinxiEntity> wrapper);
   	

}

