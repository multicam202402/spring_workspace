package com.sds.mall.product.model;

import java.util.List;

import com.sds.mall.domain.TopCategory;

public interface TopCategoryService {
	public List selectAll();
	public TopCategory select(int topcategory_idx);
	
}
