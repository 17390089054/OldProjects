package com.wrf.lx.classes;
import static java.lang.System.out;
import java.lang.Object;
public class ObjectTest {
	public String toString()
	{
		return "在"+getClass().getName()+"类中重写toString方法";
	}
	
	
	
	public static void main(String[] args) {
		String a="";
		String b="";
		System.out.println(a.equals(b));
		A a1=new A();
		A a2=new A();
		
		System.out.println(a1.equals(a2));
	}

}

/**
 * @author knight
 *
 */
class A{
	public boolean equals(Object o)
	{
		A a=new A();
		if(a==o)
		{
			return true;
		}
		return false;
	}
}
