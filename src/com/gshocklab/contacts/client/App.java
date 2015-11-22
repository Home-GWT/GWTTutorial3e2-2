package com.gshocklab.contacts.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.gshocklab.contacts.client.mvp.DemoActivityMapper;
import com.gshocklab.contacts.client.mvp.AppPlaceHistoryMapper;
import com.gshocklab.contacts.client.place.MailPlace;
import com.gshocklab.contacts.client.view.AppLayoutImpl;

public class App implements EntryPoint {
	
	private SimplePanel      containerWidget;
	private MailPlace           defaultPlace = new MailPlace();
	
	@Override
	public void onModuleLoad() {
		final AppLayoutImpl       mainLayout = new AppLayoutImpl();
		containerWidget                      = mainLayout.getAppContentHolder();
		
		final ClientFactory    clientFactory = GWT.create(ClientFactoryImpl.class);
		EventBus                    eventBus = clientFactory.getEventBus();
		PlaceController      placeController = clientFactory.getPlaceController();
		
		// Активировать Activity-менеджер и проинициализировать отображение
		ActivityMapper        activityMapper = new DemoActivityMapper(clientFactory);
		ActivityManager      activityManager = new ActivityManager(activityMapper,eventBus);
		activityManager.setDisplay(containerWidget);
		// Дефолтное отображение <вида> (страницы) с активированным обработчиком истории
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler   historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController,eventBus,defaultPlace);
		
		RootLayoutPanel.get().add(mainLayout);
		History.newItem("mail:");
	}
}
