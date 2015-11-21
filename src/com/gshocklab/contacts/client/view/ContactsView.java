package com.gshocklab.contacts.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ContactsView extends IsWidget {
	public void setPresenter(IContactsPresenter presenter);
	
	public interface IContactsPresenter {
	}
}
