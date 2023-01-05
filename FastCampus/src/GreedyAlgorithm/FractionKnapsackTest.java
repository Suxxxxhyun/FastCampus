package GreedyAlgorithm;

public class FractionKnapsackTest {

	public static void main(String[] args) {
		
		FractionalKnapsackProblem gObject = new FractionalKnapsackProblem();
		Integer[][] objectList = {{10,10}, {15,12}, {20,10}, {25,8}, {30,5}}; 
		gObject.knapsackFunc(objectList, 30.0);

	}

}
