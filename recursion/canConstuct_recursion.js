// Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings
// the function should return a boolean indicating whether or not the target string can be constructed by concatenating the elements of the wordBank array.
// You can reuse the elements of the wordBank array as many times as necessary.

const canConstruct = (target, wordBank) => {
    if (target === '') return true

    for (let word of wordBank) {
        // or target.indexOf(word) === 0
        if (target.startsWith(word)) {
            if (canConstruct(target.slice(word.length), wordBank)) {
                return true
            }
        }
    }

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

// okay so similar thing here, the last one takes a long time and we need to optimize it using dp

// Complexity Analysis:

// lets calculate the time complexity

// m = target.length
// n = wordBank.length

// what could be the worst case ?
// when you keep taking one one character at a time such as our last example, in this case the total depth of the tree will be m
// what choices do we have at each step - n
// and also we are doing a slice operation on the target string, which basically copies the string into some other string and in the case we copy over the whole string, so that a O(m) operation
// so the time complexity will be O(n^m * m)

// the space complexity is stack + string in each stack
// since we are creating a new string in every recursive call, before the return statement, so the string needs to be stored on the stack and that is O(m) operation, so in total it becomes O(m * m), for the stack size and each stack to do an O(m) operation

// so the space complexity is O(m * m) or O(m^2)
