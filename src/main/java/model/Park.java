/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 7, 2021
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="park")
public class Park {
	
	@Id
	@GeneratedValue
	private int id;
	private String parkName;
	
	public Park() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Park(int id, String parkName) {
		super();
		this.id = id;
		this.parkName = parkName;
	}

	public Park(String parkName) {
		super();
		this.parkName = parkName;
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

	@Override
	public String toString() {
		return "Park [id=" + id + ", parkName=" + parkName + "]";
	}
	

}
