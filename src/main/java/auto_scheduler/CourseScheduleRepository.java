package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface CourseScheduleRepository {
    Collection<CourseInfo> getClasses() throws FileNotFoundException,  IOException;
    void incrementEnrolledCount(Collection<String> sectionNumbers) throws FileNotFoundException,  IOException;
}
