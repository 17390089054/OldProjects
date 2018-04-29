package com.wrf.lx.classes;

public class OutClass {
	public OutClass()
	{
		System.out.println("这是outClass");
	}
	
	inClass in =new inClass();
	
	class inClass{
		public inClass(){System.out.println("这是inClass");}
	public void inf()
	{
		System.out.println("这是inClass的方法");
	}
		int y=0;
	}		
	
	public void outf()
	{
		System.out.println("在outClass的方法内");
		in.inf();
	}
	
	public inClass doit()
	{
		int y=4;
		return new inClass();
	}

	public static void main(String[] args) {
		OutClass out=new OutClass();
		OutClass.inClass in =out.doit();
		OutClass.inClass in2=out.new inClass();
		System.out.println(in.getClass());
		System.out.println(in2.getClass());
	
	}
	
}
