package L25_April14;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Apr-2019
 *
 */

public class HeapGenericComp<T> {

	private ArrayList<T> data = new ArrayList<>();
	private Comparator<T> comp;

	public HeapGenericComp(Comparator<T> comp) {
		this.comp = comp;
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T item) {

		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public T remove() {

		swap(0, data.size() - 1);

		T rv = data.remove(data.size() - 1);
		downheapify(0);

		return rv;
	}

	private void downheapify(int pi) {

		int lci = (2 * pi) + 1;
		int rci = (2 * pi) + 2;

		int mini = pi;

		if (lci < data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	// t priority greater -> +ve
	// o priority greater -> -ve
	public int isLarger(T t, T o) {
		return comp.compare(t, o);
	}

}
