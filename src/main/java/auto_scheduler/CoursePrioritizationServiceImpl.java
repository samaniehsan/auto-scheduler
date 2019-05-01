package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Dictionary;
import java.util.Hashtable;
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
        
        int nCandidates = candidateCourses.size();
        
        if(nCandidates > 0) {
            Dictionary<String, Integer> mapCandidates = getCourseMap(candidateCourses);
            int[][] graph = getCourseGraph(candidateCourses, mapCandidates);
            
            return getPriorities( 
                candidateCourses.toArray(new CurriculumCourse[0]),
                graph);
        }
        return candidateCourses;
    }

    /// returns courses order by dependencyCount DESC
    private ArrayList<CurriculumCourse> getPriorities(
        CurriculumCourse[] candidateCourses,
        int[][] graph
    ) {
        ArrayList<CurriculumCourse> priorities = new ArrayList<CurriculumCourse>();
        int nMaxDependencies = 0;
        for(int i= 0; i< graph.length; i++) {
            int npreReqs = 0;
            for(int j= 0; j < graph.length; j++) {
                if( graph[i][j] == 1 ) {
                    npreReqs++;
                    break;
                }
            }
            if(npreReqs == 0) {
                int nDependents = 0;
                for(int k= 0; k < graph.length; k++) {
                    if( graph[k][i] == 1 ) {
                        nDependents++;
                    }
                }
                if(nDependents >0 && nDependents >= nMaxDependencies) {
                    priorities.add(0, candidateCourses[i]);
                    nMaxDependencies = nDependents;
                } else {
                    priorities.add(candidateCourses[i]);
                }
            }
        }
        return priorities;
    }

    private String[] getPrereqs(String preReqString) {
        String[] preReqs = null;
        if(preReqString != null && !preReqString.isEmpty()) {
            preReqString = preReqString.trim();
            if(!preReqString.isEmpty()) {
                preReqs = preReqString.split(":");
            }                    
        }
        return preReqs;
    }

    private int[][] getCourseGraph(
        Collection<CurriculumCourse> candidateCourses,
        Dictionary<String, Integer> mapCandidates) {
        int nCandidates = candidateCourses.size();
        int[][] graph = new int[nCandidates][nCandidates];
        int i = 0;
             
        for(CurriculumCourse course: candidateCourses) {
            String[] prereqs = getPrereqs(course.getPreRequisite());
            graph[i][i] = 0;

            // Collection<String> preReqs = updatedTable.get(courseNumber);
            if(prereqs != null) {
                for(String prereq: prereqs) {
                    Integer index = mapCandidates.get(prereq.toUpperCase());
                    if(index != null) {
                        int preReqGraphIndex = index.intValue();
                        graph[i][preReqGraphIndex] = 1;
                        graph[preReqGraphIndex][i] = 0;
                    }
                }                    
            }
            i++;
        }
        return graph;
    }


    private Dictionary<String, Integer> getCourseMap(
        Collection<CurriculumCourse> candidateCourses
    ) {
        int i = 0;
        Dictionary<String, Integer> map = new Hashtable<String,Integer>(); 
        for(CurriculumCourse course: candidateCourses) {
            String courseNumber = course.getCourseNumber();
            courseNumber.toUpperCase();
            map.put(courseNumber, i);
            i++;
        }
        return map;
    }


    // private Dictionary<String, Collection<String>> removePassedClasses(
    //     Dictionary<String, Collection<String>> courseToPreReqTable,
    //     Collection<String> passedCourses,
    //     Integer npreReqs
    // ) {
    //     Dictionary<String, >
    //     if( courseToPreReqTable != null) {
    //         Collection<String> keys = courseToPreReqTable.getKeys();
    //         for(String key: keys ) {
    //             Collection<String> preReqs = courseToPreReqTable.getValue(key);
                
    //             Collection<String>  preReqsNotPassed = preReqs.stream().filter(
    //                 preReq ->
    //                 passedCourseCodes.stream().noneMatch(
    //                     passedCourse -> passedCourse.equalsIgnoreCase(preReq)
    //                 )
    //             ).collect(Collectors.toList());

    //             courseToPreReqTable.put(key, preReqsNotPassed);
    //         }
    //     }
    // }

    // private Dictionary<String, Collection<String>> getDependencyTable() {
    //     Dictionary<String, Collection<String>> map = new Hashtable<String, Collection<String>>();
    //     int[][] graph = new int[n][n];
    //     int i = 0;
    //     for(CurriculumCourse course: candidateCourses) { 
    //         String courseNumber = course.getCourseNumber();
    //         String preReqString = course.getPreRequisite();
    //         String[] preReqs = null;
    //         if(preReqString != null) {
    //             preReqString = preReqString.trim();
    //             if(!preReqString.isEmpty()) {
    //                 preReqs = preReqString.split(":");
    //             }                    
    //         }
    //         if(preReqs != null && preReqs.length != 0) {
    //             map.put(courseNumber,preReqs);
    //         }
            
    //     }
    // }

    // private Dictionary<String, String> removePassedClasses(
    //     Dictionary<String, String> map, 
    //     Collection<String> passedCourses) {
    //     if(passedCourses != null) {
    //         for(String passedCourse: passedCourses) {
    //             map.remove(passedCourse.toUpperCase());
    //         }
    //     }
    //     return map;
    // }


    // private Dictionary<String, Integer> getUniquePrereqs(
    //     Collection<CurriculumCourse> candidateCourses,
    //     Dictionary<String, Integer> candidateCourseMap
    // ) {
    //     int i = candidateCourseMap.size();
    //     Dictionary<String, Integer> map = new Hashtable<String,Integer>(); 
    //     for(CurriculumCourse course: candidateCourses) {
    //         String preReqString = course.getPreRequisite();
    //         Collection<String> preReqs = getPrereqs(preReqString);
    //         if(preReqs != null ) {
    //             for(String preReq: preReqs) {
    //                 if( candidateCourseMap.get(preReq.toUpperCase()) == null ) {
    //                     // we dont care about a prereq that has been passed.
    //                     continue;
    //                 }
    //                 if( map.get(preReq.toUpperCase()) == null ) {
    //                     //we don't want duplicates
    //                     map.put(preReq.toUpperCase(), Integer(i));
    //                     i++;
    //                 }
    //             }    
    //         }
    //     }
    //     return map;
    // }
}
