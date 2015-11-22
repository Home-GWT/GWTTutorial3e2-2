package com.gshocklab.contacts.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface MailView extends IsWidget {
	public void setPresenter(IMailPresenter presenter);
	public interface IMailPresenter {}
}
