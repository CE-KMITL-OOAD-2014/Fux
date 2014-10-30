package test;

public class PlayGame {
	public Carreer carreer;
	
	
	public PlayGame() {
		// TODO Auto-generated constructor stub
	}
	Night night;
	Day day;
	public void start(User[] userlist){
		carreer = new Carreer(userlist);
		//while(!isWin()){
			night = new Night();
			night.killState();
			day = new Day();
			day.showWhoDie();
			day.chatAndVoteState();
			day.showWhoVoteWho();
		//}
	}
	boolean isWin(){
		return carreer.getWerewolfNum() == 0 || carreer.getVillagerNum() == 0;
	}
	String getWinner()
	{
		if(carreer.getVillagerNum() == 0) return "werewolf";
		else if(carreer.getWerewolfNum() == 0) return "villagerNum";
		else return ""; 
	}
	public void sub(String str) {
		if(str=="villager") carreer.villagerNum--;
		else if(str=="werewolf") carreer.werewolfNum--;
	}
}
