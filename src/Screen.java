


public class Screen {
	
	public void display(){
		String str = "\n";
		str +=   " === Lottery Menu ===\n";
		str +=  " 1 Enter ticket\n";
		str +=  " 2 Lottery drawing\n";
		str +=  " 3 Show result\n";
		str +=  " 0 Quit\n";
		str +=  "Please enter (0-3): _";
		System.out.println(str);	           
	}
	
	public void enterNumber(int i){
		System.out.print(i+") Enter number: ");	
	}
	public void enterName(){
		System.out.print("Enter name: ");	
	}
	public void showtResult(String s){
		System.out.print(s);	
	}
	public void errorHandler(String e){
		System.out.println("Error: "+e);
	}
	
}
