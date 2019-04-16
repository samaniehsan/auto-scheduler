package org.txstate.auto_scheduler;

import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import static org.junit.Assert.*;

public class StudentInfoRepositoryImplTest {

    @Test
    public void getInfo(){
       StudentInfoRepositoryImpl test = new StudentInfoRepositoryImpl(new TestResourcePathProviderImpl());
       StudentInfo st = test.getInfo("d12345679");
        
       assertNotNull(st);
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       assertEquals("Davis", st.getLastName());
       assertEquals("James", st.getNameFirst());
       System.out.println("stdudent id" + st.getStudentId());
       assertTrue("d12345679".equalsIgnoreCase(st.getStudentId()));
       assertEquals("1990-05-06", dateFormat.format(st.getDateOfBirth()));
    }
}
