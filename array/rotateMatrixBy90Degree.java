static public void rotateBy90(ArrayList<ArrayList<Integer>> a){
	int N = a.size();
	//	Get number of layers in the matrix
	int layers = N/2;
	
	//	Iterate over each layer of matrix and do rotation layer-by-layer, starting with the outermost layer
	for(int i = 0; i < layers; i++){
		//	first and last are lowest and highest index of any point, Eg: (x,y) then x and y are <= last and >= start
		int first = i, last = N - i - 1;
		System.out.println(first + " " + last);
		//	Each layer will have (last - first) set of four elements to be rotated, Eg: For 4x4 matrix, it will 3 i.e. first = 0, last = 3
		for(int j = 0; j < (last - first); j++){
			//	Store four points to be interchanged in variables
			int m = a.get(first).get(j + first);
			int n = a.get(j + first).get(last);
			int o = a.get(last).get(last - j);
			int p = a.get(last - j).get(first);

			//	Set four points according to 90 degree rotation
			a.get(first).set(j + first, p);
			a.get(j + first).set(last, m);
			a.get(last).set(last - j, n);
			a.get(last - j).set(first, o);
		}
	}
}