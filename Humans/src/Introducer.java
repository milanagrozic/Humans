
public class Introducer{
	
	String pronouns = "";
	String fullName = "";
	String job = "";
	String schooling = "";
	String homeroom = "";
	int age = 100;
	Gender gender;
	
	public String getPronouns(Human person) {
		gender = person.getGender();
		pronouns = gender.toString();	
		if(pronouns == "FEMALE") {
			return "She";
		} else if (pronouns == "MALE") {
			return "He";
		} else {
			return "They";
		}
	}

	public String createPublicIntroduction(Human person) {		

		try {
			fullName = person.getFirstName() + " " + person.getLastName() + ".";
			
			if (person instanceof Adult) {
				job = " " + getPronouns(person) + " works at " + ((Adult) person).getPlaceOfWork() + " and their occupation is " + ((Adult) person).getOccupation() + ".";
			} else {
				job = "";
			}
				
			if (person instanceof Youth) {
				schooling = " " + getPronouns(person) + " goes to " + ((Youth) person).getSchoolName() + " and is in grade " + ((Youth) person).getSchoolGrade() + ".";
			} else {
				schooling = "";
			}
			
			if (person instanceof WilliamAberhartStudent) {
				homeroom = ((WilliamAberhartStudent) person).getHomeRoomTeacher();
				if (homeroom != null) {
					homeroom = " " + getPronouns(person) + " belongs to " + ((WilliamAberhartStudent) person).getHomeRoomTeacher() + "'s homeroom, which is in room " + ((WilliamAberhartStudent) person).getHomeRoom() + ".";
				} else {
					homeroom = " Their homeroom is unknown at this time.";
				}
			} else {
				homeroom = "";
			}		
			
		} catch (ArrayIndexOutOfBoundsException e) {
			return "This person has issues and can't be introduced.";
		}
		try {
			age = person.calculateCurrentAgeInYears();
		} catch (ArithmeticException a) {
			return "This person has issues and can't be introduced.";
		}
		return "I am pleased to introduce " + fullName + job + schooling + homeroom;
		
	}
}
