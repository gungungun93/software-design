

import java.util.ArrayList;

public class Lottery_machine {
	ArrayList<Player> players = new ArrayList<Player>();
	private int[] winningNumber;
	private boolean lotteryTicketDraw = true;
	private boolean finish = false;
	public void drawingLottery(){
		RandomNumber rand = new RandomNumber();
		winningNumber = rand.random(1, 49);
		lotteryTicketDraw = false;
	}
	boolean check_NoLotteryTicketDraw(){
		return lotteryTicketDraw;
	}
	boolean check_NoEnterTicket(){
		if( players.size() == 0)
			return true;
		else
			return false;
	}
	boolean check_finishGame(){
		return finish;
	}
	void resetGame(){
		finish = false;
	}
	
	public boolean check_uniqueNumber(int num , int[] nums){
		
		for(int i = 0 ; i < nums.length ; ++i){
			if(num == nums[i]){
				return true;
			}
		}
		return false;
	}
	public boolean checkRange(int num){
		if( num < 1 || num > 49)
			return true;
		else
			return false;
	}
	public void newPlayer(Player p){
		players.add( p );

	}
	
	String get_winningResult(){
		String winning_number = "\n\nWinning number: ";
		for( int i = 0 ; i < 6 ; ++i){
			winning_number += winningNumber[i] + " ";
		}
		System.out.println(winning_number);
		return winning_number;
	}
	
	public int[][] checkMatch(){
		int[] n;
		
		int[][] player_match = new int[players.size()][6];
		for(int i = 0 ; i < players.size() ; ++i){
			n = players.get(i).get_number();
			for( int j = 0 ; j < 6 ; ++j){
				for( int k = 0 ; k < 6 ; ++k){
					if( n[j] == winningNumber[k] ){
						player_match[i][j] = n[j];
					}
				}
			}

		}
		finish = true;
		return player_match;
	}
}
