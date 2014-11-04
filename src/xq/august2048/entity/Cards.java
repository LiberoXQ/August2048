package xq.august2048.entity;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class Cards implements Serializable
{
	private static int RETRY = 50;
	private static Cards cards = null;
	private int[][] card = null;
	private Random rand = null;
	private boolean playing = true;
	
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
		playing = true;
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
	
	public void stepLeft()
	{
		int[] temp = new int[4];
		int[][] last = new int[4][];
		int point = 0;
//		boolean flag = false;
		for(int i = 0; i < 4; i++)
		{
			point = 0;
//			flag = false;
			last[i] = new int[4];
			for(int j = 0; j < 4; j++)
			{
				last[i][j] = card[i][j];
//				if(flag == false)
//				{
					if(card[i][j] == 0)
						continue;
					else if(point == 0)
					{
						temp[point] = card[i][j];
						point++;
					}
					else if(temp[point - 1] == card[i][j])
					{
						temp[point - 1]++;
//						flag = true;
					}
					else
					{
						temp[point] = card[i][j];
						point++;
					}
//				}
//				else
//				{
//					temp[point] = card[i][j];
//					point++;
//				}
			}
			for(int j = 0; j < 4; j++)
			{
				card[i][j] = temp[j];
				temp[j] = 0;
			}
		}
		boolean change = false;
		boolean full = true;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(card[i][j] != last[i][j])
					change = true;
				if(card[i][j] == 0)
					full = false;
			}
		}
		if(change == true && full == false)
		{
			rand = new Random(System.currentTimeMillis());
			getRandom();
		}
	}
	
	public void stepRight()
	{
		int[] temp = new int[4];
		int point = 0;
//		boolean flag = false;
		int[][] last = new int[4][];
		for(int i = 0; i < 4; i++)
		{
			point = 3;
//			flag = false;
			last[i] = new int[4];
			for(int j = 3; j >= 0; j--)
			{
				last[i][j] = card[i][j];
//				if(flag == false)
//				{
					if(card[i][j] == 0)
						continue;
					else if(point == 3)
					{
						temp[point] = card[i][j];
						point--;
					}
					else if(temp[point + 1] == card[i][j])
					{
						temp[point + 1]++;
//						flag = true;
					}
					else
					{
						temp[point] = card[i][j];
						point--;
					}
//				}
//				else
//				{
//					temp[point] = card[i][j];
//					point--;
//				}
			}
			for(int j = 3; j >= 0; j--)
			{
				card[i][j] = temp[j];
				temp[j] = 0;
			}
		}
		boolean change = false;
		boolean full = true;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(card[i][j] != last[i][j])
					change = true;
				if(card[i][j] == 0)
					full = false;
			}
		}
		if(change == true && full == false)
		{
			rand = new Random(System.currentTimeMillis());
			getRandom();
		}		
	}
	
	public void stepUp()
	{
		int[] temp = new int[4];
		int point = 0;
//		boolean flag = false;
		int[][] last = new int[4][];
		for(int i = 0; i < 4; i++)
		{
			point = 0;
//			flag = false;
			last[i] = new int[4];
			for(int j = 0; j < 4; j++)
			{
				last[i][j] = card[i][j];
//				if(flag == false)
//				{
					if(card[j][i] == 0)
						continue;
					else if(point == 0)
					{
						temp[point] = card[j][i];
						point++;
					}
					else if(temp[point - 1] == card[j][i])
					{
						temp[point - 1]++;
//						flag = true;
					}
					else
					{
						temp[point] = card[j][i];
						point++;
					}
//				}
//				else
//				{
//					temp[point] = card[j][i];
//					point++;
//				}
			}
			for(int j = 0; j < 4; j++)
			{
				card[j][i] = temp[j];
				temp[j] = 0;
			}
		}
		boolean change = false;
		boolean full = true;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(card[i][j] != last[i][j])
					change = true;
				if(card[i][j] == 0)
					full = false;
			}
		}
		if(change == true && full == false)
		{
			rand = new Random(System.currentTimeMillis());
			getRandom();
		}
	}
	
	public void stepDown()
	{
		int[] temp = new int[4];
		int point = 0;
//		boolean flag = false;
		int[][] last = new int[4][];
		for(int i = 0; i < 4; i++)
		{
			point = 3;
//			flag = false;
			last[i] = new int[4];
			for(int j = 3; j >= 0; j--)
			{
				last[i][j] = card[i][j];
//				if(flag == false)
//				{
					if(card[j][i] == 0)
						continue;
					else if(point == 3)
					{
						temp[point] = card[j][i];
						point--;
					}
					else if(temp[point + 1] == card[j][i])
					{
						temp[point + 1]++;
//						flag = true;
					}
					else
					{
						temp[point] = card[j][i];
						point--;
					}
//				}
//				else
//				{
//					temp[point] = card[j][i];
//					point--;
//				}
			}
			for(int j = 3; j >= 0; j--)
			{
				card[j][i] = temp[j];
				temp[j] = 0;
			}
		}
		boolean change = false;
		boolean full = true;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(card[i][j] != last[i][j])
					change = true;
				if(card[i][j] == 0)
					full = false;
			}
		}
		if(change == true && full == false)
		{
			rand = new Random(System.currentTimeMillis());
			getRandom();
		}		
	}
	
	public int getScore()
	{
		int score = 0;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(card[i][j] == 0)
					continue;
				else
					score += (int)Math.pow((double)2, (double)card[i][j]);
			}
		}
		return score;
	}
	
	public boolean getPlaying()
	{
		return playing;
	}
	
	public boolean whetherSuccessful()
	{
		if(card == null)
			return false;
		else
		{
			for(int i = 0; i < 4; i++)
			{
				for(int j = 0; j < 4; j++)
				{
					if(card[i][j] == 11)
					{
						playing = false;
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public boolean whetherFailed()
	{
		if(card == null)
			return true;
		else
		{
			int flagX = 12;
			int flagY = 12;
			for(int i = 0; i < 4; i++)
			{
				flagX = Integer.MAX_VALUE;
				flagY = Integer.MAX_VALUE;
				for(int j = 0; j < 4; j++)
				{
					//有空则没死
					if(card[i][j] == 0)
						return false;
					//同行有相邻的两个相同则没死
					if(flagX == Integer.MAX_VALUE)
						flagX = card[i][j];
					else if(flagX == card[i][j])
						return false;
					else
						flagX = card[i][j];
					//同列有相邻的两个相同则没死
					if(flagY == Integer.MAX_VALUE)
						flagY = card[j][i];
					else if(flagY == card[j][i])
						return false;
					else
						flagY = card[j][i];
				}
			}
			playing = false;
			return true;
		}
	}
	
	public void exchage(int[] img)
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				card[i][j] = img[i * 4 + j];
			}
		}
	}
	
	private Cards()
	{
		playing = true;
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
	
	private boolean getRandom()
	{
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		int retry = 0;
		double p = rand.nextDouble();
		
		for(retry = 0; card[x][y] != 0 && retry < Cards.RETRY; retry++)
		{
			x = rand.nextInt(4);
			y = rand.nextInt(4);
		}
		
		if(retry == Cards.RETRY)
		{
			return false;
		}
		else
		{
			if(p < 0.8)
				card[x][y] = 1;
			else if(p < 0.9)
				card[x][y] = 2;
			else if(p < 0.95)
				card[x][y] = 3;
			else if(p < 0.975)
				card[x][y] = 4;
			else if(p < 0.9875)
				card[x][y] = 5;
			else if(p < 0.99375)
				card[x][y] = 6;
			else if(p < 0.996875)
				card[x][y] = 7;
			else if(p < 0.9984375)
				card[x][y] = 8;
			else if(p < 0.99921875)
				card[x][y] = 9;
			else
				card[x][y] = 10;
		
			return true;
		}
	}
}
