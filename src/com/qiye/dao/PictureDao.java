package com.qiye.dao;

import java.util.List;

import com.qiye.entity.Picture;


public interface PictureDao extends BaseDao<Picture, Integer>{
	public List<Picture> listbynum(int num,String sort);
}
