package jp.co.worksap.ate.cardgame.ai;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.co.worksap.ate.cardgame.player.Card;
import jp.co.worksap.ate.cardgame.player.PlayHistory;
import jp.co.worksap.ate.cardgame.player.Player;
import jp.co.worksap.ate.cardgame.player.PlayerAction;

public class PlayerAction04 implements PlayerAction {

	@Override
	public String getName() {
		return "team04";
	}
	
	
	
	@Override
	public Set<Card> perform(Player myPlayerObj, List<Player> listOfPlayers, Set<Card> playerCards,
			List<PlayHistory> listHistory) {
		
		Iterator<PlayHistory> iterator=listHistory.iterator();
		int numberOfPlayers=listOfPlayers.size();
		int totalPlayers=0;
		Player startPlayer=null;
		int passCount=0;
		int loopCount=-1;
		Iterator<Player> finshedCheck=listOfPlayers.iterator();
		/*while (finshedCheck.hasNext()) {
			Player player = (Player) finshedCheck.next();
			if(player.)
		}
		*/
		//To Check if the We have a chance of new start
		if(listHistory.size()>=numberOfPlayers)
		{
			loopCount=0;
		while (numberOfPlayers>0 && iterator.hasNext()) {
			loopCount++;
			PlayHistory playHistory = (PlayHistory) iterator.next();
			Player player=playHistory.getPlayer();
			if(player.equals(startPlayer))
			{
				break;
			}
			if(startPlayer==null)
			{
				startPlayer=player;
			}
			totalPlayers++;
			
			if(myPlayerObj.getId()!=player.getId())
			{
				if(playHistory.getCard()==null)
				{
					passCount++;
				}
			}
			numberOfPlayers--;
			
		}
		}
		
		if(listHistory==null || listHistory.isEmpty() || (passCount==totalPlayers-1)||(passCount==loopCount))
		{
			return startNew(myPlayerObj, listOfPlayers, playerCards, listHistory);
		}
		else
		{
			
			return continueWithPrevious(myPlayerObj, listOfPlayers, playerCards, listHistory);
		}
		
		
	}
	
	
	/**
	 * 
	 * @param myPlayerObj
	 * @param listOfPlayers
	 * @param playerCards
	 * @param listHistory
	 * @return
	 */
	public Set<Card> startNew(Player myPlayerObj, List<Player> listOfPlayers, Set<Card> playerCards,
			List<PlayHistory> listHistory) {
		
		Set<Card> set = new HashSet<Card>();
		List<Card>[] trail4=CardUtils.returnTrail4(playerCards);
		if(trail4!=null && trail4.length>0)
		{

			List<Card> tempList=trail4[0];
			Iterator<Card> tempItr=tempList.iterator();
			while (tempItr.hasNext()) {
				Card card = (Card) tempItr.next();
				set.add(card); 
			}
			return set;
		}
		
		
		
		List<Card>[] setOfFour=CardUtils.returnSetOfFour(playerCards);
		if(setOfFour!=null && setOfFour.length>0 )
		{
			List<Card> tempList=setOfFour[setOfFour.length-1];
			Iterator<Card> tempItr=tempList.iterator();
			while (tempItr.hasNext()) {
				Card card = (Card) tempItr.next();
				set.add(card); 
			}
			return set;
		}
		
		List<Card>[] trail=CardUtils.returnTrail(playerCards);
		if(trail!=null && trail.length>0)
		{

			List<Card> tempList=trail[0];
			Iterator<Card> tempItr=tempList.iterator();
			while (tempItr.hasNext()) {
				Card card = (Card) tempItr.next();
				set.add(card); 
			}
			return set;
		}
		Card jokerCard=GeneralUtils.getJoker(playerCards);
		List<Card>[] setOfThree=CardUtils.returnSetOfThree(playerCards);
		if(setOfThree!=null && setOfThree.length>0){

			List<Card> tempList=setOfThree[0];
			Iterator<Card> tempItr=tempList.iterator();
			while (tempItr.hasNext()) {
				Card card = (Card) tempItr.next();
				set.add(card); 
			}
			
			if(jokerCard!=null)
			{
				set.add(jokerCard);
			}
			return set;
		}
		
		List<Card>[] setOfTwo=CardUtils.returnSetOfTwo(playerCards);
		if(setOfTwo!=null && setOfTwo.length>0){

			List<Card> tempList=setOfTwo[0];
			Iterator<Card> tempItr=tempList.iterator();
			while (tempItr.hasNext()) {
				Card card = (Card) tempItr.next();
				set.add(card); 
			}
			if(jokerCard!=null)
			{
				set.add(jokerCard);
			}
			return set;
		}
		
		
		List<Card>[] setOfOne=CardUtils.returnSetOfOne(playerCards);
		if(setOfOne!=null && setOfOne.length>0){

			List<Card> tempList=setOfOne[0];
			set.addAll(tempList);
			return set;
		}	
		
		
			
			return set;
	}
	
	/**
	 * 
	 * @param myPlayerObj
	 * @param listOfPlayers
	 * @param playerCards
	 * @param listHistory
	 * @return
	 */
	
	public Set<Card> continueWithPrevious(Player myPlayerObj, List<Player> listOfPlayers, Set<Card> playerCards,
			List<PlayHistory> listHistory) {
	
		Set<Card> set = new HashSet<Card>();
		PlayHistory lastPlayerHistory;
		Player lastPlayer=null;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
			lastPlayerCards=lastPlayerHistory.getCard();
	 i++;
		}while(lastPlayerCards==null);
		
	if(SameSuitCards.isConditionOf8True(listHistory))
		return null;
		
		if(SameSuitCards.isFromSameSuitConsecutively(listHistory))
			return SameSuitCards.returnCardForConsecutiveCase(listHistory, playerCards);
		
		if(SameSuitCards.isFromSameSuitConsecutivelyOfSize2(listHistory))
			return SameSuitCards.returnCardForConsecutiveCaseOfSize2(listHistory, playerCards);
		
		
		int numberOfCardsOfLastPlayer=lastPlayerCards.size();
	
	if(numberOfCardsOfLastPlayer==1)
	{
		
		return DecisionHelper.returnSetOfSizeOne(playerCards, listHistory);		
	}
	
	
	if(numberOfCardsOfLastPlayer==2)
	{/*
		Set<Card> set_here;
        set_here = DecisionHelper.returnSetOfSizeTwo_later(playerCards,listHistory);
       */ 
        /*if(set_here.equals(null)||set_here.isEmpty()){
            return DecisionHelper.returnSetOfSizeTwo(playerCards, listHistory);
        }*/
        return DecisionHelper.returnSetOfSizeTwo(playerCards, listHistory);
       // return set_here;
        
        //return DecisionHelper.returnSetOfSizeTwo(playerCards, listHistory);
	}
	
	if(numberOfCardsOfLastPlayer==3)
	{
		return DecisionHelper.returnSetOfSizeThree(playerCards, listHistory);
	}
	
	if(numberOfCardsOfLastPlayer==4)
	{
		return DecisionHelper.returnSetOfSizeFour(playerCards, listHistory);
	}
	
		return set;
	}
	

}
