package jp.co.worksap.ate.cardgame.ai;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jp.co.worksap.ate.cardgame.player.Card;
import jp.co.worksap.ate.cardgame.player.Card.Number;
import jp.co.worksap.ate.cardgame.player.PlayHistory;
import jp.co.worksap.ate.cardgame.player.Player;

public class DecisionHelper {

	
	public static Set<Card>  returnSetOfSizeOne(Set<Card> playerCards,
			List<PlayHistory> listHistory)
	{
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
		Card lastPlayerCard=lastPlayerCards.iterator().next();
		List<Card>[] setOfOne=CardUtils.returnSetOfOne(playerCards);
		if(setOfOne!=null && setOfOne.length>0){
			
			
			for(int j=0;j<setOfOne.length;j++)
			{
			Iterator<Card> tempItr=setOfOne[j].iterator();
			
				Card card = (Card) tempItr.next();
				if(GeneralUtils.getorderofcards(card.getNumber().getNumber(),listHistory)>GeneralUtils.getorderofcards(lastPlayerCard.getNumber().getNumber(),listHistory))
				{	
					set.add(card);
					break;
				}
				
			}
			
		}
		return set;
	}
	
	

	public static Set<Card>  returnSetOfSizeTwo(Set<Card> playerCards,
			List<PlayHistory> listHistory)
	{
		Card jokerCard=GeneralUtils.getJoker(playerCards);
		Set<Card> set = new HashSet<Card>();
		PlayHistory lastPlayerHistory;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
			lastPlayerCards=lastPlayerHistory.getCard();
	 i++;
		}while(lastPlayerCards==null);
		Card lastPlayerCard=lastPlayerCards.iterator().next();
		List<Card>[] setOfTwo=CardUtils.returnSetOfTwo(playerCards);
		if(setOfTwo==null || setOfTwo.length==0)
			set= null;
		
