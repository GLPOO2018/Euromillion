package fr.esiea.euro.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.esiea.euro.dao.CsvEuroDAO;

public class EuroModel extends AbstractTableModel {

	private final String[] headers = { "Year & Draw", "1st Ball", "2nd Ball", "3rd Ball", "4th Ball", "5th Ball", "1st Star", "2nd Star" };
	private final List<int[]> combinations;
	
	public EuroModel() {
		combinations = createCombinations();
	}
	
	private List<int[]> createCombinations() {
		CsvEuroDAO csv = new CsvEuroDAO("src/main/resources/results.csv");
		return csv.findAllCombinations();
	}
	
	public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }
	
	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public int getRowCount() {
		return combinations.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final int[] combi = combinations.get(rowIndex);
		return combi[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return int.class;
	}

}
