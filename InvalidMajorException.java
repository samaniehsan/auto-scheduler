package org.txstate.auto_scheduler;

/**
 * InvalidMajorException.java : Check is the major is vaild
 * @param N/A
 * @exception RuntimeException
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class InvalidMajorException extends RuntimeException {
        private String major;

        /**
         * InvalidMajorException() : Will get courses in respect to major
         * @param message, major
         * @exception N/A
         * @return Collection<CurriculumCourse>
         */
        public InvalidMajorException(
        String major,
        String message, 
        Throwable cause) {
                super(message, cause);
                this.major = major;
        }

        /**
         * InvalidMajorException() : Will get courses in respect to major
         * @param major, message, super(message),
         * @exception N/A
         * @return Collection<CurriculumCourse>
         */
        public InvalidMajorException(
                String major, 
                String message) {
                super(message);
                this.major = major;
        }

        public String getMajor() {
                return this.major;
        }    
}
