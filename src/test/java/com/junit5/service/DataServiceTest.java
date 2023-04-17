package com.junit5.service;

import com.junit5.model.Movie;
import com.junit5.model.TolkienCharacter;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.junit5.model.Race.*;

class DataServiceTest {

    DataService dataService;

    List<TolkienCharacter> fellowship;

    @BeforeEach
    void setUp() {
        dataService = new DataService();
       fellowship = dataService.getFellowship();
    }

    @Test
    void ensureThatInitializationOfTolkienCharactersWorks() {
        TolkienCharacter frodo = new TolkienCharacter(33, "Frodo", HOBBIT);

        // TODO check that age is 33
        Assertions.assertEquals(33, frodo.getAge(), "frodo's age should be 33");
        // TODO check that name is "Frodo"
        Assertions.assertEquals("Frodo", frodo.getName(), "frodo's name should be frodo");
        // TODO check that name is not "Frodon"
        Assertions.assertNotEquals("Frodon", frodo.getName(), "frodo's name should not be frodon");
    }

    @Test
    void ensureThatEqualsWorksForCharacters() {
        Object jake = new TolkienCharacter(43, "Jake", HOBBIT);
        Object jakeClone = new TolkienCharacter(12, "Jake", HOBBIT);
        // TODO check that:
        // jake is not equal to jakeClone
        Assertions.assertNotEquals(jake, jakeClone, "jake should not be equal to jakeClone");
    }

    @Test
    void checkInheritance() {
        TolkienCharacter test = dataService.getFellowship().get(0);
        // TODO check that tolkienCharacter.getClass is not a movie class
        Assertions.assertAll("test TolkienCharacter.class",
                () -> Assertions.assertInstanceOf(
                        TolkienCharacter.class,
                        test,
                        "test should be instance of TolkienCharacter.class"
                ),
                () -> Assertions.assertFalse(Movie.class.isAssignableFrom(
                                test.getClass()),
                        "test.getClass should not be Movie.class"
                ),
                () -> Assertions.assertTrue(TolkienCharacter.class.isAssignableFrom(
                                test.getClass()),
                        "test.getClass should be TolkienCharacter.class"
                )
        );
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWork() {
        // TODO implement a check that dataService.getFellowshipCharacter returns null for an unknown fellow, e.g. "Lars"
        Assertions.assertAll("test getFellowshipCharacter",
                () -> Assertions.assertThrows(
                        RuntimeException.class,
                        () -> dataService.getFellowshipCharacter("Lars"),
                        "dataService.getFellowshipCharacter returns null for an unknown fellow"),
                () -> Assertions.assertEquals(
                        "Frodo",
                        dataService.getFellowshipCharacter("Frodo").getName(),
                        "dataService.getFellowshipCharacter should return Frodo")
        );

    }

    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowship() {

        // TODO check that Frodo and Gandalf are part of the fellowship
        TolkienCharacter frodo = dataService.getFellowshipCharacter("Frodo");
        TolkienCharacter gandalf = dataService.getFellowshipCharacter("Gandalf");
        Assertions.assertAll(
                "Frodo and Gandalf are part of the fellowship",
                () -> Assertions.assertTrue(fellowship.contains(frodo)),
                () -> Assertions.assertTrue(fellowship.contains(gandalf))
        );
    }

    @Test
    void ensureOrdering() {

        // ensure that the order of the fellowship is:
        // frodo, sam, merry, pippin, gandalf, legolas, gimli, aragorn, boromir

        TolkienCharacter frodo = dataService.getFellowshipCharacter("Frodo");
        TolkienCharacter sam = dataService.getFellowshipCharacter("Sam");
        TolkienCharacter merry = dataService.getFellowshipCharacter("Merry");
        TolkienCharacter pippin = dataService.getFellowshipCharacter("Pippin");
        TolkienCharacter gandalf = dataService.getFellowshipCharacter("Gandalf");
        TolkienCharacter legolas = dataService.getFellowshipCharacter("Legolas");
        TolkienCharacter gimli = dataService.getFellowshipCharacter("Gimli");
        TolkienCharacter aragorn = dataService.getFellowshipCharacter("Aragorn");
        TolkienCharacter boromir = dataService.getFellowshipCharacter("Boromir");
        TolkienCharacter sauron = dataService.getFellowshipCharacter("Sauron");
        Assertions.assertEquals(0, fellowship.indexOf(frodo));
        Assertions.assertEquals(1, fellowship.indexOf(sam));
        Assertions.assertEquals(2, fellowship.indexOf(merry));
        Assertions.assertEquals(3, fellowship.indexOf(pippin));
        Assertions.assertEquals(4, fellowship.indexOf(gandalf));
        Assertions.assertEquals(5, fellowship.indexOf(legolas));
        Assertions.assertEquals(6, fellowship.indexOf(gimli));
        Assertions.assertEquals(7, fellowship.indexOf(aragorn));
        Assertions.assertEquals(8, fellowship.indexOf(boromir));
        Assertions.assertEquals(9, fellowship.indexOf(sauron));
    }

    @Test
    void ensureAge() {

        // TODO test ensure that all hobbits and men are younger than 100 years

        Assertions.assertTrue(
                fellowship
                        .stream()
                        .filter(item -> item.getRace().equals(MAN) || item.getRace().equals(HOBBIT))
                        .allMatch(item -> item.getAge() < 100)
        );

        // TODO also ensure that the elfs, dwars the maia are all older than 100 years

        Assertions.assertTrue(
                fellowship
                        .stream()
                        .filter(item -> item.getRace().equals(ELF) || item.getRace().equals(DWARF) || item.getRace().equals(MAIA))
                        .allMatch(item -> item.getAge() > 100)
        );

        // HINT fellowship.stream might be useful here
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {

        // TODO Write a test to get the 20 element from the fellowship throws an IndexOutOfBoundsException
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));

        Throwable ex = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
        Assertions.assertEquals("Index 20 out of bounds for length 10", ex.getMessage());
    }

    @Test
    public void ensureThatAgeMustBeLargerThanZeroViaSetter() {
        TolkienCharacter frodo = new TolkienCharacter(33, "Frodo", HOBBIT);
        // use assertThrows() rule to check that the message is:
        // Age is not allowed to be smaller than zero

        Throwable ex = Assertions.assertThrows(IllegalArgumentException.class, () -> frodo.setAge(-1));
        Assertions.assertEquals("Age is not allowed to be smaller than zero", ex.getMessage());
    }

    @Test
    public void testThatAgeMustBeLargerThanZeroViaConstructor() {
        // use assertThrows() rule to check that an IllegalArgumentException exception is thrown and
        // that the message is: "Age is not allowed to be smaller than zero"

        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new TolkienCharacter(-1, "Frodo", HOBBIT)
        );
        Assertions.assertEquals("Age is not allowed to be smaller than zero", ex.getMessage());

    }
}