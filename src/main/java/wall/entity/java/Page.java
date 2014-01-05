package wall.entity.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Page<E> implements Iterable<E> {

	private int number;
	private boolean last;
	private List<E> rows;
	
	public Page() {
		this(new ArrayList<E>(), 1);
	}
	
	public Page(List<E> rows, int number, boolean last) {
		this.rows = rows;
		this.number = number;
		this.last = last;
	}
	
	public Page(List<E> rows, int number) {
		this(rows, number, false);
	}

	@Override
	public Iterator<E> iterator() {
		return rows.iterator();
	}

	public int getNumber() {
		return number;
	}
	
	public int getSize() {
		return rows.size();
	}

	public boolean isLast() {
		return last;
	}
	
	public boolean isFirst() {
		return number == 1;
	}
}
