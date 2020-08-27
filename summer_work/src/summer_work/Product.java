package summer_work;

public class Product {
	
	private long code;
	private String name;
	private int department;
	private double price_bought;
	private double selling_price;
	
	
	public Product (long code, String name, int department, double price_bought, double selling_price) {
		this.code = code;
		this.name = name;
		this.department = department;
		this.price_bought = price_bought;
		this.selling_price = selling_price;
	}
	
	
	//"get" methods
	
	public long getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDepartment() {
		return this.department;
	}
	
	public double getPriceBought() {
		return this.price_bought;
	}
	
	public double getSellingPrice() {
		return this.selling_price;
	}
	
	
	//"set" methods
	
	public void setCode(long code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(int department) {
		this.department = department;
	}
	
	public void setPriceBought(double price) {
		this.price_bought = price;
	}
	
	public void setSellingPrice(double selling_price) {
		this.selling_price = selling_price;
	}
	
	
	
	// defining object
	
	public void defineProduct(long code, String name, int department, double price_bought, double selling_price) {
		this.code = code;
		this.name = name;
		this.department = department;
		this.price_bought = price_bought;
		this.selling_price = selling_price;
	}
	
	
	//products' size
	
	public String getSize() {
		long num = (this.code)%100;
		String answer = "";

        switch ((01 <= num && num <= 32 ) ? 0 :
                (33 <= num && num <= 65) ? 1 : 2) {

            case 0:
                answer = "larg";
                break;
            case 1:
                answer = "medium";
                break;
            case 2:
                answer = "small";
                break;
        }
        
        return answer;
	}
	
	
	// money earned
	
	public double moneyEarned() {
		double earned = this.selling_price - this.price_bought;
		return earned;
	}
	


}
