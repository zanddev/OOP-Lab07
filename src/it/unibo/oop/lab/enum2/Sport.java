/**
 * 
 */
package it.unibo.oop.lab.enum2;

/**
 * Represents an enumeration for declaring sports.
 * 
 */
public enum Sport {

	/*
	 * Define sports
	 */
	BASKET(Place.INDOOR, 5, "basket"),
	VOLLEY(Place.INDOOR, 6, "volley"),
	TENNIS(Place.OUTDOOR, 2, "tennis"),
	BIKE(Place.OUTDOOR, "bike"),
	F1(Place.OUTDOOR, 20, "F1"),
	MOTOGP(Place.OUTDOOR, 20, "motoGP"),
	SOCCER(Place.OUTDOOR, 11, "soccer");

	/*
	 * Declare required fields:
	 *  1. Field noTeamMembers is keeping track of the number of members
	 *       each team is composed of (1 for individual sports)
	 *  2. Field actualName that keeps track of the name of the sport.
	 *  3. Field place, of type Place, will allow to define if the sport is
	 *       practised indoor or outdoor
	 */
	private final int noTeamMembers;
	private final String actualName;
	private final Place place;

	Sport(final Place place, final String actualName) {
		this(place, 1, actualName);
	}
	
	Sport(final Place place, final int noTeamMembers, final String actualName) {
		this.place = place;
		this.noTeamMembers = noTeamMembers;
		this.actualName = actualName;
	}

	/**
	 * Checks if the sport is practised individually
	 * 
	 * @return true only if called on individual sports
	 */
	public boolean isIndividualSport() {
		return (this.noTeamMembers == 1);
	}

	/**
	 * 
	 * @return true in case the sport is practices indoor
	 */
	public boolean isIndoorSport() {
		return (this.place == Place.INDOOR);
	}

	/**
	 * 
	 * @return the place where this sport is practised
	 */
	public Place getPlace() {
		return this.place;
	}

	/**
	 * Returns the name of this enum constant, as contained in the declaration
	 * 
	 * @return the string representation of a sport
	 */
	public String toString() {
		return this.actualName;
	}
}
