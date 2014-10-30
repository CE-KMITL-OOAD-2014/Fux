package test;

import java.util.Random;

public class Carreer {
	static final int PEOPLE = 6,
			WEREWOLFNUMINIT=1,VILLAGERNUMINIT=5;
	Random randomGenerator;
	public int werewolfNum= WEREWOLFNUMINIT;
	public int villagerNum= VILLAGERNUMINIT;
	villager vi[];
	public Carreer(User[] user){
		vi = new villager[PEOPLE] ;
		randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(6);
		for(int i = 0 ; i < PEOPLE ;i++)
			if(i!=randomInt)
				vi[i] = new villager(user[i].IDnum,"villager");
			else
				vi[i] = new Werewolf(user[i].IDnum,"werewolf");
	}
	public int getWerewolfNum(){
		return werewolfNum;
	}
	public int getVillagerNum() {
		return villagerNum;
	}
}
