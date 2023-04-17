package com.junit5.service;

import com.junit5.model.Movie;
import com.junit5.model.Ring;
import com.junit5.model.TolkienCharacter;

import java.util.*;
import java.util.stream.Collectors;

import static com.junit5.model.Race.*;

/**
 * Init data for unit test
 */
public class DataService {

    static final String ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION = "{} assertion : {}\n";


    // Some Lord of the Rings characters :
    final TolkienCharacter frodo = new TolkienCharacter(33, "Frodo", HOBBIT);

    final TolkienCharacter sam = new TolkienCharacter(38, "Sam", HOBBIT);

    final TolkienCharacter merry = new TolkienCharacter(36, "Merry", HOBBIT);

    final TolkienCharacter pippin = new TolkienCharacter(28, "Pippin", HOBBIT);

    final TolkienCharacter gandalf = new TolkienCharacter(2020, "Gandalf", MAIA);

    final TolkienCharacter gimli = new TolkienCharacter(139, "Gimli", DWARF);

    final TolkienCharacter legolas = new TolkienCharacter(1000, "Legolas", ELF);

    final TolkienCharacter aragorn = new TolkienCharacter(87, "Aragorn", MAN);

    final TolkienCharacter boromir = new TolkienCharacter(37, "Boromir", MAN);

    final TolkienCharacter sauron = new TolkienCharacter(50000, "Sauron", MAIA);

    final TolkienCharacter galadriel = new TolkienCharacter(3000, "Galadriel", ELF);

    final TolkienCharacter elrond = new TolkienCharacter(3000, "Elrond", ELF);

    final TolkienCharacter guruk = new TolkienCharacter(20, "Guruk", ORC);


    final Movie theFellowshipOfTheRing = new Movie(
            "the fellowship of the Ring",
            new Date(),
            "178 min"
    );

    final Movie theTwoTowers = new Movie(
            "the two Towers",
            new Date(),
            "179 min"
    );

    final Movie theReturnOfTheKing = new Movie(
            "the Return of the King",
            new Date(),
            "201 min"
    );


    public List<TolkienCharacter> getFellowship() {

        final List<TolkienCharacter> fellowshipOfTheRing = new ArrayList<>();

        // let's do some team building :)
        fellowshipOfTheRing.add(frodo);
        fellowshipOfTheRing.add(sam);
        fellowshipOfTheRing.add(merry);
        fellowshipOfTheRing.add(pippin);
        fellowshipOfTheRing.add(gandalf);
        fellowshipOfTheRing.add(legolas);
        fellowshipOfTheRing.add(gimli);
        fellowshipOfTheRing.add(aragorn);
        fellowshipOfTheRing.add(boromir);
        fellowshipOfTheRing.add(sauron);

        return fellowshipOfTheRing;
    }

    public List<TolkienCharacter> getOrcsWithHobbitPrisoners() {
        final List<TolkienCharacter> orcsWithHobbitPrisoners = new ArrayList<TolkienCharacter>();
        orcsWithHobbitPrisoners.add(guruk);
        orcsWithHobbitPrisoners.add(merry);
        orcsWithHobbitPrisoners.add(pippin);
        return orcsWithHobbitPrisoners;
    }

    public TolkienCharacter getFellowshipCharacter(String name) {
        List<TolkienCharacter> list = getFellowship();
        return list
                .stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Not found")
                );
    }

    public List<TolkienCharacter> getFellowshipByRace(String race) {
        List<TolkienCharacter> list = getFellowship();
        return list
                .stream()
                .filter(item -> item.getRace().getName().equalsIgnoreCase(race))
                .collect(Collectors.toList());
    }

    public Map<Ring, TolkienCharacter> getRingBearers() {

        Map<Ring, TolkienCharacter> ringBearers = new HashMap<>();

        // ring bearers
        ringBearers.put(Ring.nenya, galadriel);
        ringBearers.put(Ring.narya, gandalf);
        ringBearers.put(Ring.vilya, elrond);
        ringBearers.put(Ring.oneRing, frodo);
        return ringBearers;
    }
}
