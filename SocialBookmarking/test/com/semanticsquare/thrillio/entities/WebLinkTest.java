package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class WebLinkTest {
    @Test
    public void testIsKidFriendlyElegible(){
        // Test 1: porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
                "http://www.javaworld.com");

        boolean isKidfriendlyEligible =  webLink.isKidFriendlyElegible();

        assertFalse("For porn in url - isKidFriendlyElegible() must return false", isKidfriendlyEligible);
        // Test 2: porn in title -- false

        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");

        isKidfriendlyEligible =  webLink.isKidFriendlyElegible();

        assertFalse("For porn in title - isKidFriendlyElegible() must return false", isKidfriendlyEligible);
        // Test 3: adult in host -- false

        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.adultjavaworld.com");

        isKidfriendlyEligible =  webLink.isKidFriendlyElegible();

        assertFalse("For porn in host - isKidFriendlyElegible() must return false", isKidfriendlyEligible);
        // Test 4: adult in url but not in host part -- true;

         webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
                "http://www.javaworld.com");

         isKidfriendlyEligible =  webLink.isKidFriendlyElegible();

        assertTrue("For porn in url - isKidFriendlyElegible() must return false", isKidfriendlyEligible);
        // Test 5: adult in title only -- true

        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");

        isKidfriendlyEligible =  webLink.isKidFriendlyElegible();

        assertTrue("For porn in url - isKidFriendlyElegible() must return false", isKidfriendlyEligible);

    }

}
