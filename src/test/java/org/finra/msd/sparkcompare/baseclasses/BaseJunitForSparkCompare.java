package org.finra.msd.sparkcompare.baseclasses;

import org.finra.msd.memorydb.MemoryDbHsql;
import org.finra.msd.sparkfactory.SparkFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseJunitForSparkCompare {

    protected final String outputDirectory = System.getProperty("user.dir") + "/sparkOutputDirectory";

    @BeforeClass
    public static void setUpClass() {
        SparkFactory.initializeSparkLocalMode("local[*]");
        MemoryDbHsql.getInstance().initializeMemoryDB();
        MemoryDbHsql.getInstance().stageTablesAndTestData();
    }

    @AfterClass
    public static void tearDownClass() {
        SparkFactory.stopSparkContext();
        MemoryDbHsql.getInstance().shutdownMemoryDb();
    }
}