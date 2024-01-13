package edu.uoc.uocanoid.model.bricks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BrickUnbreakableTest {

    private BrickUnbreakable brick;

    @BeforeEach
    void setUp() {
        brick = new BrickUnbreakable(15, 6, 5, 10);
    }


    @Test
    @Tag("basic")
    void getNumHitsToBreak() {
        assertEquals(2147483647, brick.getNumHitsToBreak());
    }

    @Test
    @Tag("basic")
    void setNumHitsToBreak(){
        try {
            Method method = Brick.class.getDeclaredMethod("setNumHitsToBreak", int.class);
            method.setAccessible(true);

            method.invoke(brick, 12);
            assertEquals(12, brick.getNumHitsToBreak());

            method.invoke(brick, 0);
            assertEquals(1, brick.getNumHitsToBreak());

            method.invoke(brick, 200);
            assertEquals(200, brick.getNumHitsToBreak());

            method.invoke(brick, -5);
            assertEquals(1, brick.getNumHitsToBreak());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail("[ERROR] There is some problem with 'setNumHitsToBreak'");
        }
    }

    @Test
    @Tag("basic")
    void getCurrentHits() {
        assertEquals(0, brick.getCurrentHits());
    }

    @Test
    @Tag("basic")
    void setCurrentHits(){
        try {
            Method method = Brick.class.getDeclaredMethod("setCurrentHits", int.class);
            method.setAccessible(true);

            method.invoke(brick, 2);
            assertEquals(2, brick.getCurrentHits());

            method.invoke(brick, 0);
            assertEquals(0, brick.getCurrentHits());

            method.invoke(brick, 200);
            assertEquals(200, brick.getCurrentHits());

            method.invoke(brick, -5);
            assertEquals(0, brick.getCurrentHits());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail("[ERROR] There is some problem with 'setCurrentHits'");
        }
    }

    @Test
    @Tag("basic")
    void incCurrentHits() {
        assertEquals(0, brick.getCurrentHits());

        for(int i = 0; i < 100; i++){
            brick.incCurrentHits();
            assertEquals((i+1), brick.getCurrentHits());
        }
    }

    @Test
    @Tag("basic")
    void isBroken() {
        assertFalse(brick.isBroken());

        for(int i = 0; i < 100; i++){
            brick.incCurrentHits();
            assertFalse(brick.isBroken());
        }
    }

    @Test
    @Tag("basic")
    void getPoints() {
        assertEquals(0, brick.getPoints());
    }

    @Test
    @Tag("basic")
    void setPoints() {

        try {
            Method method = Brick.class.getDeclaredMethod("setPoints", int.class);
            method.setAccessible(true);

            method.invoke(brick, 150);
            assertEquals(150, brick.getPoints());

            method.invoke(brick, -150);
            assertEquals(0, brick.getPoints());

            method.invoke(brick, 200);
            assertEquals(200, brick.getPoints());

            method.invoke(brick, 0);
            assertEquals(0, brick.getPoints());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail("[ERROR] There is some problem with 'setPoints'");
        }
    }

    @Test
    @Tag("basic")
    void testToString() {
        assertEquals("position: (15,6), size: 5x10, hits to break: 2147483647, current hits: 0, points: 0",
                brick.toString());
    }

    @Test
    @Tag("sanity")
    public void checkClass() {
        final Class<BrickAdvanced> brickAdvancedClass = BrickAdvanced.class;
        final Class<Brick> brickClass = Brick.class;

        assertTrue(brickClass.isAssignableFrom(brickAdvancedClass));
    }

    @Test
    @Tag("sanity")
    void checkFields() {
        final Class<BrickBasic> ownClass = BrickBasic.class;

        //check attribute fields
        assertEquals(2, ownClass.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ownClass.getDeclaredField("NUM_HITS_TO_BREAK").getModifiers()));
            assertTrue(Modifier.isFinal(ownClass.getDeclaredField("NUM_HITS_TO_BREAK").getModifiers()));
            assertTrue(Modifier.isStatic(ownClass.getDeclaredField("NUM_HITS_TO_BREAK").getModifiers()));
            assertEquals(int.class, (ownClass.getDeclaredField("NUM_HITS_TO_BREAK").getType()));
            assertTrue(Modifier.isPrivate(ownClass.getDeclaredField("POINTS").getModifiers()));
            assertTrue(Modifier.isFinal(ownClass.getDeclaredField("POINTS").getModifiers()));
            assertTrue(Modifier.isStatic(ownClass.getDeclaredField("POINTS").getModifiers()));
            assertEquals(int.class, (ownClass.getDeclaredField("POINTS").getType()));
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes");
        }
    }

    @Test
    @Tag("sanity")
    public void checkMethodsSanity() {
        final Class<BrickBasic> ownClass = BrickBasic.class;

        //check constructors
        assertEquals(1, ownClass.getDeclaredConstructors().length);

        assertEquals(0, ownClass.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(ownClass.getDeclaredConstructor(int.class, int.class, int.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods");
        }
    }
}