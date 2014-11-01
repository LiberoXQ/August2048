package xq.august2048.entity;

import java.util.Random;

public class Cards 
{
	private static Cards cards = null;
	int[][] card = null;
	Random rand = null;
	
	public static Cards getInstance()
	{
		if(cards == null)cards = new Cards();
		return cards;
	}
	
	public int[][] getCard()
	{
		return card;
	}
	
	public void init()
	{
		card = new int[4][];
		for(int i = 0; i < 4; i++)
		{
			card[i] = new int[4];
			for(int j = 0; j < 4; j++)
			{
				card[i][j] = 0;
			}
		}
		rand = new Random(System.currentTimeMillis());
		getRandom();
		getRandom();
	}
	
	private Cards()
	{
		card = new int[4][];
		for(int i = 0; i < 4; i++)
		{
			card[i] = new int[4];
			for(int j = 0; j < 4; j++)
			{
				card[i][j] = 0;
			}
		}
		rand = new Random(System.currentTimeMillis());
		getRandom();
		getRandom();
	}
	
	private void getRandom()
	{
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		double p = rand.nextDouble();
		while(card[x][y] != 0)
		{
			x = rand.nextInt(16);
		}
		
		if(p < 0.6)card[x][y] = 1;
		else if(p < 0.8)card[x][y] = 2;
		else if(p < 0.9)card[x][y] = 3;
		else if(p < 0.95)card[x][y] = 4;
		else if(p < 0.975)card[x][y] = 5;
		else if(p < 0.9875)card[x][y] = 6;
		else if(p < 0.99375)card[x][y] = 7;
		else if(p < 0.996875)card[x][y] = 8;
		else if(p < 0.9984375)card[x][y] = 9;
		else card[x][y] = 10;
	}
}
