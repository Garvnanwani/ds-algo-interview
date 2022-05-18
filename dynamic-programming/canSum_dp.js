const canSum = (targetSum, numbers, memo = {}) => {
    if (targetSum in memo) return memo[targetSum]
    if (targetSum === 0) return true
    if (targetSum < 0) return false
    if (numbers.length === 0) return false

    for (let num of numbers) {
        const remainder = targetSum - num
        if (canSum(remainder, numbers, memo)) {
            memo[targetSum] = true
            return true
        }
    }

    memo[targetSum] = false
    return false
}

console.log(canSum(7, [2, 3])) // true
console.log(canSum(7, [5, 3, 4, 7])) // true
console.log(canSum(7, [2, 4])) // false
console.log(canSum(7, [2, 3, 5])) // true
console.log(canSum(300, [7, 14])) // false

// Complexity Analysis:

// the time complexity is O(m*n), coz in worst case you will have to check for all the numbers in the array and the height will be m

// the space complexity is O(m)
