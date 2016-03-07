package gaoXiaoBang;


class FuShu
{
	public double real;
	public double image;
	
	public FuShu()
	{
		real = 0;
		image = 0;
	}
	
	public FuShu(double r, double i)
	{
		real = r;
		image = i;
	}
	
	public FuShu dot(FuShu x)
	{
		FuShu r = new FuShu();
		r.real = real * x.real - image * x.image;
		r.image = real * x.image + image * x.real;
		return r;
	}
	
	public FuShu dot(double r, double i)
	{
		FuShu t = new FuShu();
		t.real = real * r - image * i;
		t.image = real * i + image * r;
		return t;
	}	
}

class Robot 
{
	private int x = 0;
	private int y = 0;
	private FuShu dir = new FuShu(1,0);
	
	public void walk(String s)
	{
		int sum = 0;
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(c=='L' || c=='R')
			{
				x += sum * dir.real;
				y += sum * dir.image;
				sum = 0;
				if(c=='L')
					dir = dir.dot(0,1);
				else
					dir = dir.dot(0,-1);
				
			}
			else
				sum = sum * 10 + (c-'0');
			
		}
		
		x += sum * dir.real;
		y += sum * dir.image;		
	}
	
	public void show()
	{
		double d = Math.sqrt(x*x + y*y);
		System.out.println(x+","+y + "  dir: " + dir.real + "," + dir.image + ", d=" + d);
	}
}

public class 第二章老师程序_机器人行走
{
	public static void main(String[] args) throws Exception
	{
		Robot t = new Robot();
		t.walk("3R4");
		t.show();
	}
}