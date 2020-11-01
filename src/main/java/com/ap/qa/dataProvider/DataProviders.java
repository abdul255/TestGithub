package com.ap.qa.dataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;
import com.ap.qa.util.DataBuilder;

public class DataProviders {

		// collection
	   // making a variable for collection of objects
		// maping and connect the two classes - building the maping-information coming from product data
	 // map the login with the username 
		@DataProvider(name="ProductData")
		public Iterator <Object[]> loginDataProvider (){
			Collection <Object[]> customerData = new ArrayList<Object[]>();
			{
				{
			
			// taking mproduct data and put in list 
			DataBuilder dataBuilder = new DataBuilder();
			List <ProductData> data = dataBuilder.prepareProductData();
			for(ProductData customerModel : data) {
				customerData.add(new Object [] { customerModel } );
			}
		}

	}

			// when we get the data we are not getting in order
			return customerData.iterator();

}
		@Test(dataProvider = "ProductData")
		public void testData(ProductData data) {
			System.out.println(data.getProductName());
			System.out.println(data.getquantity());
			System.out.println(data.getcolor());
			System.out.println(data.getsize());
		}
}	
		
		
		
		
		
		
		
		