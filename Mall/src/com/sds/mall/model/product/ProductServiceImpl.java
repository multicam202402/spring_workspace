package com.sds.mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.mall.domain.Color;
import com.sds.mall.domain.Product;
import com.sds.mall.domain.Psize;
import com.sds.mall.exception.UploadException;
import com.sds.mall.model.common.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private FileManager fileManager; //업로드 담당 객체
	
	//db  insert (product, color, psize 세군데 넣어야 하므로 dao도 3개 보유 거느려야 한다)
	@Autowired
	private ProductDAO productDAO; //db 담당
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Autowired
	private PsizeDAO psizeDAO;
	
	
	//등록 업무 = 4가지 업무를 완료해야 전체를 성공으로 보는 트랜잭션 상황이다
	public void regist(Product product) throws UploadException{
		
		//1)파일업로드 시키기 

		fileManager.save(product); //이 메서드에는 UploadException이 걸려있음에도, 컴파일러가 잠잠한 이유는?
												//RuntimeException은 잡건 안잡건 sun이 강제하지 않는다!!	

		//2) Product insert  
		productDAO.insert(product); 	//insert  직후, product dto에 자동으로  pk가 채워진다.
													//따라서 아래의 색상과 사이즈 입력시 pk를 이용하면 된다!
		
		//3) Color insert , 유저가 선택한 색상 수 만큼 반복문으로  insert 수행
		//Product DTO 안에  이미 colorList로 몰아넣어 놓았따..
		for(Color color  : product.getColorList()) {
			color.setProduct(product);//color 에 방금들어간 product 정보를 대입
			colorDAO.insert(color);//ColorDAO 에게 insert 시키기
		}
		
		//4) Psize insert  , 유저가 선택한 사이즈 수 만큼 반복문으로  insert 수행 
		for(Psize psize : product.getPsizeList()) {
			psize.setProduct(product);//psize에 방금 들어간 product 정보를 대입
			psizeDAO.insert(psize); 
		}
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