		if(setOfTwo!=null){
		for(int j=0;j<setOfTwo.length;j++)
		{
		Iterator<Card> tempItr=setOfTwo[j].iterator();
		
			Card card = (Card) tempItr.next();
			if(GeneralUtils.getorderofcards(card.getNumber().getNumber(),listHistory)>GeneralUtils.getorderofcards(lastPlayerCard.getNumber().getNumber(),listHistory))
			{	
				tempItr=setOfTwo[j].iterator();
				while(tempItr.hasNext())
				{	
					Card card1 = (Card) tempItr.next();
					set.add(card1);
				}
				break;
			}
		}
		}
		if(jokerCard!=null && (set==null ||set.size()==0))
		{
			set= returnSetOfSizeOne(playerCards, listHistory);
			set.add(jokerCard);
		}
		return set;
		
	}
	
	

	public static Set<Card>  returnSetOfSizeThree(Set<Card> playerCards,
			List<PlayHistory> listHistory)
	{
		Card jokerCard=GeneralUtils.getJoker(playerCards);
		
		Iterator<Card> iterationTogetJoker=playerCards.iterator();
		
		while (iterationTogetJoker.hasNext()) {
			Card card = (Card) iterationTogetJoker.next();
			if(card.getNumber().getNumber()==Number.JOKER.getNumber())
			{
				jokerCard=card;
			}
			
		}
		
		Set<Card> set = new HashSet<Card>();
		Card cards[]=new Card[3];
		PlayHistory lastPlayerHistory;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
			lastPlayerCards=lastPlayerHistory.getCard();
			i++;
		}while(lastPlayerCards==null);
		
		Iterator<Card> itr=lastPlayerCards.iterator();
		 i=0;
		while (itr.hasNext()) {
			Card card = (Card) itr.next();
			cards[i]=card;
			i++;
		}
		int cardNumbers[]=new int[3];
		for(i=0;i<3;i++)
		{
				cardNumbers[i]=GeneralUtils.getorderofcards(cards[i].getNumber().getNumber(),listHistory);
			
			
		}
		
		if(cards[0].getMark()==cards[1].getMark() && cards[1].getMark()==cards[2].getMark())
		{ 
			int highestNumber=cardNumbers[0];
			for(i=1;i<3;i++)
			{
				if(highestNumber<cardNumbers[i])
				{
					highestNumber=cardNumbers[i];
				}
			}
			
			List<Card>[] trail3=CardUtils.returnTrail(playerCards);
			if(trail3==null || trail3.length==0)
			{
				return null;
			}
			for (int j = 0; j < trail3.length; j++) {
				List<Card> cardList=trail3[j];
				if(GeneralUtils.getorderofcards(cardList.get(2).getNumber().getNumber(),listHistory)>highestNumber)
				{
					set.addAll(cardList);
				}
			}
			return set;
			
		}
		
		List<Card>[] listOfThree=CardUtils.returnSetOfThree(playerCards);
		if(listOfThree==null || listOfThree.length==0)
			set= null;
		if(listOfThree!=null)
		{
		for (int j = 0; j < listOfThree.length; j++) {
			List<Card> cardList=listOfThree[j];
			if(GeneralUtils.getorderofcards(cardList.get(0).getNumber().getNumber(),listHistory)>cardNumbers[0])
			{
				set.addAll(cardList);
			}
			
		}
		}
		if(jokerCard!=null && (set==null ||set.size()==0))
		{
			set= returnSetOfSizeTwo(playerCards, listHistory);
			set.add(jokerCard);
		}
		return set;
		
	}
	
	
	public static Set<Card>  returnSetOfSizeFour(Set<Card> playerCards,
			List<PlayHistory> listHistory)
	{
		Card jokerCard=GeneralUtils.getJoker(playerCards);
		Set<Card> set = new HashSet<Card>();
		Card cards[]=new Card[4];
		PlayHistory lastPlayerHistory;
		Set<Card> lastPlayerCards=null;
		int i=0;
		do{
			lastPlayerHistory=	listHistory.get(i);
			lastPlayerCards=lastPlayerHistory.getCard();
			i++;
		}while(lastPlayerCards==null);
		
		Iterator<Card> itr=lastPlayerCards.iterator();
		 i=0;
		while (itr.hasNext()) {
			Card card = (Card) itr.next();
			cards[i]=card;
			i++;
		}
		int cardNumbers[]=new int[4];
		for(i=0;i<4;i++)
		{
				cardNumbers[i]=GeneralUtils.getorderofcards(cards[i].getNumber().getNumber(),listHistory);
			
			
		}
		
		if(cards[0].getMark()==cards[1].getMark() && cards[1].getMark()==cards[2].getMark())
		{ 
			int highestNumber=cardNumbers[0];
			for(i=1;i<4;i++)
			{
				if(highestNumber<cardNumbers[i])
				{
					highestNumber=cardNumbers[i];
				}
			}
			
			List<Card>[] trail4=CardUtils.returnTrail4(playerCards);
			if(trail4==null || trail4.length==0)
			{
				return null;
			}
			for (int j = 0; j < trail4.length; j++) {
				List<Card> cardList=trail4[j];
				if(GeneralUtils.getorderofcards(cardList.get(2).getNumber().getNumber(),listHistory)>highestNumber)
				{
					set.addAll(cardList);
				}
			}
			return set;
			
		}
		
		List<Card>[] listOfFour=CardUtils.returnSetOfFour(playerCards);
		if(listOfFour==null || listOfFour.length==0)
			set= null;
		if(listOfFour!=null)
		{
		for (int j = 0; j < listOfFour.length; j++) {
			List<Card> cardList=listOfFour[j];
			if(GeneralUtils.getorderofcards(cardList.get(0).getNumber().getNumber(),listHistory)>cardNumbers[0])
			{
				set.addAll(cardList);
			}
			
		}
		}
		if(jokerCard!=null && (set==null ||set.size()==0))
		{
			set= returnSetOfSizeThree(playerCards, listHistory);
			set.add(jokerCard);
		}
		
		return set;
		
	}
	
	public static Set<Card>  returnSetOfSizeTwo_later(Set<Card> playerCards,
            List<PlayHistory> listHistory)
    {
        
        Set<Card> set = new HashSet<Card>();
        PlayHistory lastPlayerHistory;
        Set<Card> lastPlayerCards=null;
        int i=0;
        do{
            lastPlayerHistory=    listHistory.get(i);
            lastPlayerCards=lastPlayerHistory.getCard();
     i++;
        }while(lastPlayerCards==null);
        Card lastPlayerCard=lastPlayerCards.iterator().next();
        Card lastPlayerCard2=lastPlayerCards.iterator().next();
        List<Card>[] setOfTwo=CardUtils.returnSetOfTwo(playerCards);
        if(setOfTwo==null || setOfTwo.length==0)
            return null;
        
        
        for(int j=0;j<setOfTwo.length;j++)
        {
        Iterator<Card> tempItr=setOfTwo[j].iterator();
        
            Card card = (Card) tempItr.next();
            if(GeneralUtils.getorderofcards(card.getNumber().getNumber(),listHistory)>GeneralUtils.getorderofcards(lastPlayerCard.getNumber().getNumber(),listHistory))
            {    
                tempItr=setOfTwo[j].iterator();
                
                Card cardone = (Card) tempItr.next();
                Card cardtwo = (Card) tempItr.next();
                if((lastPlayerCard.getMark().equals(cardone.getMark()) && lastPlayerCard2.getMark().equals(cardtwo.getMark())) 
                        || (lastPlayerCard.getMark().equals(cardtwo.getMark()) && lastPlayerCard2.getMark().equals(cardone.getMark()))){

                    tempItr=setOfTwo[j].iterator();
                    
                    while(tempItr.hasNext())
                    {
                        
                        Card card1 = (Card) tempItr.next();
                        set.add(card1);
                    }
                    
                }
                
                break;
            }
            
        
    }            
        return set;
    }
	
	
}
