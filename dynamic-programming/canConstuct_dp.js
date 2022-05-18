const canConstruct = (target, wordBank, memo = {}) => {
    if (target in memo) return memo[target]
    if (target === '') return true

    for (let word of wordBank) {
        // or target.indexOf(word) === 0
        if (target.startsWith(word)) {
            if (canConstruct(target.slice(word.length), wordBank, memo)) {
                memo[target] = true
                return true
            }
        }
    }

    memo[target] = false
    return false
}

console.log(canConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd'])) // true
console.log(
    canConstruct('skateboard', ['bo', 'rd', 'ate', 't', 'ska', 'sk', 'boar'])
) // false
console.log(
    canConstruct('enterapotentpot', ['a', 'p', 'ent', 'enter', 'ot', 'o', 't'])
) // true
console.log(
    canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
        'e',
        'eee',
        'eee',
        'eeee',
        'eeeee',
        'eeeeee',
        'eeeeeee',
    ])
) // false

// Complexity Analysis:

// m = target.length
// n = wordBank.length

// the time complexity will be O(n * m^2), coz now we do n * m operations and that O(m) for slice

// the space complexity will be O(m*m) same as recursion even if we add a memo extra object
