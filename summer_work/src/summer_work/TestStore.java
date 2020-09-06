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
		String answer = "";
		
		for (int n = 0; n<=4; n++) {
			answer += dep[n];
			answer += " = " + amount[n];
			answer += "\n";
		}
		
		return answer;
	}
	
	
	public Product[] toArray(int n) {
	Product [] pro = new Product[n];
	
	for (int i = 0; i<n; i++) {
		
		System.out.println("enter product code");
		long code = in.nextLong();
		System.out.println("enter product department");
		int department = in.nextInt();
		System.out.println("enter product name");
		String name = in.next();
		System.out.println("enter buying price of product");
		double price = in.nextDouble();
		System.out.println("enter selling price of product");
		double sell = in.nextDouble();
		Product p = new Product(code,name,department,price,sell);
		pro[i] = p;
	}
	
	return pro;
	
	}
	
	
	public Store buildStore(Product[] ar) {
		Store st = new Store();
		int n = ar.length;
		int i = n;
		int count2 = 0;
		while(i > 0) {
			for(int row = 0; row < 10; row++) {
				   if(!(i>0)) {
					   break;
				   }
				for(int cell = 0; cell < 5; cell++) {
				   if(!(i>0)) {
					   break;
				   }
					if(i==n) {
					    Product p = st.getProduct(row, cell);
					    p = ar[count2];
					    System.out.println("current amount of product: " +  p.getName() );
					    int amount = in.nextInt();
					    Cell c = new Cell(p, amount);
					    Cell[][] cells = st.getCells();
					    cells[row][cell] = c;
					    count2++;
					    i--;
					}
					
					else {
					int[] loc = st.productLocation(ar[count2]);
					if (loc[0] != -1) {
						Product p = st.getProduct(loc[0], loc[1]);
						Cell c = st.productCell(p);
						System.out.println("amount of product " + p.getName() + " you wnt to add");
						int amount = in.nextInt();
						long amount1 = c.getAmountRn();
						c.setAmountRn(amount1+amount);
						count2++;
						i--;
					}
					else {
					Product p = st.getProduct(row, cell);
				    p = ar[count2];
				    System.out.println("current amount of product: " + p.getName());
				    int amount = in.nextInt();
				    Cell c = new Cell(p, amount);
				    Cell[][] cells = st.getCells();
				    cells[row][cell] = c;
				    count2++;
				    i--;
					}
					}
				}
				}
			
		}
		return st;
	}
	
	
	public Store buyThird(Store st, Product [] ar) {
		for(int m = 0; m<10; m++) {
			int num = rand.nextInt(ar.length);
			if(!(st.productLocation(ar[num]).equals(null))) {
				st.saleProduct(ar[num], st.productCell(ar[num]).getAmountRn()/3);
			}
		}
		return st;
	}

}
