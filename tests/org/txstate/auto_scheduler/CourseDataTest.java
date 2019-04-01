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
}