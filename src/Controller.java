
import java.util.Scanner;

public class Controller {
	
	Lottery_machine m = new Lottery_machine();
	Screen s = new Screen();
	Scanner scan = new Scanner(System.in);
	
	void createPlayer(Player p){
		m.newPlayer(p);
	}
	
	boolean check_NoEnterTicket(){
		if( m.check_NoEnterTicket() ){
			s.errorHandler("No ticket enter yet.");
			s.display();
			request_checkOption( scan.nextLine() );
			return true;
		}else{
			return false;
		}
	}
	boolean check_NoLotteryTicketDraw(){
		if( m.check_NoLotteryTicketDraw()){
			s.errorHandler("No lottery ticket drawing yet.");
			s.display();
			request_checkOption( scan.nextLine() );
			return true;
		}else{
			return false;
		}
	}
	
	String checkWinning(int[][] playerMatch){
		
		String str ="", winning_number = m.get_winningResult() ,winner="",name_player;
		int count = 0;
		boolean match = false;
		for(int i = 0 ; i < playerMatch.length ; ++i){
			
			count = 0;
			name_player = m.players.get(i).get_name();
			str += "\n"+name_player+" number match : ";
			for( int j = 0 ; j < playerMatch[i].length ; ++j){
				if( playerMatch[i][j] != 0){
					str += playerMatch[i][j] + " ";
					count++;
				}
			}
			
			if( count == 6 ){
				winner += "\n"+name_player +" win\n\n";
				match = true;
			}
		}
		if( !match ){
			winner = "\nNo one win\n";
		}
		return winning_number+str+winner;
	}
	
	public boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		return true;
	}
	
	void request_checkOption(String opt){
		
		if( m.check_finishGame() ){
			m = new Lottery_machine();
		}
		
		if( opt.equals("1")){
			
			if( m.check_NoLotteryTicketDraw() ){
				String input,n;
				s.enterName();
				n = scan.nextLine();
				int num;
				int[] array = new int[6];
				
				for( int i = 0 ; i < 6 ; ++i){
					s.enterNumber(i+1);
					input = scan.nextLine();
					if( !isInteger(input) ){
						s.errorHandler("Please enter number between 1-49");
						i -= 1;
					}else{
						num = Integer.parseInt(input);
						if( m.checkRange(num)){
							s.errorHandler("out of range");
							i -= 1;
						}else if( m.check_uniqueNumber(num,array) ){
							s.errorHandler("not unique number");
							i -= 1;
						}else{
							array[i] = num;
						}
					}
					
				}
				createPlayer(new Player(n,array));
				s.display();
				request_checkOption( scan.nextLine() );
			}else{
				s.errorHandler("lottery ticket is already drawing");
				s.display();
				request_checkOption( scan.nextLine() );
			}
		}else if( opt.equals("2")){
			
			if( !check_NoEnterTicket() ){
				m.drawingLottery();
				s.display();
				request_checkOption( scan.nextLine() );
			}

		}else if( opt.equals("3")){
			
			if( !check_NoEnterTicket() && !check_NoLotteryTicketDraw() ){
				s.showtResult( checkWinning( m.checkMatch() ));
				
				s.display();
				request_checkOption( scan.nextLine() );
			}
			
		}else if( opt.equals("0")){
			return;
		}else{
			s.errorHandler("Please enter number between 0-3");
			s.display();
			request_checkOption( scan.nextLine() );
		}
	}
	
	void startProgram(){
		s.display();
		request_checkOption( scan.nextLine() );
	}
	
}
