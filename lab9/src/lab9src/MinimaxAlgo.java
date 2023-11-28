package lab9src;

public class MinimaxAlgo {
    public Node bestMoveForMin;

    public void execute(Node node) {
        int v = minValue(node);
        System.out.println("Best move for MIN player: " + bestMoveForMin);
        System.out.println("Value of the move: " + v);
    }

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
    public int maxValue(Node node) {
        if (node.isTerminal()) {
            return utility(node);
        }
        int v = Integer.MIN_VALUE;
        for (Node child : node.getSuccessors()) {
            int minVal = minValue(child);
            if (minVal > v) {
                v = minVal;
            }
        }
        return v;
    }

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

    public int minValue(Node node) {
        if (node.isTerminal()) {
            return utility(node);
        }
        int v = Integer.MAX_VALUE;
        for (Node child : node.getSuccessors()) {
            int maxVal = maxValue(child);
            if (maxVal < v) {
                v = maxVal;
                bestMoveForMin = child;
            }
        }
        return v;
    }
	
    private int utility(Node node) {
        return node.isTerminal() ? -1 : 0; 
    }
}
