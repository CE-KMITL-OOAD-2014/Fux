package test;

public class Day {
	public void chatAndVoteState(){
		//time
		//event

	}
	public void showWhoVoteWho(){

	}
	public void showWhoDie(){

	}
	public String computeVote(villager vi[]){
		int maxVote=0,maxVoteNum=99;
		for(int i = 0;i<vi.length;i++){
			if(maxVote< vi[i].getVotedPoint()){
				maxVote = vi[i].getVotedPoint();
				maxVoteNum = i;
			}
		}
		vi[maxVoteNum].status = "die";
		return vi[maxVoteNum].carreer;
	}
}
