package pack1;

import java.util.Set;

public class Course {

	private int courseId;
	private String courseName;
	private int duration;

	private Set<Student> stuList;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<Student> getStuList() {
		return stuList;
	}

	public void setStuList(Set<Student> stuList) {
		this.stuList = stuList;
	}

}
