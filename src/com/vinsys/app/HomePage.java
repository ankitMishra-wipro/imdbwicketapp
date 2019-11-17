package com.vinsys.app;

import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage{
	
	public HomePage(){
		CompressedResourceReference jsResource = 
				new CompressedResourceReference(HomePage.class, "mainDefault.js");
		
		FeedbackPanel feedbackPanel = new FeedbackPanel("errMsg");
		
		Label label = new Label("label","My Wicket First label");
		Link link = new Link("myLink") {
			 @Override
			public void onClick(){
				 setResponsePage(Greetings.class);
			 }
		};
		Form form = new Form("myFirstLoginForm");
		Model userNameModel = new Model();
		TextField text = new TextField("userText",userNameModel);
		form.add(text);
		text.add(new UserNameValidator());
		Button button = new Button("button"){
			@Override
			public void onSubmit(){
				System.out.println("my entered text "+userNameModel.getObject());
				setResponsePage(Greetings.class);
			}
		};
		
		form.add(button);
		add(label);
		add(link);
		add(form);	
		add(JavascriptPackageResource.getHeaderContribution(jsResource));
		add(feedbackPanel);
	}
	
	/*public HomePage(PageParameters parameters){		
		super(parameters);	
	}*/

}
