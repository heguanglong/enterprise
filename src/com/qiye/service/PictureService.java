package com.qiye.service;

import java.util.List;

import com.qiye.entity.Picture;

public interface PictureService extends BaseService<Picture, Integer> {
	public List<Picture> listbynum(int num,String sort);
}
