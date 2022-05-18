const howSum = (targetSum, numbers, memo = {}) => {
    if (targetSum in memo) return memo[targetSum]
    if (targetSum === 0) return []
    if (targetSum < 0) return null

    for (let num of numbers) {
        const remainder = targetSum - num
        const remainderResult = howSum(remainder, numbers, memo)

        if (remainderResult != null) {
            memo[targetSum] = [...remainderResult, num]
            return memo[targetSum]
        }
    }

    memo[targetSum] = null
    return null
}

console.log(howSum(7, [2, 3])) // [3, 2, 3]
console.log(howSum(7, [5, 3, 4, 7])) // [4 ,3]
console.log(howSum(7, [2, 4])) // null
console.log(howSum(8, [2, 3, 5])) // [2, 2, 2, 2]
console.log(howSum(300, [7, 14])) // null

// Complexity Analysis:

// time complexity for this will be O(m*n*m), same as canSum times m
// thats O(n*m^2)

// space complexity is space + return array + memo object
// stack = O(m)
// return array = O(m)
// memo object = O(m*m) why because we have keys and values in it, key is targetSum and value is array, at worst there can be m keys and for each an array of size m so m times m
// thats O(m*m) or O(m^2)
