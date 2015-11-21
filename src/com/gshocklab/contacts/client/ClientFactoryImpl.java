package com.gshocklab.contacts.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.gshocklab.contacts.client.view.ContactsView;
import com.gshocklab.contacts.client.view.ContactsViewImpl;
import com.gshocklab.contacts.client.view.MailView;
import com.gshocklab.contacts.client.view.MailViewImpl;
import com.gshocklab.contacts.client.view.TasksView;
import com.gshocklab.contacts.client.view.TasksViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	private final EventBus               eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	
	private final MailView              mailView = new MailViewImpl();
	private final ContactsView      contactsView = new ContactsViewImpl();
	private final TasksView            tasksView = new TasksViewImpl();
	
	@Override public EventBus               getEventBus() { return eventBus; }
	@Override public PlaceController getPlaceController() { return placeController; }
	@Override public MailView               getMailView() { return mailView; }
	@Override public ContactsView       getContactsView() { return contactsView; }
	@Override public TasksView             getTasksView() { return tasksView;}
}
