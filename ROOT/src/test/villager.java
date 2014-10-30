package test;

public class villager {
	final int INITVOTEDPOINT = 0;
	final String INITSTATUS = "alive";
	private int votedPoint;
	protected int IDname;
	private int score;
	protected String status ;
	String carreer = "";
	public villager(int IDname ,String carreer) {
		// TODO Auto-generated constructor stub
		this.IDname = IDname;
		this.carreer=carreer;
		status = INITSTATUS;
		votedPoint = INITVOTEDPOINT;
	}
	public void addVotedPoint(){
		votedPoint++;
	}
	public void vote(villager vi){
		vi.addVotedPoint();
	}
	public int getVotedPoint(){
		return votedPoint;
	}
}
