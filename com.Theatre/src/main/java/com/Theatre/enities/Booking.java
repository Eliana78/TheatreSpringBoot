package com.Theatre.enities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Column(name = "tot_people")
	private int totPeople;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")     // molte prenotazioni possono appartenere a un singolo utente
	private User user;
	
	
	
	@ManyToOne
	@JoinColumn(name="theatre_shows_id")     // molte prenotazioni per un singolo show
	private Shows show;
	
	// In JPA, l'ownership della relazione è determinata da chi possiede la chiave esterna (foreign key). 
	// In questo caso, l'entità Booking possiede le chiavi esterne user_id e show_id, quindi:
	// La tabella bookings è la "owner" delle relazioni con le tabelle users e shows.
	// Le annotazioni @ManyToOne in Booking con @JoinColumn indicano che Booking è la parte proprietaria della relazione.

	
	public Booking() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTotPeople() {
		return totPeople;
	}

	public void setTotPeople(int totPeople) {
		this.totPeople = totPeople;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}
	
	
	
	
}
