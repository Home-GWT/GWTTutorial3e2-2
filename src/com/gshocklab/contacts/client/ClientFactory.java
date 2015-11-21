package com.gshocklab.contacts.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.gshocklab.contacts.client.view.ContactsView;
import com.gshocklab.contacts.client.view.MailView;
import com.gshocklab.contacts.client.view.TasksView;

public interface ClientFactory {
	public EventBus               getEventBus();
	public PlaceController getPlaceController();
	
	public MailView              getMailView();
	public ContactsView      getContactsView();
	public TasksView            getTasksView();
}
