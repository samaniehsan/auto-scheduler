package org.txstate.auto_scheduler;

public class InvalidMajorException extends RuntimeException {
        private String major;

        public InvalidMajorException(
        String major,
        String message, 
        Throwable cause) {
                super(message, cause);
                this.major = major;
        }

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
