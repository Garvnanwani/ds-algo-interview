static void mergeSort(int[] arr, int start, int end) {
		if(start < end){
				int mid = start +(end - start)/2;

				mergeSort(arr, 0, mid);
				mergeSort(arr, mid+1, end);
				mergeArr(arr, start, mid, end);
			}
	}

	static void mergeArr(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start +1];
		int i = start, j= mid+1, k=0;
		while(i<=mid && j <=end){
			if(arr[i] <= arr[j]){
					temp[k] = arr[i];
					i++;

			}else{
					temp[k] = arr[j];
					j++;
			}
			k++;
		}
		while(i<=mid ){
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=end){
			temp[k] = arr[j];
			j++;
			k++;
		}

		for(int a =start; a <=end; a++){
			arr[a] = temp[a -start];
		}
	}