package com.loija.core.model;

import javax.persistence.Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table(name="factoryorders")
@Entity
public class FactoryOrder{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonFormat(pattern = "MMM dd, yyyy", shape = JsonFormat.Shape.STRING)
	private Date created;
	@ManyToOne
	@JoinTable(name = "factoryorders_users_createdby", 
		joinColumns = @JoinColumn(name = "order_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id"))
	private MyUser createdBy;
	@ManyToOne
	@JoinTable(name = "factoryorders_materials", 
		joinColumns = @JoinColumn(name = "order_id"),
		inverseJoinColumns = @JoinColumn(name = "material_id"))
	private Material material;
	private int amount;
	@JsonFormat(pattern = "MMM dd, yyyy", shape = JsonFormat.Shape.STRING)
	private Date deadline;
	private boolean completed;
	@JsonFormat(pattern = "MMM dd, yyyy", shape = JsonFormat.Shape.STRING)
	private Date finished;
	@ManyToOne
	@JoinTable(name = "factoryorders_users_completedby", 
		joinColumns = @JoinColumn(name = "order_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id"))
	private MyUser completedBy;
	private String notes;
	
	public FactoryOrder() {
		this.created = obtenerFechaActual();
		this.createdBy = null;
		this.completed = false;
		this.completedBy = null;
	}
	

	public FactoryOrder(MyUser createdBy, Material material, int amount, Date deadline) {
		super();
		this.created = obtenerFechaActual();
		this.createdBy = createdBy;
		this.material = material;
		this.amount = amount;
		this.deadline = deadline;
		this.completed = false;
		this.finished = null;
		this.completedBy = null;
		this.notes = null;
	}
	
	public FactoryOrder(MyUser createdBy, Material material, int amount, Date deadline, 
			Date finished, MyUser completedBy, String notes) {
		super();
		this.created = obtenerFechaActual();
		this.createdBy = createdBy;
		this.material = material;
		this.amount = amount;
		this.deadline = deadline;
		this.completed = true;
		this.finished = finished;
		this.completedBy = completedBy;
		this.notes = notes;
	}

	public FactoryOrder(int id, Date created, MyUser createdBy, Material material, int amount, Date deadline,
			boolean completed, Date finished, MyUser completedBy, String notes) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.material = material;
		this.amount = amount;
		this.deadline = deadline;
		this.completed = completed;
		this.finished = finished;
		this.completedBy = completedBy;
		this.notes = notes;
	}
	
	public Date obtenerFechaActual() {
		return new Date(Calendar.getInstance().getTime().getTime());
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public MyUser getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(MyUser createdBy) {
		this.createdBy = createdBy;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public Date getFinished() {
		return finished;
	}


	public void setFinished(Date finished) {
		this.finished = finished;
	}


	public MyUser getCompletedBy() {
		return completedBy;
	}


	public void setCompletedBy(MyUser completedBy) {
		this.completedBy = completedBy;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
