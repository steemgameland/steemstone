package com.gameland.steemstone.interfaces;

public interface IOrder {

	// 명령어 정의
	// $buyunit name count => 유닛 구매(count만큼)
	// $buymagic name count => 마법 구매(count만큼)
	// $send toaccount goldamount ==> 우리편 특정 누군가에게 금을 보낼 수 있는 기능(받는 사람은 메세지가 가야 할텐데... 보팅한 적이 있는사람에게만 보낼 수 있음)
	// $info [account] ==> 해당 계정이 현재 가지고 있는 금의 양과 덱리스트, 계정을 안넣으면 글을 작성한 사람의 골드량
	// $deck ==> 현재 구매된 덱 리스트(총 카드 레벨이나 기타 summary도 보여주자.. 총 소모된 금량이라던지 등)
	// $enemy-deck ==> 상대방의 덱 리스트
	// $team-gold ==> 현재 보팅한 사람들이 가지고 있는 금의 량(총량도 표시)
	// $enemy-gold ==> 현재 상대방의 보팅한 사람들이 가지고 있는 금의 량(총량도 표시)
	// 보류중인 명령어
	// $cancel unitname ==> cancel은 구매 취소로 하려했는데.. 이건 안쓰는게 나을듯...
	// $sell unit name count ==> 유닛 판매도.... 안하는게 나을듯.. 만약 한다면.. 돈을 반만 회수 한다던지...
	// $info unit name => 유닛의 정보를 알려준다.(아 이건 포스팅에 넣어야 할듯?)

	// 코멘트는 한번 처리되고나면 permlink를 저장하여 그 뒤로 그 명령어는 처리하지 않도록 한다..
	// 코멘트가 삭제되어도 이미 한번처리 된 경우는 롤백하지 아니한다..

//	const Orders = {
//	    $BUYUNIT: '$buyunit',
//	    $BUYMAGIC: '$buymagic',
//	    $SEND: '$send',
//	    $INFO: '$info',
//	    $DECK: '$deck',
//	    $ENEMYDECK: '$enemydeck',
//	    $TEAMGOLD: '$teamgold',
//	    $ENEMYGOLD: '$enemygold'
//	}
	
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
