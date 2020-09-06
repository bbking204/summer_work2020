package summer_work;

import java.util.Random;

public class main {

//	public static void main(String[] args) {
//		
//		 Random rand = new Random(); 
//		 int num = rand.nextInt(6)+15;
//		 
//		 Product [] ar = new Product [num];
//		 
//		 TestStore a = new TestStore();
//		ar = a.toArray(num);
//
//		 
//		 System.out.println(a);
//		 
//		 TestStore st = new TestStore();
//		 st.buildStore(ar);
//		 
//		 System.out.println(st.toString());
//		 
//		 st.buyThird(st, ar);
//
//	}

	public static void main(String[] args) {
		
		TestStore b = new TestStore();
		
		 Random rand = new Random(); 
		 int num = rand.nextInt(3);//+15;
		 
		 Product [] ar = new Product [num];
		 
		 ar = b.toArray(num);
		
		 System.out.println(ar.toString());	 
		 
		 Store s = b.buildStore(ar);
		 System.out.println(s.toString());
		 s = b.buyThird(s, ar);
		 
		 System.out.println(s.toString());		 
		 System.out.println("profit: " + s.Profit());
		 
		 String answer = b.departmentNames(s.numOfProductsAtDepartment());
		 System.out.println(answer);
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
		 TestStore z = new TestStore();
		 z.switchComma(ans);
		 System.out.println(z);

	}

}
