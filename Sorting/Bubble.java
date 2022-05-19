static void bubbleSort(int[] arr) {

		for(int i =0; i<arr.length-1; i++){

			for(int j =i+1; j<arr.length; j++){
				if(arr[i] > arr[j]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
			}

			}
		}
	}