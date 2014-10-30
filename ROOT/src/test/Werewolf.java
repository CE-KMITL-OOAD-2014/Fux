package test;

public class Werewolf extends villager{
	public Werewolf(int IDname,String carreer) {
		super(IDname, carreer);
		// TODO Auto-generated constructor stub
		this.IDname = IDname;
		this.carreer = carreer;
	}

	public void kill(villager vi){
		vi.status = "die";
	}
}
