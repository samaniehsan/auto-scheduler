package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.stream.*;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

public class CoursePrioritizationServiceImpl implements CoursePrioritizationService {

    public Collection<CurriculumCourse> build(
        Collection<CurriculumCourse> candidateCourses, 
        Collection<String> passedCourses) {
        
        if(candidateCourses == null)
            throw new NullPointerException("candidateCoruses can not be null");
        if(passedCourses == null)
            throw new NullPointerException("passedCourses can not be null");

        return candidateCourses;
    }
}
