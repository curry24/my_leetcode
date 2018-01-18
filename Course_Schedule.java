package top_interview;

public class Course_Schedule {
	public static void main(String args[]){
		int numCourses = 2;
		int[][] prerequisites = {{1,0},{0,1}};
		Course_Schedule a = new Course_Schedule();
		if(a.canFinish(numCourses, prerequisites)) System.out.println("True");
		else System.out.println("False");
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites){
		
	}

}
