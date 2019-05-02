package org.txstate.auto_batcher;


import org.junit.Test;
import org.txstate.auto_batcher.Invoker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.simple.parser.ParseException;

import static org.junit.Assert.*;

public class StudentInfoRepoTest {

    // @Test
    // public void testbuildLRepoShouldBeNull() {
    //     File[] listOfFiles = null;
    //     StudentInfoRepo repo = new StudentInfoRepo(listOfFiles);
    //     assertEquals(, repo);
    // }

    private Map<NameTuple, Long>  getFullRepo() {

        Map<NameTuple, Long> repository = new HashMap<NameTuple, Long>();

        NameTuple nameTuple1 = new NameTuple("John", "Smith", "A12345679");
        Long year1 = new Long(1);
        repository.put(nameTuple1, year1);

        NameTuple nameTuple2 = new NameTuple("Liam", "Williams", "B12345679");
        Long year2 = new Long(1);
        repository.put(nameTuple2, year2);

        NameTuple nameTuple3 = new NameTuple("Noah", "Brown", "C12345679");
        Long year3 = new Long(1);
        repository.put(nameTuple3, year3);

        NameTuple nameTuple4 = new NameTuple("James", "Davis", "D12345679");
        Long year4 = new Long(1);
        repository.put(nameTuple4, year4);

        NameTuple nameTuple5 = new NameTuple("William", "Miller", "E12345679");
        Long year5 = new Long(1);
        repository.put(nameTuple5, year5);

        NameTuple nameTuple6 = new NameTuple("Logan", "Wilson", "F12345679");
        Long year6 = new Long(1);
        repository.put(nameTuple6, year6);

        NameTuple nameTuple7 = new NameTuple("Benjamin", "Moore", "G12345679");
        Long year7 = new Long(1);
        repository.put(nameTuple7, year7);

        NameTuple nameTuple8 = new NameTuple("Mason", "Taylor", "H12345679");
        Long year8 = new Long(1);
        repository.put(nameTuple8, year8);

        NameTuple nameTuple9 = new NameTuple("Elijah", "Anderson", "I12345679");
        Long year9 = new Long(1);
        repository.put(nameTuple9, year9);

        NameTuple nameTuple10 = new NameTuple("Oliver", "Thomas", "J12345679");
        Long year10 = new Long(1);
        repository.put(nameTuple10, year10);

        NameTuple nameTuple11 = new NameTuple("Jacob", "Jackson", "K12345679");
        Long year11 = new Long(1);
        repository.put(nameTuple11, year11);

        NameTuple nameTuple12 = new NameTuple("Lucas", "White", "L12345679");
        Long year12 =new Long(2);
        repository.put(nameTuple12, year12);

        NameTuple nameTuple13 = new NameTuple("Michael", "Harris", "M12345679");
        Long year13 = new Long(2);
        repository.put(nameTuple13, year13);

        NameTuple nameTuple14 = new NameTuple("Alexander", "Martin", "N12345679");
        Long year14 = new Long(2);
        repository.put(nameTuple14, year14);

        NameTuple nameTuple15 = new NameTuple("Ethan", "Thompson", "O12345679");
        Long year15 = new Long(2);
        repository.put(nameTuple15, year15);

        NameTuple nameTuple16 = new NameTuple("Daniel", "Garcia", "P12345679");
        Long year16 = new Long(2);
        repository.put(nameTuple16, year16);

        NameTuple nameTuple17 = new NameTuple("Matthew", "Martinez", "Q12345679");
        Long year17 = new Long(2);
        repository.put(nameTuple17, year17);

        NameTuple nameTuple18 = new NameTuple("Emma", "Robinson", "R12345679");
        Long year18 = new Long(3);
        repository.put(nameTuple18, year18);

        NameTuple nameTuple19 = new NameTuple("Olivia", "Clarke", "S12345679");
        Long year19 = new Long(3);
        repository.put(nameTuple19, year19);

        NameTuple nameTuple20 = new NameTuple("Ava", "Rodriguez", "T12345679");
        Long year20 = new Long(3);
        repository.put(nameTuple20, year20);

        NameTuple nameTuple21 = new NameTuple("Isabella", "Lewis", "U12345679");
        Long year21 = new Long(3);
        repository.put(nameTuple21, year21);

        NameTuple nameTuple22 = new NameTuple("Sophia", "Lee", "V12345679");
        Long year22 = new Long(3);
        repository.put(nameTuple22, year22);

        NameTuple nameTuple23 = new NameTuple("Mia", "Walker", "W12345679");
        Long year23 = new Long(3);
        repository.put(nameTuple23, year23);

        NameTuple nameTuple24 = new NameTuple("Charlotte", "Hall", "X12345679");
        Long year24 = new Long(3);
        repository.put(nameTuple24, year24);

        NameTuple nameTuple25 = new NameTuple("Amelia", "Allen", "Y12345679");
        Long year25 = new Long(4);
        repository.put(nameTuple25, year25);

        NameTuple nameTuple26 = new NameTuple("Evelyn", "Price", "Z12345679");
        Long year26 = new Long(4);
        repository.put(nameTuple26, year26);

        return repository;
    }

    @Test
    public void testGetRepotShouldBeEmpty() {
        File[] listOfFiles = null;
        StudentInfoRepo repo = new StudentInfoRepo(listOfFiles);
        assertEquals(null, repo.getRepo());
    }

    @Test
    public void testGetRepotShouldEqualGetFullRepo() {
        Invoker invoker = new Invoker("/Users/valeriajara/Desktop/LZSS/Autobatcher/auto-scheduler/src/main/resources/data/records");
        File[] listOfFiles = invoker.runParser();
        StudentInfoRepo repo = new StudentInfoRepo(listOfFiles);
        repo.obtainJSON();

        assertEquals((repo.getRepo()).size(),(getFullRepo()).size());
    }


}
