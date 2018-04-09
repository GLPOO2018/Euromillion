package fr.esiea.euro.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvEuroDAO {

	private final String fileName;
	
	public CsvEuroDAO(String fileName) {
		this.fileName = fileName;
	}
	
	private List<String> readFile() throws Exception {
		final List<String> lines = new ArrayList<String>();
		
		final FileReader fr = new FileReader(fileName);
        final BufferedReader br = new BufferedReader(fr);
        
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            lines.add(line);
        }
        
        br.close();
        fr.close();
        
		return lines;
	}
	
	private int[] transform(String line) {
		final String[] tab = line.split(";");
		int[] combi = new int[8];
		
		combi[0] = Integer.valueOf(tab[0]);
		combi[1] = Integer.valueOf(tab[5]);
		combi[2] = Integer.valueOf(tab[6]);
		combi[3] = Integer.valueOf(tab[7]);
		combi[4] = Integer.valueOf(tab[8]);
		combi[5] = Integer.valueOf(tab[9]);
		combi[6] = Integer.valueOf(tab[10]);
		combi[7] = Integer.valueOf(tab[11]);
		
		return combi;
	}
	
	public List<int[]> findAllCombinations() {
		
		final List<int[]> combinations = new ArrayList<>();
		
		try {
			final List<String> lines = readFile();
			boolean first = true;
			for (String line : lines) {
				if (first) {
					first = false;
					continue;
				}
				int[] combi = transform(line);
				combinations.add(combi);
			}
		} catch (Exception e) {
			System.exit(-1);
		}
		
		return combinations;
	}
	
}
