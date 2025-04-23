package com.entity.view;

import com.entity.TushuguanzuoweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 图书馆座位
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-03 23:42:15
 */
@TableName("tushuguanzuowei")
public class TushuguanzuoweiView  extends TushuguanzuoweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushuguanzuoweiView(){
	}
 
 	public TushuguanzuoweiView(TushuguanzuoweiEntity tushuguanzuoweiEntity){
 	try {
			BeanUtils.copyProperties(this, tushuguanzuoweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
