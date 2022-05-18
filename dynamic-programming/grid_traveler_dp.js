const gridTravelerFib = (m, n, memo = {}) => {
    const key = m + ',' + n
    if (key in memo) return memo[key]
    if (m === 1 || n === 1) return 1
    memo[key] =
        gridTravelerFib(m - 1, n, memo) + gridTravelerFib(m, n - 1, memo)
    return memo[key]
}

console.log(gridTravelerFib(1, 1)) // 1
console.log(gridTravelerFib(2, 3)) // 3
console.log(gridTravelerFib(3, 2)) // 3
console.log(gridTravelerFib(3, 3)) // 6
console.log(gridTravelerFib(18, 18)) // 2333606220

// one thing to note is gridTravelerFib(m,n) = gridTravelerFib(n,m)

// Complexity Analysis:

// Time Complexity : O(m*n)
// because now the maximum number of operaions we have are till m becomes 0 and n becomes 0, we dont have to recalculate any value besides that.

// Space Complexity : O(m+n)

// the story of both questions fib and grid was same if you look closely, but they seemed a lootttt different question at first.

// the triiiicccck is ???????

// draw a tree
// tada

// nvm
// solve the prb for base cases and then draw graphs for sub problems like the input 2,2 or 2,3 and solve for smaller problems through some approach.
// for time complexity look at the height of tree and number of choices at each step
// tree helps both for brute force as well as dynamic programming
