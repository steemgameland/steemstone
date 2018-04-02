package com.gameland.steemstone.interfaces;

public interface IOrder {
	public void addGold();
	public void removeGold();
	public void transferGold();
	public void buyUnit();
	public void buyMagic();
	public void sendGold();
	public void getInfo();
	public void getDeck();
	public void getEnemyDeck();
	public void getTeamGold();
	public void getEnemyGold();
	public void setDeckPosition();
}
