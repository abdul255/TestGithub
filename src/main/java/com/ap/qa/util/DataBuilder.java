package com.ap.qa.util;

import java.util.ArrayList;
import java.util.List;

import com.ap.datamodel.ProductData;

public class DataBuilder {
	
	public List <ProductData> prepareProductData(){
		
		List<ProductData> ProductsData = new ArrayList<ProductData>();
		
		Read_XLS read = new Read_XLS("product.xlsx" , "\\src\\main\\resources\\testdata");
		Object [][] objs= new Object[read.retrieveNoOfRows("Sheet1") - 1][read.retrieveNoOfCols("Sheet1")];
		objs = read.retrieveTestData("Sheet1");
		for(Object []obj : objs) {
			ProductData ProductData = new ProductData();
			ProductData.setProductName(obj[0].toString());
			ProductData.setquantity(obj[1].toString());
			ProductData.setsize(obj[2].toString());
			ProductData.setcolor(obj[3].toString());
			ProductsData.add(ProductData);
		}
		return ProductsData;
	}

}
