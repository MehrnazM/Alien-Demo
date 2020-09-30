package com.Mehrnaz.aliendemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("alienresource")
public class AlienResource {
	
	//private final AlienRepo repo = new AlienRepo();
	private final AlienDB db = new AlienDB();
	
	@GET
	@Path("aliens")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAlien() {
		
		//return repo.getAliens();
		return db.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id) {
		//return repo.getAlien(name);
		return db.getAlien(id);
	}
	
	@POST
	@Path("addalien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien postAlien(Alien alien) {
		//repo.addAlien(alien);
		//System.out.println("Posting!");
		//System.out.println(repo.getAliens());
		db.addAlien(alien);
		return alien;
	}
	
	@DELETE
	@Path("deletealien/{id}")
	public void deleteAlien(@PathParam("id") int id) {
		//repo.deleteAlien(id);
		db.deleteAlien(id);
		//return 1;
	}
	
	@PUT
	@Path("updatealien")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAlien(Alien alien) {
		if(db.getAlien(alien.getId()).getId() == 0) {
			db.addAlien(alien);
		}
		else {
			db.updateAlien(alien);
		}
	}
	
}
