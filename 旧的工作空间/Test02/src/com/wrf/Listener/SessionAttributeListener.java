package com.wrf.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�����һ��attribute");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ɾ����һ��attribute");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�滻��һ��attribute");
	}

}
