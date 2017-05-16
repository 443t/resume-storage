package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by vp on 15.05.17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    ArrayStorageTest.class,
    SortedArrayStorageTest.class,
    ListStorageTest.class,
    MapUuidStorageTest.class,
    MapResumeStorageTest.class
        } )
public class AllStorageTest {
    
    
}
