package com.github.zipcodewilmington;

import com.github.zipcodewilmington.Hash.HashingOne;
import com.github.zipcodewilmington.Hash.HashingThree;
import com.github.zipcodewilmington.Hash.HashingTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {
    @Test
    void setGetTest1(){
        DashaMap<String, String> dashaMap = new DashaMap(new HashingOne());
        dashaMap.set("Fiber", "Look");
        String actual = dashaMap.get("Fiber");
        Assertions.assertEquals("Look", actual);
        Assertions.assertEquals(1, dashaMap.size());
    }
    @Test
    void setGetTest1multiple(){
        DashaMap<String, String> dashaMap = new DashaMap(new HashingOne());
        dashaMap.set("Fiber", "Look");
        dashaMap.set("Fiber", "Look1");
        String actual = dashaMap.get("Fiber");
        Assertions.assertEquals("Look1", actual);
        Assertions.assertEquals(1, dashaMap.size());
    }
    @Test
    void setGetTest2(){
        DashaMap<String, String> dashaMap = new DashaMap(new HashingTwo());
        dashaMap.set("Fiber", "Look");
        dashaMap.set("Fiber1", "Look");
        String actual = dashaMap.get("Fiber");
        Assertions.assertEquals("Look", actual);
        Assertions.assertEquals(2, dashaMap.size());
    }
    @Test
    void setGetTest3(){
        DashaMap<String, String> dashaMap = new DashaMap(new HashingThree());
        dashaMap.set("Fiber", "Look");
        String actual = dashaMap.get("Fiber");
        Assertions.assertEquals("Look", actual);
        Assertions.assertEquals(1, dashaMap.size());
        Assertions.assertFalse(dashaMap.isEmpty());
    }
    @Test
    void setRemoveTest(){
        DashaMap<String, String> dashaMap = new DashaMap();
        dashaMap.set("Fiber", "Look");
        dashaMap.delete("Fiber");
        String actual = dashaMap.get("Fiber");
        Assertions.assertNull(null, actual);
        Assertions.assertEquals(0, dashaMap.size());
        Assertions.assertTrue(dashaMap.isEmpty());
    }
    @Test
    void setResizeTest(){
        DashaMap<String, String> dashaMap = new DashaMap(new HashingOne());
        dashaMap.set("a", "Look");
        dashaMap.set("b", "Look");
        dashaMap.set("c", "Look");
        dashaMap.set("d", "Look");
        dashaMap.set("e", "Look");
        dashaMap.set("f", "Look");
        dashaMap.set("g", "Look");
        dashaMap.set("h", "Look");
        dashaMap.set("i", "Look");
        dashaMap.set("j", "Look");
        dashaMap.set("k", "Look");
        Assertions.assertEquals("Look", dashaMap.get("a"));
        Assertions.assertEquals("Look", dashaMap.get("b"));
        Assertions.assertEquals("Look", dashaMap.get("c"));
        Assertions.assertEquals("Look", dashaMap.get("d"));
        Assertions.assertEquals("Look", dashaMap.get("e"));
        Assertions.assertEquals("Look", dashaMap.get("f"));
        Assertions.assertEquals("Look", dashaMap.get("g"));
        Assertions.assertEquals("Look", dashaMap.get("h"));
        Assertions.assertEquals("Look", dashaMap.get("i"));
        Assertions.assertEquals("Look", dashaMap.get("j"));
        Assertions.assertEquals("Look", dashaMap.get("k"));
        Assertions.assertEquals(11, dashaMap.size());
    }

    @Test
    void setGetTestInteger(){
        DashaMap<Integer, String> dashaMap = new DashaMap();
        dashaMap.set(1, "Look");
        String actual = dashaMap.get(1);
        Assertions.assertEquals("Look", actual);
        Assertions.assertEquals(1, dashaMap.size());
    }
}
