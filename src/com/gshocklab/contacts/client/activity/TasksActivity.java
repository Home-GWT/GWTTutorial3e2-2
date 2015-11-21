package com.gshocklab.contacts.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gshocklab.contacts.client.ClientFactory;
import com.gshocklab.contacts.client.ClientLinks;
import com.gshocklab.contacts.client.view.TasksView;

public class TasksActivity extends Activity implements TasksView.ITasksPresenter {
	private ClientFactory clientFactory;
	
	public TasksActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		applyCurrentLinkStyle(ClientLinks.TASKS_LINK_ID);
		
		final TasksView view = clientFactory.getTasksView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
}
