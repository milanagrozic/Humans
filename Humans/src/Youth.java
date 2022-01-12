
public class Youth extends Human{
	
	int schoolGrade;
	String schoolName;


	public Youth(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender, int schoolGrade, String schoolName) {
		super(birthYear, birthMonth, birthDay, firstName, lastName, gender);
		// TODO Auto-generated constructor stub
		this.schoolGrade = schoolGrade;
		this.schoolName = schoolName; 
	}

	public int getSchoolGrade() {
		// TODO Auto-generated method stub
		return schoolGrade;
	}

	public String getSchoolName() {
		// TODO Auto-generated method stub
		return schoolName;
	}


}
