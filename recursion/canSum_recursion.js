// write a function canSum(targetSum, numbers) that returns true if there is a way to sum up to targetSum using the numbers in numbers array.
// the return should be a boolean
// you can use any number in the array as many times as you want
// you may assume all the numbers are non negative

const canSum = (targetSum, numbers) => {
    if (targetSum === 0) return true
    if (targetSum < 0) return false
    if (numbers.length === 0) return false

    for (let num of numbers) {
        const remainder = targetSum - num
        if (canSum(remainder, numbers)) return true
    }

    return false
}

console.log(canSum(7, [2, 3])) // true
console.log(canSum(7, [5, 3, 4, 7])) // true
console.log(canSum(7, [2, 4])) // false
console.log(canSum(7, [2, 3, 5])) // true
console.log(canSum(300, [7, 14])) // false ( takes tooo longgg )

// this is a good brute force solution, but its way too slow for larger inputs

// Complexity Analysis:

// lets calculate time complexity
// so how did we calculate time complexity till now, number of operations right ?
// lets get the tree, in it we have targetSum as root, then children are the target sum minus the elements in the array number
// time complexity looks something like no of children or option at each step to the power of height of tree in worst case
// what can be the height in worst case ? target sum ?
// coz suppose all the elements in the array are 1 then you go down targetSum times down so it becomes height lets call it m
// how many options do you have at each step ?
// equal to size of array coz you subract the target sum from all of those and they become children, lets call it n
// so time complexity final worst case becomes O(n^m)

// and space complexity is O(m) // max height of tree in worst case
