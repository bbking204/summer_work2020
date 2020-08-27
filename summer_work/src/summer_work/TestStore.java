package summer_work;

import java.util.*;



public class TestStore {
	
	static Scanner in = new Scanner (System.in);
	
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
	

}
