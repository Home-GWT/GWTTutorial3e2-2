package com.gshocklab.contacts.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gshocklab.contacts.client.ClientFactory;
import com.gshocklab.contacts.client.ClientLinks;
import com.gshocklab.contacts.client.view.ContactsView;

public class ContactsActivity extends Activity implements ContactsView.IContactsPresenter {
	private ClientFactory clientFactory;
	
	public ContactsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		applyCurrentLinkStyle(ClientLinks.CONTACTS_LINK_ID);
		
		final ContactsView view = clientFactory.getContactsView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
