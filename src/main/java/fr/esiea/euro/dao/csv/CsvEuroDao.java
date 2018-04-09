package fr.esiea.euro.dao.csv;

import java.io.File;

import fr.esiea.euro.dao.EuroDao;


public interface CsvEuroDao extends EuroDao {

	/**
	 * Initialisation du DAO.
	 * 
	 * @param file
	 */
	public void init(File file);
}
