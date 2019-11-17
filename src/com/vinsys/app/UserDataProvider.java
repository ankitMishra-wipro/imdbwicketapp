package com.vinsys.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserDataProvider extends SortableDataProvider<User>{
	
	List<User> userdb = new ArrayList<User>();
	
	public  UserDataProvider() {
		// TODO Auto-generated constructor stub
		for(int i =0; i<100;i++){
			User user = new User();
			user.setUsername("user"+i);
			user.setPassword("pass"+i);
			userdb.add(user);
		}
	}

	@Override
	public Iterator<? extends User> iterator(int first, int count) {
		// TODO Auto-generated method stub
		List<User> newList = new ArrayList<User>(userdb);
		return newList.subList(first, count).iterator();
		
	}

	@Override
	public IModel<User> model(User object) {
		// TODO Auto-generated method stub
		return new LoadableDetachableModel<User>() {

			@Override
			protected User load() {
				// TODO Auto-generated method stub
				return object;
			}
		};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return userdb.size();
	}

	
}
