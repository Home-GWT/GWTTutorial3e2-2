package com.gshocklab.contacts.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.gshocklab.contacts.client.place.ContactsPlace;
import com.gshocklab.contacts.client.place.MailPlace;
import com.gshocklab.contacts.client.place.TasksPlace;

@WithTokenizers({MailPlace.Tokenizer.class, ContactsPlace.Tokenizer.class, TasksPlace.Tokenizer.class})
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}
