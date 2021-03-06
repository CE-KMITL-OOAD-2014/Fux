package model;

public class MemberModel {
	private int ID;
	private String username;
	private String password;
	private int score;
	private int sesID;
	public MemberModel(int ID, String username, String password) {
		this.setID(ID);
		this.setUserName(username);
		this.setPassword(password);
	}
	public MemberModel(int ID, String username, String password,int score){
		this.setID(ID);
		this.setUserName(username);
		this.setPassword(password);
		this.setScore(score);
	}
	public void setUserName(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	public void setScore(int score){
		this.score = score;
	}
	public void setsesID(int sesID){
		this.sesID = sesID;
	}
	public String getUserName(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public int getID(){
		return ID;
	}
	public int getScore() {
		return score;
	}
	public int getsesID(){
		return sesID;
	}
}
