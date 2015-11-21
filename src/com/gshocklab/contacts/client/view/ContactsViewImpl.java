package com.gshocklab.contacts.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactsViewImpl extends Composite implements ContactsView {
	interface ContactsViewUiBinder extends UiBinder<Widget, ContactsViewImpl> {	}
	private static ContactsViewUiBinder uiBinder = GWT.create(ContactsViewUiBinder.class);
	
	private IContactsPresenter presenter;
	
	public ContactsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(IContactsPresenter presenter) {
		this.presenter = presenter;
	}
}
