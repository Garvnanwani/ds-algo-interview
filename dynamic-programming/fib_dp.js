// memoization
// js object, keys will be arg to function, value will be the return valuee

const fib = (n, memo = {}) => {
    if (n in memo) return memo[n]

    if (n <= 1) {
        return n
    }

    memo[n] = fib(n - 1, memo) + fib(n - 2, memo)

    return memo[n]
}

console.log(fib(5))
console.log(fib(6))
console.log(fib(7))
console.log(fib(40))
console.log(fib(70)) // fast af

// the technique we use here is called memoization, which by name you can tell means that we memorize something that happened before.
// we use some fast read or access data structures to store the results of our recursive calls, usually that will be hashmap or object.

// the problem with recursive approach is that you calculate already calculated values again and again
// say i calculate fib(7), we need fib(6) and fib(5), and for fib(6) we need fib(5) and fib(4), why calculate fib(5) for fib(7) when you already calculated it once in fib(6).
// Cant we just store this information somewhere and reuse it if we come over it again because common fibbonaceeees dont change with time.

// DP is about identifying the subproblem and the solution to the subproblem, thats recursion but with some pattern thats repeating, and takes over calculation

// Complexity Analysis:

// time complexity is O(n), visualize and you will  realize we only make 2n operations now which can be generalized to O(n)

// space complexity is O(n) - stack O(n) + memo O(n)
