package com.sds.movieadmin.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelManager {
	
	//서버에 저장된 엑셀 파일을 접근? 하여 읽어들여, 자바의 List형태로 반환..
	public List getMovieData(String excelPath) {
		
		
		try {
			XSSFWorkbook book = new XSSFWorkbook(excelPath);//엑셀에 접근
			XSSFSheet sheet=book.getSheetAt(0); //시트에 접근
			
			//row 수만큼 반복문 돌리기 
			Iterator it = sheet.iterator();
			//제일위에 row는 제목 row행 이므로, 반복문에서 제외시키자
			it.next();
			
			//hasNext() 메서드는 다음 위치한 객체가 존재할때 true를 반환, 반복문의 조건에 사용할 수 있다 
			while(it.hasNext()) { //hasNext() 가 true 인 동안 반복 
				XSSFRow row=(XSSFRow)it.next();//다음 요소에 접근
				
				XSSFCell codeCell=row.getCell(0);//영화코드
				XSSFCell nameCell=row.getCell(1);//영화명
				XSSFCell urlCell=row.getCell(2);//URL
				
				System.out.println((int)codeCell.getNumericCellValue()+" , "
				+nameCell.getStringCellValue()+" , "+urlCell.getStringCellValue());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		
		
		return null;
	}
	
}




