package com.squad.ESP.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad.ESP.beans.Images;
import com.squad.ESP.beans.PrimarySecondary;
import com.squad.ESP.beans.User;

import com.squad.ESP.dao.ImgRepo;
import com.squad.ESP.dao.UPM;
import com.squad.ESP.dao.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ESPCtrl {

	@Autowired
	UserRepo userrepo;

	@Autowired
	UPM upmrepo;

	@Autowired
	ImgRepo img;

	HashMap<String, ArrayList<HashMap<String, ArrayList<String>>>> upm;

	User globalUser, currentUser;
	
	@PostMapping("/addUser")
	public void add(@RequestBody String username) {
		User user = new User(username, false, 0);
		currentUser = user;
		userrepo.save(user);

	}

	@GetMapping("/getUser")
	public User check() {
		ArrayList<User> arr = (ArrayList<User>) userrepo.findAll();
		for (User user : arr) {
			if (user.isStatus() == false) {
				user.setStatus(true);
				globalUser = user;
				break;
			}
		}
		return globalUser;
	}
	
	@GetMapping("/getImgMap")
	public HashMap<String, ArrayList<String>> getPrimarySecondary(User user) {

		HashMap<String, ArrayList<String>> map = null;

		if (globalUser != null) {

			ArrayList<PrimarySecondary> arr = (ArrayList<PrimarySecondary>) upmrepo.findAll();

			for (PrimarySecondary upm : arr) {
				if (upm.getUserName() == user.getUserName()) {
					
					if (map.containsKey(upm.getPrimary())) {
						map.get(upm.getPrimary()).add(upm.getSecondary());
					} else {
						ArrayList<String> sec = new ArrayList<String>();
						sec.add(upm.getSecondary());
						map.put(upm.getPrimary(), sec);
					}
				}
			}
			return map;
		}

		// HashMap<String, ArrayList<String>> map = null;
		Random rand = new Random();
		ArrayList<Images> images = (ArrayList<Images>) img.findAll();
		HashMap<Integer, String> imgs = null;

		for (Images img : images) {
			imgs.put(img.getId(), img.getImg());
		}

		int p1 = rand.nextInt(15);

		if (p1 >= 0 && p1 < 5) {
			ArrayList<String> sec = null;
			for (int i = 0; i < 3; i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		} else if (p1 >= 5 && p1 < 10) {
			ArrayList<String> sec = null;
			for (int i = 0; i < 3; i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		} else {
			ArrayList<String> sec = null;
			for (int i = 0; i < 3; i++) {
				int x = rand.nextInt(15);
				sec.add(imgs.get(x));
			}
			sec.add(imgs.get(p1));
			map.put(imgs.get(p1), sec);
		}
		return map;
	}
	
	@PostMapping("/addimgs")
	public void setImgs(PrimarySecondary ps) {
		upmrepo.save(ps);
	}
	
	@PutMapping("/updateDetails")
	public void compare() {
		ArrayList<PrimarySecondary> arr = (ArrayList<PrimarySecondary>) upmrepo.findAll();
		
	}

}
