package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface DegreePlanRespository {
    Collection<CurriculumCourse> get(String major) throws FileNotFoundException,  IOException;
}
