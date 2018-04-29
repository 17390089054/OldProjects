package com.wrf.lx.classes;
import static java.lang.System.out;
public class Test01 {
	public Test01()
	{
		out.println("调用父类的构造方法");
	}
	void GoodNight(String s)
	{
		out.println("GoodNight Bye!");
	}
	private Test01 getResult()
	{
		return new Test01();
	}
	public void sayHello()
	{
		out.println("Hello World!");
	}
		public static void main(String[] args) {
			Test02 t=new Test02();
			/*t.GoodNight("");*/
			t.getResult();
		}
}

 class Test02 extends Test01{
	public  Test02()
	{
		out.println("调用子类的构造方法");
	}
	Test02 getResult()
	{
		return new Test02();
	}
	
	
	public void GoodNight(String s)
	{
		super.sayHello();
		super.GoodNight("");
		out.println("GoodNight Guy!");
	}
	
}