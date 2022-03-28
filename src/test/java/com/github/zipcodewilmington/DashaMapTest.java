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
        DashaMap<String, String> dashaMap = new DashaMap(new HashingOne());
        dashaMap.set("Fiber", "Look");
        dashaMap.delete("Fiber");
        String actual = dashaMap.get("Fiber");
        Assertions.assertNull(null, actual);
        Assertions.assertEquals(0, dashaMap.size());
        Assertions.assertTrue(dashaMap.isEmpty());
    }
}
