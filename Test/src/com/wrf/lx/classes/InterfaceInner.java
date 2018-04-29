package com.wrf.lx.classes;

import com.wrf.lx.classes.OutClass.inClass;

interface OutInterface{
	public void f();
}
public class InterfaceInner {
	public static void main(String[] args) {
		OuterClass out=new OuterClass();
		OutInterface outInterface = out.doit();
		outInterface.f();
		
		OutInterface2 out2=new OutClass3().doit("哈哈哈");
		OutInterface2 out3=new OuterClass4().doit();
	}
}
class OuterClass{
	private class innerClass implements OutInterface{
		innerClass(String s){
			System.out.println(s);
		}
		public void f()
		{
			System.out.println("访问innerClass中的f()方法");
		}
		
	}
	public OutInterface doit()
	{
		return new innerClass("访问内部类的构造方法");
	}
	
}

interface OutInterface2{

}
class OutClass3{
	public OutInterface2 doit(final String x)
	{
		class innerClass2 implements OutInterface2{
			innerClass2(String s)
			{
				s=x;
				System.out.println(s);
			}
		}
		return new innerClass2("do it");
		
	}
}

class OuterClass4{
	public OutInterface2 doit(){
		return new OutInterface2(){
			private int i=5;
			public int getValue()
			{
				return i;
			}
		};
		
		
	}
	
	
	
}


