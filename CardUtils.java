package jp.co.worksap.ate.cardgame.ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.co.worksap.ate.cardgame.player.Card;
import jp.co.worksap.ate.cardgame.player.Card.Mark;
import jp.co.worksap.ate.cardgame.player.Card.Number;

public class CardUtils {
	
	public static List<Card>[] returnSetOfFour(Set<Card> playerCards)
	{
		int[] cardCountArray=new int[14];
		Map<Integer,Integer> indexOfArray=new HashMap<Integer,Integer>();
		int cardCount=0;
		List<Card>[] listOfCard;
			Iterator<Card> iterate=playerCards.iterator();
		int val=0;
		
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			cardCountArray[val]++;	
		}
		
		for (int i = 0; i < cardCountArray.length; i++) {
			if(cardCountArray[i]==4)
			{
				indexOfArray.put(i,cardCount);
				cardCount++;
			}
		}
		if(cardCount==0)
			return null;
		
		listOfCard=new List[cardCount];
		for(int i=0;i<cardCount;i++)
		{
			listOfCard[i]=new ArrayList<Card>();
		}
		iterate=playerCards.iterator();
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			//val=num.getNumber();
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			if(indexOfArray.containsKey(val))
					{
						listOfCard[indexOfArray.get(val)].add(card);
					}
			
		}
		
		
		return listOfCard;
		
		
		
	}

	public static List<Card>[] returnSetOfThree(Set<Card> playerCards)
	{
		int[] cardCountArray=new int[14];
		Map<Integer,Integer> indexOfArray=new HashMap<Integer,Integer>();
		int cardCount=0;
		List<Card>[] listOfCard;
			Iterator<Card> iterate=playerCards.iterator();
		int val=0;
		
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			cardCountArray[val]++;	
		}
		
		for (int i = 0; i < cardCountArray.length; i++) {
			if(cardCountArray[i]==3)
			{
				indexOfArray.put(i,cardCount);
				cardCount++;
			}
		}
		if(cardCount==0)
			return null;
		
		listOfCard=new List[cardCount];
		for(int i=0;i<cardCount;i++)
		{
			listOfCard[i]=new ArrayList<Card>();
		}
		iterate=playerCards.iterator();
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			//val=num.getNumber();
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			if(indexOfArray.containsKey(val))
					{
						listOfCard[indexOfArray.get(val)].add(card);
					}
			
		}
		
		
		return listOfCard;
		
		
		
	}
	
	public static List<Card>[] returnSetOfTwo(Set<Card> playerCards)
	{
		int[] cardCountArray=new int[14];
		Map<Integer,Integer> indexOfArray=new HashMap<Integer,Integer>();
		int cardCount=0;
		List<Card>[] listOfCard;
			Iterator<Card> iterate=playerCards.iterator();
		int val=0;
		
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			cardCountArray[val]++;	
		}
		
		for (int i = 0; i < cardCountArray.length; i++) {
			if(cardCountArray[i]==2)
			{
				indexOfArray.put(i,cardCount);
				cardCount++;
			}
		}
		if(cardCount==0)
			return null;
		
		listOfCard=new List[cardCount];
		for(int i=0;i<cardCount;i++)
		{
			listOfCard[i]=new ArrayList<Card>();
		}
		iterate=playerCards.iterator();
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			Number num=card.getNumber();
			//val=num.getNumber();
			if(num.getNumber()==Number.TWO.getNumber())
			{
				val=13;
			}
			else if(num.getNumber()==Number.ACE.getNumber())
			{
				val=12;
			}
			else if(num.getNumber()==Number.JOKER.getNumber())
			{
				val=0;
			}
			else
			{
				val=num.getNumber()-2;
			}
			if(indexOfArray.containsKey(val))
					{
						listOfCard[indexOfArray.get(val)].add(card);
					}
			
		}
		
		
		return listOfCard;
		
		
		
	}
	
	public static TreeMap<Card,Integer> sortSet(Set<Card> playerCards)
	{
		//SortedSet<Card> newSet=new TreeSet<Card>();
		Iterator<Card> iterate=playerCards.iterator();
		Map<Card,Integer> map=new HashMap<Card, Integer>();
		ValueComparator bvc =  new ValueComparator(map);
		
		TreeMap<Card,Integer> st=new TreeMap<Card,Integer>(bvc);
		int var=0;
		while (iterate.hasNext()) {
			Card card = (Card) iterate.next();
			var=card.getNumber().getNumber();
			if(var==0)
			{
				var=16;
			}
			if(var==2)
			{
				var=15;
			}
			else if(var==1)
			{
				var=14;
			}
			map.put(card, var);
			
			
		}
		st.putAll(map);
		return st;
		
	}
	
	public static List<Card>[] returnSetOfOne(Set<Card> playerCards)
	{
		TreeMap<Card,Integer> sortSet=sortSet(playerCards);
		Iterator<Card> itr=sortSet.keySet().iterator();
		List<Card>[] listSetOne=new LinkedList[playerCards.size()];
		Card card=null;
		int i=0;
		while (itr.hasNext()) {
			 card = (Card) itr.next();
			 listSetOne[i]=new LinkedList<Card>();
			 listSetOne[i].add(card);
			 i++;
		}
		return listSetOne;
	}
	
	
	
	
	public static List<Card>[] returnTrail(Set<Card> playerCards)
	{
		TreeMap<Card,Integer> sortSet=sortSet(playerCards);
		//Linked
		//int sortCount=0;
		int countMark[]=new int[4];
		int lastValue[]=new int[4];
		List<Card>[] listCard=new LinkedList[4];
		List<Card>[] tempListToBeReturned=new LinkedList[20];
		int numberOfTrails=0;
		for(int i=0;i<listCard.length;i++)
		{
			listCard[i]=new LinkedList<Card>();
		}
		Iterator<Card> itr=sortSet.keySet().iterator();
		Card card=null;
		while (itr.hasNext()) {
			 card = (Card) itr.next();
			 int cardNumber=card.getNumber().getNumber();
			 if(cardNumber==Number.ACE.getNumber())
			 {
				 cardNumber=14;
			 }
			 else if(cardNumber==Number.TWO.getNumber())
			 {
				 cardNumber=15;
			 }
			 
			 else if(cardNumber==Number.JOKER.getNumber())
			 {
				 cardNumber=16;
			 }
			 
			
			 
			 if(card.getMark()==Mark.CLUB)
			 {
				 if(lastValue[0]==(cardNumber-1))
				 {
					 listCard[0].add(card);
					 countMark[0]++;
				 }
				 else{
					 countMark[0]=1;
					 listCard[0].clear();
					 listCard[0].add(card);
				 }
				 lastValue[0]=cardNumber;
			 }
			 else if(card.getMark()==Mark.DIA)
			 {
				 if(lastValue[1]==(cardNumber-1))
				 {
					 listCard[1].add(card);
					 countMark[1]++;
				 }
				 else{
					 countMark[1]=1;
					 listCard[1].clear();
					 listCard[1].add(card);
				 }
				 lastValue[1]=cardNumber;
			 }
			 else if(card.getMark()==Mark.HEART)
			 {
				 if(lastValue[2]==(cardNumber-1))
				 {
					 listCard[2].add(card);
					 countMark[2]++;
				 }
				 else{
					 countMark[2]=1;
					 listCard[2].clear();
					 listCard[2].add(card);
				 }
				 lastValue[2]=cardNumber;
			 }
			 else if(card.getMark()==Mark.SPADE)
			 {
				 if(lastValue[3]==(cardNumber-1))
				 {
					 listCard[3].add(card);
					 countMark[3]++;
				 }
				 else{
					 countMark[3]=1;
					 listCard[3].clear();
					 listCard[3].add(card);
				 }
				 lastValue[3]=cardNumber;
			 }
			
			 for(int j=0;j<4;j++)
			 {
				 if(countMark[j]==3)
				 {
					 tempListToBeReturned[numberOfTrails]=listCard[j];
					// System.out.println(listCard[j]);
				//	 System.out.println(tempListToBeReturned[numberOfTrails]);
					 //System.out.println("0:"+tempListToBeReturned[numberOfTrails].get(0));
					 listCard[j]=new LinkedList<Card>();
					listCard[j].add(tempListToBeReturned[numberOfTrails].get(1));
					 listCard[j].add(tempListToBeReturned[numberOfTrails].get(2));
					 numberOfTrails++;
					 countMark[j]=2;
				 }
			 }
			 
			
		}
		List<Card>[] listToBeReturned=new List[numberOfTrails];
		for(int j=0;j<numberOfTrails;j++)
		{
			listToBeReturned[j]=tempListToBeReturned[j];
		}
		
		return listToBeReturned;
	}
	
	

	public static List<Card>[] returnTrail4(Set<Card> playerCards)
	{
		TreeMap<Card,Integer> sortSet=sortSet(playerCards);
		//Linked
		//int sortCount=0;
		int countMark[]=new int[4];
		int lastValue[]=new int[4];
		List<Card>[] listCard=new LinkedList[4];
		List<Card>[] tempListToBeReturned=new LinkedList[20];
		int numberOfTrails=0;
		for(int i=0;i<listCard.length;i++)
		{
			listCard[i]=new LinkedList<Card>();
		}
		Iterator<Card> itr=sortSet.keySet().iterator();
		Card card=null;
		while (itr.hasNext()) {
			 card = (Card) itr.next();
			 int cardNumber=card.getNumber().getNumber();
			 if(cardNumber==Number.ACE.getNumber())
			 {
				 cardNumber=14;
			 }
			 else if(cardNumber==Number.TWO.getNumber())
			 {
				 cardNumber=15;
			 }
			 
			 else if(cardNumber==Number.JOKER.getNumber())
			 {
				 cardNumber=16;
			 }
			 
			
			 
			 if(card.getMark()==Mark.CLUB)
			 {
				 if(lastValue[0]==(cardNumber-1))
				 {
					 listCard[0].add(card);
					 countMark[0]++;
				 }
				 else{
					 countMark[0]=1;
					 listCard[0].clear();
					 listCard[0].add(card);
				 }
				 lastValue[0]=cardNumber;
			 }
			 else if(card.getMark()==Mark.DIA)
			 {
				 if(lastValue[1]==(cardNumber-1))
				 {
					 listCard[1].add(card);
					 countMark[1]++;
				 }
				 else{
					 countMark[1]=1;
					 listCard[1].clear();
					 listCard[1].add(card);
				 }
				 lastValue[1]=cardNumber;
			 }
			 else if(card.getMark()==Mark.HEART)
			 {
				 if(lastValue[2]==(cardNumber-1))
				 {
					 listCard[2].add(card);
					 countMark[2]++;
				 }
				 else{
					 countMark[2]=1;
					 listCard[2].clear();
					 listCard[2].add(card);
				 }
				 lastValue[2]=cardNumber;
			 }
			 else if(card.getMark()==Mark.SPADE)
			 {
				 if(lastValue[3]==(cardNumber-1))
				 {
					 listCard[3].add(card);
					 countMark[3]++;
				 }
				 else{
					 countMark[3]=1;
					 listCard[3].clear();
					 listCard[3].add(card);
				 }
				 lastValue[3]=cardNumber;
			 }
			
			 for(int j=0;j<4;j++)
			 {
				 if(countMark[j]==4)
				 {
					 tempListToBeReturned[numberOfTrails]=listCard[j];
					// System.out.println(listCard[j]);
				//	 System.out.println(tempListToBeReturned[numberOfTrails]);
					 //System.out.println("0:"+tempListToBeReturned[numberOfTrails].get(0));
					 listCard[j]=new LinkedList<Card>();
					listCard[j].add(tempListToBeReturned[numberOfTrails].get(1));
					 listCard[j].add(tempListToBeReturned[numberOfTrails].get(2));
					 listCard[j].add(tempListToBeReturned[numberOfTrails].get(3));
					 numberOfTrails++;
					 countMark[j]=3;
				 }
			 }
			 
			
		}
		List<Card>[] listToBeReturned=new List[numberOfTrails];
		for(int j=0;j<numberOfTrails;j++)
		{
			listToBeReturned[j]=tempListToBeReturned[j];
		}
		
		return listToBeReturned;
	}
	
	
	
	public static class ValueComparator implements Comparator<Card> {

		Map<Card, Integer> base;
	    public ValueComparator(Map<Card, Integer> base) {
	        this.base = base;
	    }

	    // Note: this comparator imposes orderings that are inconsistent with equals.    
	    public int compare(Card a, Card b) {
	    	
	        if (base.get(a) <= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } // returning 0 would merge keys
	    }
	}
	
}
