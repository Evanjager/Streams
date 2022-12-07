import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//Write/fix the code as needed to remove warnings/errors and complete the lab 
public class Courses {
	ArrayList<Course> courses = new ArrayList<>();
	
	public void loadCourses(){
		courses.add(new Course("COSC", "304", "Introduction Databases", "Databases from a user's perspective: querying with SQL, designing with UML, and using programs to analyze data. Construction of database-driven applications and websites and experience with current database technologies. [3-0-0]", "Prerequisite: One of COSC 121, COSC 223."));
		courses.add(new Course("COSC","222","Data Structures","Introduction to the design, implementation and analysis of data structures. Topics will include lists, stacks, queues, trees, and graphs. [3-2-0]","Prerequisite: A score of 60% or higher in COSC 121."));
		courses.add(new Course("COSC","121","Computer Programming II","Advanced programming in the application of software engineering techniques to the design and implementation of programs manipulating complex data structures. [3-2-0]","Prerequisite: A score of 60% or higher in one of COSC 111, COSC 123."));
		courses.add(new Course("COSC","111","Computer Programming I","Introduction to the design, implementation, and understanding of computer programs. Topics include problem solving, algorithm design, and data and procedural abstraction, with emphasis on the development of working programs. [3-2-0]","Prerequisite: A score of 70% or higher in one of PREC 12, MATH 12, MATH 125, MATH 126."));
		courses.add(new Course("COSC", "264", "Introduction to Web Development and Databases", "Construction of simple database-driven websites. Introduction to web programming: client-side, server-side; database design, implementation, and query. [3-2-0]", "Prerequisite: One of COSC 121, COSC 223."));
		
	}
	public void dispay(ArrayList<String> s){ //Display method that takes an array list and prints the contents, did this to unit test easier
		System.out.println(s.toString());
	}
	
	public ArrayList<String> listAll(){
		ArrayList<String> s = new ArrayList<>();
		Course c;
		for (int i=0; i < courses.size(); i++){
			c = courses.get(i);
			s.add(c.accr + " " + c.number + " " + c.title);
		}
		return s;
	}
	
	public ArrayList<String> displayCourse(String number){ 
		ArrayList<String> s = new ArrayList<>(); //create arraylist
		Course c;
		for (int i =0; i<courses.size();i++){ //itterate through courses
			c = courses.get(i); 
			if(c.number.equals(number)){ 
				s.add(c.accr+ " "+ c.number+ " " + c.title+ "\n"+c.desc+"\n"+c.prereq); //if course numer == the number put in prints out all contentens of the course
			}
		}
		return s;
	}
	public ArrayList<String> listALLiter(){
		ArrayList<String> s = new ArrayList<>();//create arraylist
		Iterator itr =courses.iterator(); // create iterator 
		while(itr.hasNext()){ // checks if itorater has a next element to continue the loop
			Object o = itr.next(); // points at the next objext
			Course c = (Course) o; // casts to a course class
			s.add(c.accr + " " + c.number + " " + c.title ); //add to array list 
		}
		return s;
	}

	public ArrayList<String> listAllStreams(){
		ArrayList<String> s = new ArrayList<>(); // creates array list
		courses.stream() // opens sream for courss
		.forEach(c -> s.add(c.accr + " " + c.number + " " + c.title )); //for each loop that adds couses to array list
		return s;
	

		
	}
	public long CoursesStored(){
		long count = courses.stream().count(); //opens stream and counts how many courses r in it
		return count;
	}
	public ArrayList<String> filterdatabase(){
		ArrayList<String> s = new ArrayList<>(); // creates arraylist
		courses.stream() //opens stream
		.filter(course -> course.desc.contains("database")) // fillters courses with the ones that contain database in the desc
		.forEach(c -> s.add(c.accr + " " + c.number + " " + c.title ));// for each loop that adds filtered courses to arraylist
		return s;
	}

	public ArrayList<String> sorted(){
		ArrayList<String> s = new ArrayList<>(); // creates array list 
		courses.stream()// opens stream
		.sorted(Comparator.comparing(Course::getNumber))//sorts based on number, assending
		.forEach(c -> s.add(c.accr + " " + c.number + " " + c.title )); //for each loop that adds sorted courses in assending order
		return s;

	}
	
	
	public static void main(String[] args) {
		Courses L = new Courses();
		L.loadCourses();
		
		L.dispay(L.displayCourse("222"));

		L.dispay(L.listAll());
		
		L.dispay(L.listALLiter());
	
		L.dispay(L.listAllStreams());
	
		System.out.println("Number of courses stored: "+L.CoursesStored());
		
		L.dispay(L.filterdatabase());

		L.dispay(L.sorted());
	

	}

}
