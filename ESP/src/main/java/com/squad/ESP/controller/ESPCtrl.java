package com.squad.ESP.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.ESP.beans.Images;
import com.squad.ESP.beans.User;
import com.squad.ESP.beans.UserPrimaryMapping;
import com.squad.ESP.dao.ImgRepo;
import com.squad.ESP.dao.UPM;
import com.squad.ESP.dao.UserRepo;

@RestController

public class ESPCtrl {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UPM upmrepo ;
	
	@Autowired
	ImgRepo img;
	
	
	public void add(@RequestBody String username) {
		User user = new User(username , false , 0);
		if(check()== null )	
			userrepo.save(user);
	}
	
	public User check() {
		ArrayList<User> arr = (ArrayList<User>)userrepo.findAll();
		for(User user : arr) {
			if(user.isStatus() ==false) {
				user.setStatus(true);
				return user;
			}
		}
		return null;
	}
	
	public HashMap<String, ArrayList<String>> getPrimarySecondary(){
		
		HashMap<String, ArrayList<String>> map = null ;
		if(check()!=null) {
			ArrayList<UserPrimaryMapping> arr = (ArrayList<UserPrimaryMapping>)upmrepo.findAll();   
			for(UserPrimaryMapping upm : arr) {
				if(map.containsKey(upm.getPrimaryImg())) {
					map.get(upm.getPrimaryImg()).add(upm.getSecondaryImg());
				}
				else {
					ArrayList<String> sec = new ArrayList<String>();
					sec.add(upm.getSecondaryImg());
					map.put(upm.getPrimaryImg(), sec );
				}
			}
			return map;
		}
		Random rand = new Random();
		ArrayList<Images> images = (ArrayList<Images>)img.findAll(); 
		HashMap<Integer, String> imgs = null ;
		for(Images img : images) {
			imgs.put(img.getId(), img.getImg());
		}
		
		int p1 = rand.nextInt(15);
		
		if(p1>=0 && p1<5) {
			ArrayList<String> sec =null ;
			for(int i=0;i<3;i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		}
		else if(p1>=5 && p1<10) {
			ArrayList<String> sec =null ;
			for(int i=0;i<3;i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		}
		else {
			ArrayList<String> sec =null ;
			for(int i=0;i<3;i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		}
		
		return map;
	}
	
	
	
	
}
