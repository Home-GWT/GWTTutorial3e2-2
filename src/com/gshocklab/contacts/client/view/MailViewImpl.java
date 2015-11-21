package com.gshocklab.contacts.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MailViewImpl extends Composite implements MailView {
	interface MailViewUiBinder extends UiBinder<Widget, MailViewImpl> {	}
	private static MailViewUiBinder uiBinder = GWT.create(MailViewUiBinder.class);
	
	private IMailPresenter presenter;

	public MailViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(IMailPresenter presenter) {
		this.presenter = presenter;
	}
}
