package com.Mehrnaz.aliendemo;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alien")
public class Alien {
	
	
	private String name;
	private int id;
	private String expertise;
	
	public Alien() {}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	@XmlElement
	public String getExpertise() {
		return expertise;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", id=" + id + ", expertise=" + expertise + "]";
	}
	
	
}
