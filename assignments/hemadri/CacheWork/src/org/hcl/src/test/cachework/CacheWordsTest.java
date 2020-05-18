package org.hcl.src.test.cachework;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.hcl.src.java.cachework.CacheWords;
import org.junit.Test;

public class CacheWordsTest {

    @Test
    public void isWord_testWordPresent_shouldGetTrue() {
//        String testFileName = "C:/Users/user/eclipse-Filework/CacheWork";

        try {
            CacheWords cache = new CacheWords();
            boolean result = cache.isWord("various");
            assertEquals(true, result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void isWord_testWordPresent_shouldGetFalse() {
        try {
            CacheWords cache = new CacheWords();
            boolean result = cache.isWord("java");
            assertEquals(false, result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
