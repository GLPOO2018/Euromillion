package fr.esiea.euro.dao.csv;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractCsvEuroDaoTest {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractCsvEuroDaoTest.class);
    private final static String RESOURCES_PATH = "src/test/resources/";
    private final static String RESULTS_FILE_NAME = "results.csv";
    protected CsvEuroDao dao;
    
    @Before
    public void doBefore() {
        LOGGER.debug("doBefore Beginning");
	    final File file = new File(RESOURCES_PATH + RESULTS_FILE_NAME);
        dao.init(file);
	    LOGGER.debug("doBefore End");
    }
    
    @Test
    public void testNbLines() {
        LOGGER.debug("testNbLines Beginning");
        final int expectedLinesNb =160;
        LOGGER.debug("testNbLines End");
        final List<int[]> combi =  dao.findAllCombinations();
        // Assert
        Assert.assertEquals(expectedLinesNb, combi.size());

        LOGGER.debug("testNbLines... Fin");
    }
    
    
}
