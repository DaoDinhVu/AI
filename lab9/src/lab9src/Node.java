package lab9src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
	    List<Node> successors = new ArrayList<>();

	    for (int i = 0; i < this.data.size(); i++) {
	        int pile = this.data.get(i);
	        // Only divide piles of size 2 or greater
	        if (pile > 1) {
	            for (int j = 1; j < pile; j++) {
	                List<Integer> newData = new ArrayList<>(this.data);
	                // Remove the original pile and add two new piles
	                newData.remove(i);
	                newData.add(j);
	                newData.add(pile - j);

	                // Sort the new data to avoid duplicate states
	                Collections.sort(newData, Collections.reverseOrder());

	                Node newNode = new Node();
	                newNode.addAll(newData);
	                successors.add(newNode);
	            }
	        }
	    }

	    return successors;
	}



	// Check whether a node is terminal or not
	public boolean isTerminal() {
	    for (Integer pile : this.data) {
	        if (pile != 1) {
	            return false;
	        }
	    }
	    return true;
	}


	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
