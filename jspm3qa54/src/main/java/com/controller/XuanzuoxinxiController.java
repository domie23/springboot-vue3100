package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XuanzuoxinxiEntity;
import com.entity.view.XuanzuoxinxiView;

import com.service.XuanzuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 选座信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
@RestController
@RequestMapping("/xuanzuoxinxi")
public class XuanzuoxinxiController {
    @Autowired
    private XuanzuoxinxiService xuanzuoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuanzuoxinxiEntity xuanzuoxinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yuyueshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yuyueshijianend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xuanzuoxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuanzuoxinxiEntity> ew = new EntityWrapper<XuanzuoxinxiEntity>();
                if(yuyueshijianstart!=null) ew.ge("yuyueshijian", yuyueshijianstart);
                if(yuyueshijianend!=null) ew.le("yuyueshijian", yuyueshijianend);
    	PageUtils page = xuanzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanzuoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuanzuoxinxiEntity xuanzuoxinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yuyueshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yuyueshijianend,
		HttpServletRequest request){
        EntityWrapper<XuanzuoxinxiEntity> ew = new EntityWrapper<XuanzuoxinxiEntity>();
                if(yuyueshijianstart!=null) ew.ge("yuyueshijian", yuyueshijianstart);
                if(yuyueshijianend!=null) ew.le("yuyueshijian", yuyueshijianend);
    	PageUtils page = xuanzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanzuoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuanzuoxinxiEntity xuanzuoxinxi){
       	EntityWrapper<XuanzuoxinxiEntity> ew = new EntityWrapper<XuanzuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuanzuoxinxi, "xuanzuoxinxi")); 
        return R.ok().put("data", xuanzuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuanzuoxinxiEntity xuanzuoxinxi){
        EntityWrapper< XuanzuoxinxiEntity> ew = new EntityWrapper< XuanzuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuanzuoxinxi, "xuanzuoxinxi")); 
		XuanzuoxinxiView xuanzuoxinxiView =  xuanzuoxinxiService.selectView(ew);
		return R.ok("查询选座信息成功").put("data", xuanzuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuanzuoxinxiEntity xuanzuoxinxi = xuanzuoxinxiService.selectById(id);
        return R.ok().put("data", xuanzuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuanzuoxinxiEntity xuanzuoxinxi = xuanzuoxinxiService.selectById(id);
        return R.ok().put("data", xuanzuoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XuanzuoxinxiEntity xuanzuoxinxi = xuanzuoxinxiService.selectById(id);
        if(type.equals("1")) {
        	xuanzuoxinxi.setThumbsupnum(xuanzuoxinxi.getThumbsupnum()+1);
        } else {
        	xuanzuoxinxi.setCrazilynum(xuanzuoxinxi.getCrazilynum()+1);
        }
        xuanzuoxinxiService.updateById(xuanzuoxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuanzuoxinxiEntity xuanzuoxinxi, HttpServletRequest request){
    	xuanzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuanzuoxinxi);

        xuanzuoxinxiService.insert(xuanzuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuanzuoxinxiEntity xuanzuoxinxi, HttpServletRequest request){
    	xuanzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuanzuoxinxi);

        xuanzuoxinxiService.insert(xuanzuoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XuanzuoxinxiEntity xuanzuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuanzuoxinxi);
        xuanzuoxinxiService.updateById(xuanzuoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuanzuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XuanzuoxinxiEntity> wrapper = new EntityWrapper<XuanzuoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = xuanzuoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
