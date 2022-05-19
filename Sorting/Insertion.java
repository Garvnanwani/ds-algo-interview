static void insertionSort(int[] arr) {


		for (int i=1;i <arr.length ;i++ ) {
			int sel= arr[i];
			int j = i-1;
			while(j>=0 && sel < arr[j]){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] =temp;
				j--;
				i--;
			}

		}
	}
