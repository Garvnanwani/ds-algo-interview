//starting
//we have two arrays that contain the weights and values of the items and a knapsack capacity and we need to find the maximum value of items that can be put in the knapsack
//we can use the following formula to find the maximum value of items that can be put in the knapsack
const knapsack = (weight, value, W, n) => {
    if (n === 0 || W === 0) {
        return 0
    }
    if (weight[n - 1] > W) {
        return knapsack(weight, value, W, n - 1)
    } else {
        return Math.max(
            value[n - 1] + knapsack(weight, value, W - weight[n - 1], n - 1),
            knapsack(weight, value, W, n - 1)
        )
    }
}
console.log(knapsack([1, 2, 3, 4, 3], [1, 2, 3, 4, 3], 10, 5))
// time complexity is O(2^n) as we using recusion which having two option evrytime, wether to take that item or to reject it.
// space complexity is O(n) ,stack will store N number of recursion calls in worst case;
