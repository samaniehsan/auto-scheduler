package org.txstate.auto_scheduler;

import org.apache.commons.csv.CSVFormat;
import org.junit.Test;



import org.hamcrest.collection.IsEmptyCollection;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;


import static org.junit.Assert.*;

public class CourseDataTest {



    @Test
    public void loadData() {
        CourseData courses = new CourseData();
        assertThat(courses.loadData() , not(IsEmptyCollection.empty()));
        assertThat(courses.loadData().size(), is(527));
    }

    @Test
    public void addCourse() {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        List<CourseInfo> courses = new ArrayList<CourseInfo>();
        CourseData.addCourse(courses,"testdata/test.csv",format);
        assertTrue(courses.get(0).getCourseNumber().equals("NUMBER"));
        assertTrue(courses.get(0).getCourseName().equals("Name"));
        assertTrue(courses.get(0).getSubject().equals("Subject"));
    }


    @Test
    public void createSection() {
        List<CourseInfo> courses = new ArrayList<CourseInfo>();
        CourseInfo courseTemp = new CourseInfo();
        courseTemp.setCourseNumber("XXX123");
        courses.add(courseTemp);
        CourseData.createSection(courses);
        assertThat(courses.size(), is(4));
        courses.clear();
        courseTemp.setCourseNumber("XXX323");
        courses.add(courseTemp);
        CourseData.createSection(courses);
        assertThat(courses.size(), is(3));
    }

    @Test
    public void addRoomTimeDay() {
        List<CourseInfo> courses = new ArrayList<CourseInfo>();
        CourseInfo courseTemp = new CourseInfo();
        courses.add(courseTemp);
        CourseData.addRoomTimeDay(courses);
        assertTrue(courses.get(0).getRoomNumber() == 1000);
        assertTrue(courses.get(0).getDayTime().equals("8:00 - 9:20 MW"));
    }

    @Test
    public void courseRandomnizer() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = CourseData.courseRandomnizer(2);
        assertThat(list.size(), is(2));
    }
}