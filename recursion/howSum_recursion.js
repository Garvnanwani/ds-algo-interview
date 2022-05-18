// write a function howSum(targetSum, numbers) that returns an array of any combination of numbers that add up to the targetSum.
// If there are multiple return any one of them, if there are none return null.

const howSum = (targetSum, numbers) => {
    if (targetSum === 0) return []
    if (targetSum < 0) return null

    for (let num of numbers) {
        const remainder = targetSum - num
        const remainderResult = howSum(remainder, numbers)

        if (remainderResult != null) {
            return [...remainderResult, num]
        }
    }

    return null
}

console.log(howSum(7, [2, 3])) // [3, 2, 3]
console.log(howSum(7, [5, 3, 4, 7])) // [4 ,3]
console.log(howSum(7, [2, 4])) // null
console.log(howSum(8, [2, 3, 5])) // [2, 2, 2, 2]
console.log(howSum(300, [7, 14])) // null

// okay so similar thing here, the last one takes a long time and we need to optimize it using dp

// Complexity Analysis:

// lets see its time complexity
// m = targetSum
// n = numbers.length

// looks like the complexity will be similar to that of canSum problem but there is a catch here, the array copying thing, its an O(m) operation because in worst case you will have to copy all the elements in the the new array

// so time complexity becomes O(n^m * m)

// space complexity is
// stack space + array space
// in worst case stack space is O(m) thats height
// in worst case array space is O(m) coz you will have to add m elements in the array say if the numbers is when [1]

// so total space complexity is O(m + m) thats O(m)
