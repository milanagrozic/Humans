
public class Adult extends Human{
	
	String occupation;
	String placeOfWork;

	public Adult(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender, String placeOfWork, String occupation) {
		super(birthYear, birthMonth, birthDay, firstName, lastName, gender);
		// TODO Auto-generated constructor stub
		this.occupation = occupation;
		this.placeOfWork = placeOfWork;
	}

	public String getOccupation() {
		// TODO Auto-generated method stub
		return occupation;
	}

	public String getPlaceOfWork() {
		// TODO Auto-generated method stub
		return placeOfWork;
	}


}
