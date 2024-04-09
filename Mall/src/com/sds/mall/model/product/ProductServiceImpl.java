package com.sds.mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.mall.domain.Product;
import com.sds.mall.model.common.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO; //db 담당
	
	@Autowired
	private FileManager fileManager; //업로드 담당 객체
	
	//등록 업무 = 파일업로드 + db insert 
	public void regist(Product product) {
		
		//파일업로드 시키기 
		fileManager.save(product);
		
		//db insert 시키기 
		productDAO.insert(product);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAllBySubIdx(int subcategory_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}
	
}
