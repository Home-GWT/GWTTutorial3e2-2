package com.gshocklab.contacts.client.activity;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.gshocklab.contacts.client.ClientLinks;

public abstract class Activity extends AbstractActivity {
	private static Map<String, Element> navLinks = new LinkedHashMap<String, Element>();
	static {
		navLinks.put(ClientLinks.MAIL_LINK_ID, DOM.getElementById(ClientLinks.MAIL_LINK_ID));
		navLinks.put(ClientLinks.CONTACTS_LINK_ID, DOM.getElementById(ClientLinks.CONTACTS_LINK_ID));
		navLinks.put(ClientLinks.TASKS_LINK_ID, DOM.getElementById(ClientLinks.TASKS_LINK_ID));
	}
	
	public void applyCurrentLinkStyle(String viewId){
		for( String linkId:navLinks.keySet() ){
			final Element link = navLinks.get(linkId);
			if( link == null)
				continue;
			if( linkId.equals(viewId) )
				link.addClassName("b-current");
			else
				link.removeClassName("b-current");
		}
	}
}
