package com.gshocklab.contacts.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ContactsView extends IsWidget {
	public interface IContactsPresenter {}
	public void setPresenter(IContactsPresenter presenter);
}
