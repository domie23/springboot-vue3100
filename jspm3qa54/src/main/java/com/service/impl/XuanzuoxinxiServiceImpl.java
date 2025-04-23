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


import com.dao.XuanzuoxinxiDao;
import com.entity.XuanzuoxinxiEntity;
import com.service.XuanzuoxinxiService;
import com.entity.vo.XuanzuoxinxiVO;
import com.entity.view.XuanzuoxinxiView;

@Service("xuanzuoxinxiService")
public class XuanzuoxinxiServiceImpl extends ServiceImpl<XuanzuoxinxiDao, XuanzuoxinxiEntity> implements XuanzuoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuanzuoxinxiEntity> page = this.selectPage(
                new Query<XuanzuoxinxiEntity>(params).getPage(),
                new EntityWrapper<XuanzuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuanzuoxinxiEntity> wrapper) {
		  Page<XuanzuoxinxiView> page =new Query<XuanzuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuanzuoxinxiVO> selectListVO(Wrapper<XuanzuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuanzuoxinxiVO selectVO(Wrapper<XuanzuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuanzuoxinxiView> selectListView(Wrapper<XuanzuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuanzuoxinxiView selectView(Wrapper<XuanzuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
