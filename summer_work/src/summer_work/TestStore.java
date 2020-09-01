package summer_work;

import java.util.*;



public class TestStore {
	
	static Scanner in = new Scanner (System.in);
	 Random rand = new Random(); 
	
	public String switchComma(String s) {
		String s2 = "";
		int count = 0;
		
		while (s != "") {
			if(count == 5) {
				s2+="\n";
			}
			int loc = s.indexOf(',');
			s2 = s.substring(0, loc);
			s2 += "   ";
			count++;
			s = s.substring(loc+1);
		}
		
		return s2;
	}
	
	public String departmentNames(int[] amount) {
		String [ ] dep= {"Doll" ,"Puzzle" , "Creation" ,"Baby" ,"Sport" };
		String an = "";
		
		for (int n = 0; n<=4; n++) {
			an += dep[n];
			an += " = " + amount[n];
			an += "\n";
		}
		
		return an;
	}
	
	
	public Product[] toArray(int n) {
	Product [] pro = new Product[n];
	
	for (int i = 0; i<n; i++) {
		Product p = null;
		System.out.println("enter product code");
		long code = in.nextLong();
		p.setCode(code);
		System.out.println("enter product department");
		int department = in.nextInt();
		p.setDepartment(department);
		System.out.println("enter product name");
		String name = in.nextLine();
		p.setName(name);
		System.out.println("enter buying price of product");
		double price = in.nextDouble();
		p.setPriceBought(price);
		System.out.println("enter selling price of product");
		double sell = in.nextDouble();
		p.setSellingPrice(sell);
		
		pro[i] = p;
	}
	
	return pro;
	
	}
	
	
	public void buildStore(Product[] ar) {
		Store st = new Store();
		int n = ar.length;
		
		for (int i = 0; i < n; i++) {
			int[] loc = new int[2];
			loc = st.productLocation(ar[i]);
			Cell c = st.getEmpty();
			if (loc.equals(null)) {
				c.setProduct(ar[i]);
			}
		}
	}
	
	
	public void buyThird(Store st, Product [] ar) {
		Cell c = null;
		for(int m = 0; m<10; m++) {
			int num = rand.nextInt(ar.length);
			if(!(st.productLocation(ar[num]).equals(null))) {
				st.saleProduct(ar[num], st.productCell(ar[num]).getAmountRn()/3);
			}
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		 Random rand = new Random(); 
		 int num = rand.nextInt(6)+15;
		 
		 Product [] ar = new Product [num];
		 
		 TestStore a = new TestStore();
		 ar = a.toArray(num);

		 
		 System.out.println(a.toString());
		 
		 Store s = buildStore(ar);
		 
		 System.out.println(s.toString());
		 
		 s.buyThird(s, ar);
		 
		 System.out.println(s.toString());
		 
		 System.out.println("profit: " + s.Profit());
		 
		 departmentNames(s.numOfProductsAtDepartment());
		 System.out.println("products to stock: ");
		 
		 Product[] p = s.productsToStock();
		 
		 for(int z = 0; z<50; z++) {
			 if(p[z] != null) {
				 System.out.println(p[z].getName());
			 }
		 }
		 
		 for(int n = 0; n<num; n++) {
			 s.fillProductStock(p[n]);
		 }
		 
		 System.out.println(s.toString());
		 
		 String [] dep = {"Doll" ,"Puzzle" , "Creation" ,"Baby" ,"Sport"};
		 
		 String ans="";
		 
		 for (int m = 0; m<5; m++) {
			 ans+= dep[m] + "; \n";
			 for (int j = 0; j < num; j++) {
				 if(ans != "")
					 ans+=", ";
				 if(ar[j].getDepartment() == m)
					 ans += ar[j].getName();
			 }
			 ans += "\n";
		 }
		 switchComma(ans);

	}
	
	
	

}
