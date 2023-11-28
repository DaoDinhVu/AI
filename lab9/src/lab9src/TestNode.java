package lab9src;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
		
		// Test 1: A terminal node (all piles have one token)
        Node terminalNode = new Node();
        terminalNode.addAll(Arrays.asList(1, 1, 1));
        System.out.println("Test 1 - Expected: true, Actual: " + terminalNode.isTerminal());

        // Test 2: A non-terminal node (at least one pile has more than one token)
        Node nonTerminalNode = new Node();
        nonTerminalNode.addAll(Arrays.asList(1, 2, 3));
        System.out.println("Test 2 - Expected: false, Actual: " + nonTerminalNode.isTerminal());
        
        // Test 1: A node with a single pile
        Node singlePileNode = new Node();
        singlePileNode.addAll(Arrays.asList(3));
        testGetSuccessors(singlePileNode, "Test 1");

        // Test 2: A node with multiple piles
        Node multiplePileNode = new Node();
        multiplePileNode.addAll(Arrays.asList(2, 3));
        testGetSuccessors(multiplePileNode, "Test 2");
        
        // Test: Evaluate the root node value for a given game state
        Node rootNode = new Node();
        rootNode.addAll(Arrays.asList(3, 4)); // Example game state
        MinimaxAlgo algo1 = new MinimaxAlgo();
        int rootValue = algo1.maxValue(rootNode); // Assuming root is a MAX node
        System.out.println("Value at the root node: " + rootValue);
        
        // Create a game state
        Node rootNode1 = new Node();
        rootNode1.addAll(Arrays.asList(3, 4)); // Example game state

        // Execute Minimax algorithm
        MinimaxAlgo algo11 = new MinimaxAlgo();
        algo11.execute(rootNode1);
        
        //test task 5
        testGameState(8);
        testGameState(9);
	}
    private static void testGetSuccessors(Node node, String testName) {
        List<Node> successors = node.getSuccessors();
        System.out.println(testName + " - Successors: ");
        for (Node successor : successors) {
            System.out.println(successor);
        }
        System.out.println();
    }
    private static void testGameState(int tokenCount) {
        Node rootNode = new Node();
        rootNode.add(tokenCount); // Initialize with a single pile of 'tokenCount' tokens

        MinimaxAlgo algo = new MinimaxAlgo();
        System.out.println("Testing game state with " + tokenCount + " tokens:");
        algo.execute(rootNode);
        System.out.println();
    }
}