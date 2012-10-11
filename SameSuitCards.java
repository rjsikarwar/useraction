package jp.co.worksap.ate.cardgame.ai;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.co.worksap.ate.cardgame.player.Card;
import jp.co.worksap.ate.cardgame.player.Card.Mark;
import jp.co.worksap.ate.cardgame.player.PlayHistory;
import jp.co.worksap.ate.cardgame.player.Player;

public class SameSuitCards {

	public static boolean isFromSameSuitConsecutively(List<PlayHistory> listHistory)
	{
		
		Set<Card> playerCard=null;
		Card lastCard=null;
		Card secondLastCard=null;
		Player lastPlayer=null;
		Player secondLastPlayer=null;
	//	Card thirdlastCard=null;
		Iterator<PlayHistory> history=listHistory.iterator();
		while (history.hasNext()) {
			PlayHistory playHistory = (PlayHistory) history.next();
			playerCard=playHistory.getCard();
			if(playerCard==null)
			{
				continue;
			}
			if(playerCard.size()>1)
			{
				return false;
			}
			if(lastCard!=null && secondLastCard!=null )//&& thirdlastCard!=null)
			{
				break;
			}
			else if(lastCard==null)
			{
				lastCard=playerCard.iterator().next();
				lastPlayer=playHistory.getPlayer();
			}
			else if(secondLastCard==null){
				secondLastCard=playerCard.iterator().next();
				secondLastPlayer=playHistory.getPlayer();
			}
			/*else{
				thirdlastCard=playerCard.iterator().next();
			}*/
		}
		if(lastPlayer.equals(secondLastPlayer))
		{
			return false;
		}
		if(lastCard.getMark()==secondLastCard.getMark() )//&& lastCard.getMark()==thirdlastCard.getMark())
		{
			return true;
		}
		return false;
	}
	
	public static Set<Card> returnCardForConsecutiveCase(List<PlayHistory> listHistory,Set<Card> playerCards)
	{
		Set<Card> set = new HashSet<Card>();
		PlayHistory lastPlayerHistory;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
	 lastPlayerCards=lastPlayerHistory.getCard();
	 		i++;
		}while(lastPlayerCards==null);
		
		Mark mark=lastPlayerCards.iterator().next().getMark();
		Card lastPlayerCard=lastPlayerCards.iterator().next();
		List<Card>[]  setOneList=CardUtils.returnSetOfOne(playerCards);
		if(setOneList==null || setOneList.length==0)
			return null;
		for (int j = 0; j < setOneList.length; j++) {
			Iterator<Card> tempItr=setOneList[j].iterator();
			
			Card card = (Card) tempItr.next();
			if(GeneralUtils.getorderofcards(card.getNumber().getNumber(),listHistory)>GeneralUtils.getorderofcards(lastPlayerCard.getNumber().getNumber(),listHistory) && card.getMark()==mark)
			{	
				set.add(card);
				break;
			}
		}
		return set;
	}
	
	public static boolean isConditionOf8True(List<PlayHistory> listHistory)
	{
		Set<Card> playerCard=null;
		Card lastCard=null;
	//	Card secondLastCard=null;
	//	Card thirdlastCard=null;
		Iterator<PlayHistory> history=listHistory.iterator();
		while (history.hasNext()) {
			PlayHistory playHistory = (PlayHistory) history.next();
			playerCard=playHistory.getCard();
			if(playerCard==null)
			{
				continue;
			}
			if(playerCard.size()>1)
			{
				return false;
			}
			if(lastCard!=null )//&& thirdlastCard!=null)
			{
				break;
			}
			else if(lastCard==null)
			{
				lastCard=playerCard.iterator().next();
				if(lastCard.getNumber().getNumber()!=8)
				{
					return false;
				}
				else
					return true;
			}
			
			
		}
		
		
		return true;
	}
	
	
	 
	
	public static boolean isFromSameSuitConsecutivelyOfSize2(List<PlayHistory> listHistory)
	{
		Set<Card> playerCard=null;
		Card lastCard[]=new Card[2];
		Card secondLastCard[]=new Card[2];
		
	//	Card thirdlastCard=null;
		Iterator<PlayHistory> history=listHistory.iterator();
		while (history.hasNext() ) {
			PlayHistory playHistory = (PlayHistory) history.next();
			playerCard=playHistory.getCard();
			if(playerCard==null)
			{
				continue;
			}
			if(playerCard.size()>2 || playerCard.size()==1)
			{
				return false;
			}
		if(lastCard[0]==null)
		{
			Iterator<Card> temp=playerCard.iterator();
			lastCard[0]=temp.next();
			lastCard[1]=temp.next();
			
		}
		else if(secondLastCard[0]==null)
		{
			Iterator<Card> temp=playerCard.iterator();
			secondLastCard[0]=temp.next();
			secondLastCard[1]=temp.next();
		}
			
		}
		 if(secondLastCard[0]!=null && lastCard[0]!=null)
		{
			if(lastCard[0].getMark()==secondLastCard[0].getMark() && lastCard[1].getMark()==secondLastCard[1].getMark())
			{
				return true;
			}
			else if(lastCard[1].getMark()==secondLastCard[0].getMark() && lastCard[0].getMark()==secondLastCard[1].getMark())
			{
				return true;
			}
		}
	
	return false;

	}
	
	
	public static Set<Card> returnCardForConsecutiveCaseOfSize2(List<PlayHistory> listHistory,Set<Card> playerCards)
	{

		Set<Card> set = new HashSet<Card>();
		PlayHistory lastPlayerHistory;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
			lastPlayerCards=lastPlayerHistory.getCard();
	 		i++;
		}while(lastPlayerCards==null);
		
		Iterator<Card> it=lastPlayerCards.iterator();
		Mark[] mark=new Mark[2];
		mark[0]=it.next().getMark();
		mark[1]=it.next().getMark();
		
		Card lastPlayerCard=lastPlayerCards.iterator().next();
		List<Card>[]  setTwoList=CardUtils.returnSetOfTwo(playerCards);
		if(setTwoList==null || setTwoList.length==0)
			return null;
		for (int j = 0; j < setTwoList.length; j++) {
			Iterator<Card> tempItr=setTwoList[j].iterator();
			
			Card card1 = (Card) tempItr.next();
			Card card2=(Card)tempItr.next();
			if(GeneralUtils.getorderofcards(card1.getNumber().getNumber(),listHistory)>GeneralUtils.getorderofcards(lastPlayerCard.getNumber().getNumber(),listHistory))
			{	
				if((card1.getMark()==mark[0] && card2.getMark()==mark[1]) || (card1.getMark()==mark[1] && card2.getMark()==mark[0]) )
				{
				set.add(card1);
				set.add(card2);
				break;
				}
			}
		}
		return set;
	
	}
	
	
}
