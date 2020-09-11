package net.proteanit.sql;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 3141832967774448551L;

	public MyTableModel(Vector<Vector<Object>> rows, Vector<String> columnNames) {
		super(rows, columnNames);
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

}