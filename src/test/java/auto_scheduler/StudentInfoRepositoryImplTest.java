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
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       assertEquals(st.getLastName(),"Davis");
       assertEquals(st.getNameFirst(),"James");
       assertEquals(st.getStudentId(),"d12345679");
       assertEquals(dateFormat.format(st.getDateOfBirth()) ,"1990-05-06");
    }
}
