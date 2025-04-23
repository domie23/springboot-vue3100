package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TushuguanzuoweiDao;
import com.entity.TushuguanzuoweiEntity;
import com.service.TushuguanzuoweiService;
import com.entity.vo.TushuguanzuoweiVO;
import com.entity.view.TushuguanzuoweiView;

@Service("tushuguanzuoweiService")
public class TushuguanzuoweiServiceImpl extends ServiceImpl<TushuguanzuoweiDao, TushuguanzuoweiEntity> implements TushuguanzuoweiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuguanzuoweiEntity> page = this.selectPage(
                new Query<TushuguanzuoweiEntity>(params).getPage(),
                new EntityWrapper<TushuguanzuoweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuguanzuoweiEntity> wrapper) {
		  Page<TushuguanzuoweiView> page =new Query<TushuguanzuoweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TushuguanzuoweiVO> selectListVO(Wrapper<TushuguanzuoweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TushuguanzuoweiVO selectVO(Wrapper<TushuguanzuoweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TushuguanzuoweiView> selectListView(Wrapper<TushuguanzuoweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuguanzuoweiView selectView(Wrapper<TushuguanzuoweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
