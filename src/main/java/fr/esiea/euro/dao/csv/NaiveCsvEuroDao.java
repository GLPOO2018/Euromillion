package fr.esiea.euro.dao.csv;

import java.io.File;
import java.util.List;

public class NaiveCsvEuroDao implements CsvEuroDao {


	private File file;


	
	@Override
	public void init(File file) {
		this.file = file;
	}
	
	@Override
	public List<int[]> findAllCombinations()  {


		throw new UnsupportedOperationException("pas encore implémenté.");

	}


	public File getFile() {
		return file;
	}

	

}
