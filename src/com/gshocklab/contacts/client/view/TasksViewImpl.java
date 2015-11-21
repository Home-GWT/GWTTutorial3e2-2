package com.gshocklab.contacts.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TasksViewImpl extends Composite implements TasksView {
	interface TasksViewUiBinder extends UiBinder<Widget, TasksViewImpl> { }
	private static TasksViewUiBinder uiBinder = GWT.create(TasksViewUiBinder.class);
	
	private ITasksPresenter presenter;

	public TasksViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(ITasksPresenter presenter) {
		this.presenter = presenter;
	}
}
