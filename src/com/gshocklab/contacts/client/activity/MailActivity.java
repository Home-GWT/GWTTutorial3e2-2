package com.gshocklab.contacts.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gshocklab.contacts.client.ClientFactory;
import com.gshocklab.contacts.client.ClientLinks;
import com.gshocklab.contacts.client.view.MailView;

public class MailActivity extends Activity implements MailView.IMailPresenter {
	private ClientFactory clientFactory;
	
	public MailActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		applyCurrentLinkStyle(ClientLinks.MAIL_LINK_ID);
		
		final MailView view = clientFactory.getMailView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
