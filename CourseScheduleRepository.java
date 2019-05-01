package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * CourseScheduleRepository.java : Public Interface
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface CourseScheduleRepository {
    Collection<CourseInfo> getClasses() throws FileNotFoundException,  IOException;
    void incrementEnrolledCount(Collection<Integer> sectionNumbers) throws FileNotFoundException,  IOException;
}
