package com.gshocklab.contacts.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface TasksView extends IsWidget {
	
	public void setPresenter(ITasksPresenter presenter);
	
	public interface ITasksPresenter {
	}
}
