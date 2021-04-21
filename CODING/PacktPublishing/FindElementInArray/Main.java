class Main {
	
	public static void main(String args[]) {
		
		// array of numbers
		int numbers[] = new int[]{4, 5, 1, 3, 7, 4, 1, 5};

		// array of objects
		Melon[] melons = new Melon[] {
			new Melon("Crenshaw", 20), new Melon("Gac", 12), new Melon("Bitter", 22)
		};

		// Comparators
		Comparator<Melon> byType = Comparator.comparing(Melon::getType);
		Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);	

		System.out.println("Check only for presence:");
		System.out.println("------------------------");


	}
}
