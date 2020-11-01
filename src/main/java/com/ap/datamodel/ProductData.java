package com.ap.datamodel;

//updatee
// all the products we are working on this will be getting from excell
// get the information and set those on website
public class ProductData {
	
	private String ProductName;
	private String quantity;
	private String size;
	private String color;
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String ProductName) {
		this.ProductName=ProductName;
	}
	
	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity=quantity;
	}
	
	public String getsize() {
		return size;
	}
	public void setsize(String size) {
		this.size=size;
	}
	

	public String getcolor() {
		return color;
	}
	public void setcolor(String color) {
		this.color=color;
	}
	// creating limit 1 person can not buy more than 31. 
	// we have a method and setting 31 that maximum quantity can be buy
	// if the product is null dont do anything and returning the result
	@Override
	public int hashCode() {
		final int prime=31;
		int result=1; // minimum has to be 1 maximum 31
		result = prime * result + ((color == null)? 0 : color.hashCode());
		result = prime * result + ((ProductName == null) ? 0 : ProductName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result; // return the information you are passing
	}
	
	//override method and boolean statement if this object return value if not selected product it will give you false , if it null
	// it will skip, if 
	//get class to make sure color , quantity, product , size  is exist in the class or not first make sure in the class level
	// overrid == same methods to write again
	@Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass()) // class level validation= get class is built in method
            return false;
        ProductData other = (ProductData) obj;
        if(color == null){
            if(other.color !=null)
                return false;
        }else if(!color.equals(other.color))
            return false;
        if (ProductName == null){
            if(other.ProductName != null)
                return false;
        }else if (!ProductName.equals(other.ProductName))
                return false;
            if (quantity == null){
                if(other.quantity != null)
                    return false;
               
            }else if (!quantity.equals(other.quantity))
                return false;
            if (size == null){
                if(other.size != null)
                    return false;       
		} else if (! size .equals(other.size))	
			return false;
		    return true;
	}
	
	// coverting to string and then returnin in the console priting it out
	@Override
    public String toString(){
        return "ProcuctData [productName=" + ProductName + ", quantity=" +quantity + ",size="+size+",color="+color+"]";

		
	}

	}


