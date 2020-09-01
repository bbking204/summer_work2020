package summer_work;

public class Store {
	
	private Cell [][] cells;
	
	
	public Store() {
		this.cells = new Cell[9][4];
	}
	
	
	public int[] productLocation(Product product) {
	
		long code = product.getCode();
		Cell c = null;
		Product p = null;
		int[] ans = new int[2];
		ans = null;
		
		for (int n = 1; n<=10; n++) {
			for (int z=0; z<5;z++) {
				c = this.cells[n][z];
				p = c.getProduct();
				code = p.getCode();
				if (code == product.getCode()) {
					ans[0] = n;
					ans[1] = z;
					return ans;
				}
			}
		}
		
		return ans;
	}
	
	
	
	
	public Cell productCell(Product product) {
		
		long code = product.getCode();
		Cell c = null;
		Product p = null;
		
		for (int n = 1; n<=10; n++) {
			for (int z=0; z<5;z++) {
				c = this.cells[n][z];
				p = c.getProduct();
				code = p.getCode();
				if (code == product.getCode()) {

					return c;
				}
			}
		}
		
		return c;
	}
	
	
	public Cell getEmpty() {
		Cell c2 = null;
		
		for (int n = 1; n<=10; n++) {
			for (int z=0; z<5;z++) {
				
				c2 = this.cells[n][z];
				if (c2.equals(null)) {
					return c2;
			}
		}
			}
		return null;
	}
	
	
	public Product getProduct (int L, int C) {
		Cell c = null;
		Product p = null;
		Cell c2 = null;
		
		c2 = this.cells[L][C];
		
		if (c2 == c) {
			return p;
		}
		
		p = c2.getProduct();
		return p;
	}
	
	
	public void fillProductStock(Product p) {
		int[] loc = new int[2];
		
		loc = productLocation(p);
		
		if (loc == null) {
			Cell c = null;
			c = getEmpty();
			c.setProduct(p);
			long rn = c.getMaxAmount();
			c.setAmountRn(rn);
		}
		
		Cell c = null;
		c = this.cells[loc[0]][loc[1]];
		long rn = c.getMaxAmount();
		c.setAmountRn(rn);
	}
	
	
	
	public boolean saleProduct(Product p, long count) {
		
		int[] loc = new int[2];
		
		loc = productLocation(p);
		
		if (loc == null) {
			return false;
		}
		
		Cell c = this.cells[loc[0]][loc[1]];
		long rn = c.getAmountRn();
		
		if (count > rn) {
			return false;
		}
		
		c.setAmountRn(rn - count);
		return true;
		
	}
	
	
	public double Profit() {
		
		Cell c = null;
		Cell c2 = null;
		Product p = null;
		double profit = 0;
		
		for (int n = 1; n<=10; n++) {
			for (int z=0; z<5;z++) {
				
				c2 = this.cells[n][z];
				if (c2 != c) {
					p = c2.getProduct();
					long amount = (c2.getMaxAmount()) - (c2.getAmountRn());
					double price = p.moneyEarned();
					profit += amount*price;
				}
	}
		}
		
		return profit;
		
	}
	
	
	
	public Product [ ] productsToStock() {
		Product[] prod = new Product [50];
		Cell c = null;
		Cell c2 = null;
		Product p = null;
		int count = 0;
		
		for (int n = 1; n<=10; n++) {
			for (int z=0; z<5;z++) {
				
				c2 = this.cells[n][z];
				if (c2 != c) {
					p = c2.getProduct();
					long am = c2.getMaxAmount();
					long rn = c2.getAmountRn();
					if ((am - rn) !=0 ) {
						prod[count] = p;
						count++;
					}
				}
			}
				
			}
		return prod;
	}
	
	
	public int [ ] numOfProductsAtDepartment() {
		int[] dep = new int [4];
		Cell c1 = null;
		Product p = null;
		
		for (int c = 0; c <= 4; c++) {
			int count = 0;
			for (int n = 1; n<=10; n++) {
				for (int z=0; z<5;z++) {
					
					c1 = this.cells[n][z];
					
					if (c1 != null) {
						p = c1.getProduct();
						int department = p.getDepartment();
						if (department == c) {
							count++;
						}
					}
				}
					
				}
			dep[c] = count;
		}
		
		return dep;
	}
	
	
	public String productsNames(int dep) {
		
		String names = "";
		Cell c1 = null;
		Product p = null;
		
			for (int n = 1; n<=10; n++) {
				for (int z=0; z<5;z++) {
				
					c1 = this.cells[n][z];
					
					if (c1 != null) {
						p = c1.getProduct();
						int department = p.getDepartment();
						if (department == dep) {
							names += p.getName() + ", ";
						}

				}
					
				}
					
				}
			
			return names;
		
	}
	
	
	
	public String toString() {
		
		String def = "";
		Cell c1 = null;
		Product p = null;
		int count = 1;
		
			for (int n = 1; n<=10; n++) {
				for (int z=0; z<5;z++) {
				
					c1 = this.cells[n][z];
					
					if (c1 != null) {
						def += "cell number " + count + ":";
						p = c1.getProduct();
						def += "product name: " + p.getName() + ", ";
						def += "max amount: " + c1.getMaxAmount() + ", ";
						def += "the amount right now: " + c1.getAmountRn() + ". ";
						count++;
					}
						
					}
						
					}
		
		return def;
	}
	
	
	

		





}
