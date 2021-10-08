/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ParkSurvey {
	
	@Id
	@GeneratedValue
	private int id;
	private String parkName;
	private LocalDate surveyDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Park park;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Dinosaur> surveyOfPark;
	
	public ParkSurvey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkSurvey(int id, String parkName, LocalDate surveyDate, Park park, List<Dinosaur> surveyOfPark) {
		super();
		this.id = id;
		this.parkName = parkName;
		this.surveyDate = surveyDate;
		this.park = park;
		this.surveyOfPark = surveyOfPark;
	}

	public ParkSurvey(String parkName, LocalDate surveyDate, Park park, List<Dinosaur> surveyOfPark) {
		super();
		this.parkName = parkName;
		this.surveyDate = surveyDate;
		this.park = park;
		this.surveyOfPark = surveyOfPark;
	}

	public ParkSurvey(String parkName, LocalDate surveyDate, Park park) {
		super();
		this.parkName = parkName;
		this.surveyDate = surveyDate;
		this.park = park;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public LocalDate getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(LocalDate surveyDate) {
		this.surveyDate = surveyDate;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public List<Dinosaur> getSurveyOfPark() {
		return surveyOfPark;
	}

	public void setSurveyOfPark(List<Dinosaur> surveyOfPark) {
		this.surveyOfPark = surveyOfPark;
	}

	@Override
	public String toString() {
		return "ParkSurvey [id=" + id + ", parkName=" + parkName + ", surveyDate=" + surveyDate + ", park=" + park
				+ ", surveyOfPark=" + surveyOfPark + "]";
	}

}
