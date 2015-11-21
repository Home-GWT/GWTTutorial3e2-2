package com.gshocklab.contacts.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.gshocklab.contacts.client.ClientFactory;
import com.gshocklab.contacts.client.activity.ContactsActivity;
import com.gshocklab.contacts.client.activity.MailActivity;
import com.gshocklab.contacts.client.activity.TasksActivity;
import com.gshocklab.contacts.client.place.ContactsPlace;
import com.gshocklab.contacts.client.place.MailPlace;
import com.gshocklab.contacts.client.place.TasksPlace;

public class DemoActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	
	public DemoActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MailPlace) {
			return new MailActivity(clientFactory);
		} else if (place instanceof ContactsPlace) {
			return new ContactsActivity(clientFactory);
		} else if (place instanceof TasksPlace) {
			return new TasksActivity(clientFactory);
		}
		return null;
	}
}
