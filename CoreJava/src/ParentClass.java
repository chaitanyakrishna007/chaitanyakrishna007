

public class ParentClass {
	
		public static void main(String[] args) {
			
			int a=4;
			
			ChildClass child = new ChildClass(a);
			System.out.println(child.addition());
			System.out.println(child.substraction());
			System.out.println(child.multiplybytwo());
		}
}

