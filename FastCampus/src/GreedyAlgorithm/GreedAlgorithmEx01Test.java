package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedAlgorithmEx01Test {

	public static void main(String[] args) {
		
		GreedyAlgorithmEx01 gObject = new GreedyAlgorithmEx01();
		ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
		gObject.coinFunc(4720, coinList);

	}

}
