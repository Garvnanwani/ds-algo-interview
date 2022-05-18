const bestSum = (targetSum, numbers, memo = {}) => {
    if (targetSum in memo) return memo[targetSum]
    if (targetSum === 0) return []
    if (targetSum < 0) return null

    let shortestCombination = null

    for (let num of numbers) {
        const remainder = targetSum - num
        const remainderCombination = bestSum(remainder, numbers, memo)
        if (remainderCombination != null) {
            const combination = [...remainderCombination, num]
            // if the combination is shorter than the current shortest combination, replace it
            if (
                shortestCombination === null ||
                combination.length < shortestCombination.length
            ) {
                shortestCombination = combination
            }
        }
    }

    memo[targetSum] = shortestCombination
    return shortestCombination
}

console.log(bestSum(7, [5, 3, 4, 7])) // [7]
console.log(bestSum(8, [2, 3, 5])) // [3, 5]
console.log(bestSum(8, [1, 4, 5])) // [4, 4]
console.log(bestSum(100, [1, 2, 5, 25])) // [ 25, 25, 25, 25]

// Complexity Analysis:

// Time Complexity: O(n * m * m) or O(n * m^2) same as before
// Space Complexity: O(m * m) or O(m^2) same as recursion
