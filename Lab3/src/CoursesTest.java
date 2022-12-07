import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CoursesTest {
    
	
    @BeforeAll
	public static void loadCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("COSC", "304", "Introduction Databases", "Databases from a user's perspective: querying with SQL, designing with UML, and using programs to analyze data. Construction of database-driven applications and websites and experience with current database technologies. [3-0-0]", "Prerequisite: One of COSC 121, COSC 223."));
		courses.add(new Course("COSC","222","Data Structures","Introduction to the design, implementation and analysis of data structures. Topics will include lists, stacks, queues, trees, and graphs. [3-2-0]","Prerequisite: A score of 60% or higher in COSC 121."));
		courses.add(new Course("COSC","121","Computer Programming II","Advanced programming in the application of software engineering techniques to the design and implementation of programs manipulating complex data structures. [3-2-0]","Prerequisite: A score of 60% or higher in one of COSC 111, COSC 123."));
		courses.add(new Course("COSC","111","Computer Programming I","Introduction to the design, implementation, and understanding of computer programs. Topics include problem solving, algorithm design, and data and procedural abstraction, with emphasis on the development of working programs. [3-2-0]","Prerequisite: A score of 70% or higher in one of PREC 12, MATH 12, MATH 125, MATH 126."));
		courses.add(new Course("COSC", "264", "Introduction to Web Development and Databases", "Construction of simple database-driven websites. Introduction to web programming: client-side, server-side; database design, implementation, and query. [3-2-0]", "Prerequisite: One of COSC 121, COSC 223."));
	}
    @Test
    void testdispaycourse(){
        Courses L = new Courses();
        L.loadCourses();
        ArrayList<String> s = new ArrayList<>(Arrays.asList("COSC 222 Data Structures\nIntroduction to the design, implementation and analysis of data structures. Topics will include lists, stacks, queues, trees, and graphs. [3-2-0]\nPrerequisite: A score of 60% or higher in COSC 121.")); //Arraylist that we expect
        assertTrue(s.containsAll(L.displayCourse("222"))&&L.displayCourse("222").containsAll(s));//seeing if both are list contain all of each other
    }
    @Test
    void testListALLCourse() {
        Courses L = new Courses();
        L.loadCourses();
        ArrayList<String> s = new ArrayList<>(Arrays.asList("COSC 304 Introduction Databases", "COSC 222 Data Structures", "COSC 121 Computer Programming II", "COSC 111 Computer Programming I", "COSC 264 Introduction to Web Development and Databases"));//Arraylist that we expect

        assertTrue(s.containsAll(L.listAll())&&L.listAll().containsAll(s)); //seeing if both are list contain all of each other
        assertTrue(s.containsAll(L.listALLiter())&&L.listALLiter().containsAll(s)); 
        assertTrue(s.containsAll(L.listAllStreams())&&L.listAllStreams().containsAll(s));
        
        
    }

    @Test
    void testCount(){
        Courses L = new Courses();
       L.loadCourses();
        long x = L.CoursesStored();
        assertEquals(5, x);
    }
    @Test
    void testfilter(){
        Courses L = new Courses();
        L.loadCourses();
        ArrayList<String> s = new ArrayList<>(Arrays.asList("COSC 304 Introduction Databases","COSC 264 Introduction to Web Development and Databases"));//Arraylist that we expect
        assertTrue(s.containsAll(L.filterdatabase())&&L.filterdatabase().containsAll(s));//seeing if both are list contain all of each other
    }
    @Test
    void testsorted(){
        Courses L = new Courses();
        L.loadCourses();
        ArrayList<String> s = new ArrayList<>(Arrays.asList("COSC 111 Computer Programming I", "COSC 121 Computer Programming II", "COSC 222 Data Structures", "COSC 264 Introduction to Web Development and Databases", "COSC 304 Introduction Databases"));//Arraylist that we expect
        assertTrue(s.containsAll(L.sorted())&&L.sorted().containsAll(s));//seeing if both are list contain all of each other
    }
}
