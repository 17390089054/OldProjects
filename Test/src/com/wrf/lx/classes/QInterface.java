package com.wrf.lx.classes;
interface drawTest
{
	public void draw();
}

class Pinterface extends QInterface implements drawTest
{
	public void draw()
	{
		System.out.println("平行四边形.draw()");
	}
	public void doNothing()
	{
		System.out.println("你好");
	}
	

}

class SInterface extends QInterface implements drawTest
{
	public void draw()
	{
		System.out.println("正方形.draw()");
	}
	public void doNothing()
	{
		System.out.println("滚犊子");
	}
	
}


public class QInterface {
	public void doNothing()
	{
		System.out.println("草拟吗");
	}
	public static void main(String[] args) {
		drawTest[]d={new Pinterface(),new SInterface()};
		for(int i=0;i<d.length;i++)
			d[i].draw();
	}     
	
	
	
}



