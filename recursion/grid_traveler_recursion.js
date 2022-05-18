// So you are given a grid of size M * N. A traveller is standing at the top left corner and he needs to go to the bottom right corner, but he can only move right and down. How many ways are there to reach the destination?

const gridTravelerRec = (m, n) => {
    if (m === 1 || n === 1) return 1
    return gridTravelerRec(m - 1, n) + gridTravelerRec(m, n - 1)
}

console.log(gridTravelerRec(1, 1)) // 1
console.log(gridTravelerRec(2, 3)) // 3
console.log(gridTravelerRec(3, 2)) // 3
console.log(gridTravelerRec(3, 3)) // 6
console.log(gridTravelerRec(18, 18)) // 2333606220 ( takes way loooooooong to run )

// Complexity Analysis:

// time complexity: O(2^(m+n))
// because the height of the recursion tree is m + n and at every step you have 2 options so the total operations are 1*2*2*2*2*2....m+n times.

// space complexity: O(m+n)
// because at max stack will contain m+n elements
