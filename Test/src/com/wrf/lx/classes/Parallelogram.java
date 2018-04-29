package com.wrf.lx.classes;

class Quadrangle{
	private String name="四边形";
	public Quadrangle()
	{
		System.out.println("这是四边形");
	}
	
	
	public void draw(Quadrangle q)
	{
		System.out.println(q.name);
	}
	
	public int add(int...a)
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		return sum;
	}
	
	
}



public class Parallelogram  extends Quadrangle{
	String name="这是平行四边形";
	public static void main(String[] args) {
		
		Quadrangle q=new Quadrangle();
		if(q instanceof Parallelogram)
		{
			Parallelogram p=(Parallelogram)q;
		}
		System.out.println(q instanceof Quadrangle);
		System.out.println(q.add(1,2,3,4,5));
		
	/*	Parallelogram parallelogram = new Parallelogram();		
		q.draw(parallelogram);*/
	}
		
}
