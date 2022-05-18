// write a function bestSum(targetSum, numbers) that takes in a targetSum and an array of numbers.
// the function should return an array containing the shortest combination of numbers that adds up to the targetSum.
// if tie, you can return any

// similar to previous problem, but optimized

const bestSum = (targetSum, numbers) => {
    if (targetSum === 0) return []
    if (targetSum < 0) return null

    let shortestCombination = null

    for (let num of numbers) {
        const remainder = targetSum - num
        const remainderCombination = bestSum(remainder, numbers)
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

    return shortestCombination
}

console.log(bestSum(7, [5, 3, 4, 7])) // [7]
console.log(bestSum(8, [2, 3, 5])) // [3, 5]
console.log(bestSum(8, [1, 4, 5])) // [4, 4]
console.log(bestSum(100, [1, 2, 5, 25])) // [ 25, 25, 25, 25]

// same here the last one takes a lot of time so we will have to optimize it

// Complexity Analysis:

// m = targetSum
// n = numbers.length

// the time complexity is same as the previous problem hasSum O(n^m * m)

// the space complexity is stack + shortest array
// this time every recursion call has its own shortest array and that has to be stored on the stack, so every function call will create a new array of worst case being O(m), so the space complexity becomes O(m*m)
