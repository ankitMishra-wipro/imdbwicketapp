package com.vinsys.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public abstract class BasePage extends WebPage {

	public BasePage() {

		Link movieLink = new Link("movies") {
			public void onClick() {
				setResponsePage(MoviePage.class);
			}

		};

		Link tvLink = new Link("television") {
			public void onClick() {
				setResponsePage(TelevisionPage.class);
			}

		};

		Link eventLink = new Link("events") {
			public void onClick() {
				setResponsePage(EventPage.class);
			}

		};

		Link login = new Link("login") {
			public void onClick() {
				setResponsePage(LoginPage.class);
			}

		};

		add(movieLink);
		add(tvLink);
		add(eventLink);
		add(login);

	}
}
