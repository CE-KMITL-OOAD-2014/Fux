package model;

import java.util.ArrayList;

public class GameRoom {
	private ArrayList<Villager> player = null;
	private String state;
	private int roomID;
	private String creater;
	private int numPlayer;

	public GameRoom(ArrayList<Villager> player) {
		this.player = player;
	}

	public ArrayList<Villager> getPlayer() {
		return player;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreater() {
		return creater;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	public int getNumPlayer() {
		return numPlayer;
	}
}
