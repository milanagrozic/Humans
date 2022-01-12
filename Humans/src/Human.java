import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Human implements Comparable<Human>{

	public static final Comparator<Human> AGE_ORDER = new Comparator<Human>() {
		public int compare (Human a, Human b) {
			return b.calculateCurrentAgeInDays() - a.calculateCurrentAgeInDays();
		}
	};
	
	public static Comparator<Human> ASSEMBLY_ORDER = new Comparator<Human>() {
		public int compare (Human a, Human b) {
			Integer ordinalC = ordinal(a);
			Integer ordinalD = ordinal(b);
			return (ordinalC + (a.getLastName() + "," + a.getFirstName())).compareTo(ordinalD + (b.getLastName() + "," + b.getFirstName()));
		}
		
		public int ordinal (Human a) {
			if (a instanceof WilliamAberhartStudent) {
				return 0;
			} else if (a instanceof Youth) {
				return 1;
			} else if (a instanceof Adult){
				return 2;
			} else if (a instanceof Human){
				return 3;
			} else {
				return 4;
			}
		}
	};
	
	public static Comparator<Human> NAME_ORDER = new Comparator<Human>() {
		public int compare (Human a, Human b) {
			return (a.getLastName() + "," + a.getFirstName()).compareTo(b.getLastName() + "," + b.getFirstName());
		}
	};
	
	int birthYear;
	int birthMonth;
	int birthDay;
	String firstName;
	String lastName;
	Gender gender;

	public Human(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender) {
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;	
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getBirthMonth() {
		return birthMonth;
	}
	
	public int getBirthDay() {
		return birthDay;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public int calculateCurrentAgeInYears() {
		int age;
		  LocalDateTime currentdate = LocalDateTime.now();
	      int currentDay = currentdate.getDayOfMonth();
	      int currentMonth = currentdate.getMonthValue();
	      int currentYear = currentdate.getYear();
		
		if(currentMonth >= birthMonth) {
			if(currentDay >= birthDay) {
				age = currentYear  - birthYear;
			} else {
				age = currentYear  - birthYear -1;
			}		
		} else {
			age = currentYear  - birthYear - 1;
		}
		return age;
	}
	
	public int calculateCurrentAgeInDays() {
		  LocalDate dateOfBirth = LocalDate.of(birthYear, birthMonth, birthDay);
		  LocalDate now = LocalDate.now();
		  long years = ChronoUnit.DAYS.between(dateOfBirth, now);
		  return (int)years;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setGender (Gender gender) {
		this.gender = gender;
	}

	public int compareTo(Human c) {
		return AGE_ORDER.compare(this,  c);
	}
}