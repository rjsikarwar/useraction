package jp.co.worksap.ate.cardgame.ai;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.co.worksap.ate.cardgame.player.Card;
import jp.co.worksap.ate.cardgame.player.PlayHistory;
import jp.co.worksap.ate.cardgame.player.Card.Number;

public class GeneralUtils {
		
		
	public static int getorderofcards(int num,List<PlayHistory> listHistory)
	{
		
		if(num==2)
		{
			num=15;
		}
		else if(num==1)
		{
			num=14;
		}
		else if(num==0)
		{
			num=16;
		}
		if(isOrderChangeRequired(listHistory))
		{
			num=18-num;
		}
		return num;
	}
	
	public static boolean  isOrderChangeRequired(List<PlayHistory> listHistory)
	{
		int count=0;
		Iterator<PlayHistory>  iterator=listHistory.iterator();
		
		Set<Card> latestCard=null;
		
		while (iterator.hasNext()) {
			PlayHistory playHistory = (PlayHistory) iterator.next();
			Set<Card> playerCards=playHistory.getCard();
			if(playerCards==null || playerCards.size()==0)
			{
				continue;
			}
			if(latestCard==null)
			{
				latestCard=playerCards;
			}
			if(playerCards.size()==4)
			{
				Iterator<Card> itr=playerCards.iterator();
				Card card1=itr.next();
				Card card2=itr.next();
				Card card3=itr.next();
				if(card1.getNumber().getNumber()==card2.getNumber().getNumber() || card3.getNumber().getNumber()==card2.getNumber().getNumber() )
				{
					count++;
				}
				
			}
			
		}
		
		if(latestCard.size()==4)
		{
			Iterator<Card> itr=latestCard.iterator();
			Card card1=itr.next();
			Card card2=itr.next();
			if(card1.getNumber().getNumber()==card2.getNumber().getNumber())
			{
				count++;
			}
			
		}
		
		if(count%2==0)
			return false;
			else
				return true;
		
	}
	
	
	
	public static Card getJoker(Set<Card> playerCards)
	{
			Card jokerCard=null;
		
		Iterator<Card> iterationTogetJoker=playerCards.iterator();
		
		while (iterationTogetJoker.hasNext()) {
			Card card = (Card) iterationTogetJoker.next();
			if(card.getNumber().getNumber()==Number.JOKER.getNumber())
			{
				jokerCard=card;
				break;
			}
			
		}
		
		return jokerCard;
	}
	
	
	
	
}
