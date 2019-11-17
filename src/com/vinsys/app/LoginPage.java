package com.vinsys.app;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage {

	public LoginPage() {
		System.out.println("Login Page loaded.....");
		ModalWindow helpWindow = new ModalWindow("help");
		helpWindow.setPageCreator(new ModalWindow.PageCreator() {

			@Override
			public Page createPage() {
				// TODO Auto-generated method stub
				return new CopyRightPage();
			}
		});
		helpWindow.setTitle(new Model("Help"));
		helpWindow.setOutputMarkupId(true);
		AjaxLink help = new AjaxLink("help_link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				helpWindow.show(target);
			}
		};
		FeedbackPanel feedbackPanel = new FeedbackPanel("loginErrMsg");
		User user = new User();
		Form loginForm = new Form("loginForm");
		Label username_lable = new Label("username_lable");
		Label password_lable = new Label("password_lable");
		TextField<String> uname_text = new TextField<String>("userName", new PropertyModel<>(user, "username"));
		uname_text.setRedirect(true);
		PasswordTextField password_text = new PasswordTextField("password", new PropertyModel<>(user, "password"));
		password_text.setRedirect(true);
		Button loginButton = new Button("login_button") {
			public void onSubmit() {
				super.onSubmit();
				System.out.println("login concerns");
				getApplication().getSessionStore().setAttribute(getRequest(), "logged in", "logged_in");
				System.out.println(user.getUsername() + " " + user.getPassword());
				setResponsePage(NewHomePage.class);
			}
		};
		add(loginForm);
		add(feedbackPanel);
		loginForm.add(username_lable);
		loginForm.add(password_lable);
		loginForm.add(uname_text);
		loginForm.add(password_text);
		loginForm.add(loginButton);
		add(help);
		add(helpWindow);
		
		IColumn[] columns = new IColumn[2];
		columns[0]= new PropertyColumn<>(new Model("Username"), "Username", "Username");
		columns[1]= new PropertyColumn<>(new Model("Password"), "Password", "Password");
		DefaultDataTable table = new DefaultDataTable<>("datatable", columns, new UserDataProvider(), 10);
		add(table);
	}

}
