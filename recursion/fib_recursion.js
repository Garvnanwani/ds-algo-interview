const fib = (n) => {
    if (n < 2) return n
    return fib(n - 1) + fib(n - 2)
}

// this approach isnt bad, but the prb is that for every number it has to calculate the fibonacci of n-1 and n-2 and for them too we have to go back all the way to fib(1) every single time. So, we calculate things that we have already calculated in the past over and over again.

// This works for smaller numbers, but is a disaster for larger numbers

console.log(fib(5)) // these are easy
console.log(fib(6))
console.log(fib(7))
console.log(fib(40)) // somewhat long
console.log(fib(70)) // very loooong to calculate

// Complexity Analysis:

// time complexity: O(2^n)
// space complexity: O(n)

// here n is the height or level of the tree.
// space why n because at max our stack will have n values and they will pop out of stack as they return something

// why time complexity O(2^n) ?
// we have to calculate how many operations we do right
// if we had a single call just fib(n-1) we will do at max n-1 operations, but here at every step we do 2 operations, so to find total operations we do 1*2*2*2*2*2.... n times thats 2^n operations
// 1 is the parent operation and at every step 2 more operations

// you know what that means?
// to calculate fib(50), your computer has to do 2^50 steps,
// and thats around 1.12e + 15....( 16 digit number)
// 1125899906842624
