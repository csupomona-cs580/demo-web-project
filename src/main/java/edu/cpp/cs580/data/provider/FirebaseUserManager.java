package edu.cpp.cs580.data.provider;

import java.util.List;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import edu.cpp.cs580.data.User;

public class FirebaseUserManager implements UserManager {

	private Firebase firebase;
	
	public FirebaseUserManager() {
		firebase = new Firebase("https://cs580-web-app.firebaseio.com/");
	}
	
	@Override
	public User getUser(String userId) {
		firebase.child("user/" + userId).addListenerForSingleValueEvent(new ValueEventListener() {			
			@Override
			public void onDataChange(DataSnapshot arg0) {
				System.out.println(arg0.getValue());
				
			}
			
			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		firebase.child("user/" + user.getId()).setValue(user);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listAllUsers() {
		firebase.child("user").addValueEventListener(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getValue());
			}
			
			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return null;
	}

}
