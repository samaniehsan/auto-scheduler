package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * DegreePlanRespository.java : Public interface
 * @param String major
 * @exception FileNotFoundException,  IOException
 * @return Collection<CurriculumCourse>
 * @version 1.0
 * @since   5-2-2019
 */
public interface DegreePlanRespository {
    Collection<CurriculumCourse> get(String major) throws FileNotFoundException,  IOException;
}
