#include <stdio.h>
int c=0;
void move(char x,int n,char z)
{
	printf("%i. Move Disk %i from %c to %c\n",++c,n,x,z);
}

void hanoi(int n,char x,char y,char z)
{
	if(n==1)
		move(x,1,z);
	else
	{
		hanoi(n-1,x,z,y);
		move(x,n,z);
		hanoi(n-1,y,x,z);
	}
}
void main()
{
	hanoi(3,'A','B','C');                                                                                                                                                                                                                                                                                                                         
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	
}