package com.Mehrnaz.aliendemo;

import java.util.ArrayList;
import java.util.List;

public class AlienRepo {
	
	private static List<Alien> db = new ArrayList<>();
	
	public void addAlien(Alien alien) {
		// TODO Auto-generated method stub
		db.add(alien);
		
	}
	
	public List<Alien> getAliens(){
		return db;
	}
	
	public Alien getAlien(String name) {
		
		Alien res = db.stream().filter(a -> a.getName().equals(name)).
				findAny().orElse(null);
		return res;
	}

	public void deleteAlien(int id) {
		// TODO Auto-generated method stub
		Alien res = db.stream().filter(a -> a.getId() == id).
				findAny().orElse(null);
		db.remove(res);
	}

	
	
}
