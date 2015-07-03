

public class Player {
	String name;
	int[] number;
	
	Player(String name,int[] number){
		this.name = name;
		this.number = number;
	}
	public String get_name(){
		return name;
	}
	
	public int[] get_number(){
		return number;
	}
	public void set_name(String name){
		this.name = name;
	}
	public void set_number(int[] number){
		this.number = number;
	}
}
