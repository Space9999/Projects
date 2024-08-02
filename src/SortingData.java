import java.util.ArrayList;

/**
 * A class that is intended to store data matrices and manipulate such matrices.
 * Some possible usecases for this could be simple storage and manipulation of organized data sets
 * 
 * @author sbodd
 *
 */

public class SortingData {
	
	
	private ArrayList<String[]> list;
	private int cols;
	
	// For testing purposes
	public static void main(String[] args) {
		SortingData e = new SortingData(4);
		e.addLine(e.constructLine("Smith", "Kelly", "438675", "78.6"));
		e.addLine(e.constructLine("John", "Bob", "329454", "89.6"));
		e.addLine(e.constructLine("Row", "Dot", "102843", "34.6"));
		e.addLine(e.constructLine("Sit", "Buddy", "293453", "56.7"));
		e.sortDataByCol(0, e.getSize() - 1, 2);
		e.printData();
	}
	
	// This only allows for a set amount of cols for each matrix
	public SortingData(int cols) {
		list = new ArrayList<String[]>();
		this.cols = cols;
	}
	
	public String[] constructLine(String... args) {
		String[] temp = new String[cols]; int index = 0;
		for (String arg : args) {
			if (index == cols) {System.out.println("Too much data to fit into columns"); break;}
			temp[index] = arg; index++;
		}
		while (index < cols) {
			temp[index] = "Missing Data"; index++;
			if (index >= cols) {break;}
		}
		return temp;
	}
	
	public void addLine(String[] data) {
		list.add(data);
	}
	
	// Implementation of merge sort for this type of data structure
	public void sortDataByCol(int start, int end, int col) {
		if (start < end) {
			int m = (start + end) / 2;
			sortDataByCol(start, m, col);
			sortDataByCol(m + 1, end, col);
			merge(start, m, end, col);
		}
	}
	
	private void merge(int start, int middle, int end, int col) {
		int size1 = middle - start + 1, size2 = end - middle;
		ArrayList<String[]> p1 = new ArrayList<String[]>(), p2 = new ArrayList<String[]>();
		for (int i = 0; i < size1; i++) {
			if (list.get(i)[col].equals("Missing Data")) {System.out.println("Region contains missing data"); return;}
			p1.add(list.get(i + start));
		}
		for (int j = 0; j < size2; j++) {
			if (list.get(j)[col].equals("Missing Data")) {System.out.println("Region contains missing data"); return;}
			p2.add(list.get(middle + j + 1));
		}
		int i = 0, j = 0, k = start;
		while (i < size1 && j < size2) {
			if (p1.get(i)[col].compareTo(p2.get(j)[col]) <= 0) {
				list.set(k, p1.get(i)); i++;
			}
			else {
				list.set(k, p2.get(j)); j++;
			}
			k++;
		}
		while (i < size1) {
			list.set(k, p1.get(i)); i++; k++;
		}
		while (j < size2) {
			list.set(k, p2.get(j)); j++; k++;
		}
	}
	
	public int getSize() {
		return list.size();
	}
	
	// Quick way to output data matrix
	public void printData() {
		for (String[] i : list) {
			for (int j = 0; j < i.length - 1; j++) {
				System.out.print(i[j] + ", ");
			}
			System.out.print(i[i.length - 1]); System.out.println("");
		}
	}
	
	public String toString() {
		String s = "[";
		for (String[] i : list) {
			s += "[";
			for (int j = 0; j < i.length - 1; j++) {
				s += i[j] + ", ";
			}
			s += i[i.length - 1] + "]";
		}
		return s + "]";
	}
}
