

public class ChildClass extends PS1 {
	
	int a;
	
	public ChildClass(int a) {
		// TODO Auto-generated constructor stub
		
		super(a);
		this.a = a;
	}


	public Integer addition() {
		
		a=a+1;
		return a;
		
	}
	
	public  Integer substraction() {
		
		a=a-1;
		return a;
		
	}

}
