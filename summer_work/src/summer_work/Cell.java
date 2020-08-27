package summer_work;

public class Cell {
	
	private Product product;
	private long maxAmount;
	private long amountRn;
	
	
	public Cell(Product product, long rn) {
		this.product = product;
		this.maxAmount = ((product.getCode())%100)*10;
		this.amountRn = rn;
	}
	
	
	// "set" methods
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setMaxAmount(long max) {
		this.maxAmount = max;
	}
	
	public void setAmountRn(long rn) {
		this.amountRn = rn;
	}
	
	
	// "get" methods
	
	public Product getProduct() {
		return this.product;
	}
	
	public long getMaxAmount() {
		return this.maxAmount;
	}
	
	public long getAmountRn() {
		return this.amountRn;
	}
	
	// defining object
	
	public void defineCell(long max, long rn, long code, String name, int department, double price_bought, double selling_price) {
		this.amountRn = rn;
		this.maxAmount = max;
		product.defineProduct( code, name, department, price_bought, selling_price);
	}
	
	//monthly earned
	
	public double monthlyEarned() {
		long amount = this.maxAmount - this.amountRn;
		double earned = amount * product.getSellingPrice();
		return earned;
	}

}
