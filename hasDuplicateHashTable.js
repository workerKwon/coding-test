function hasDuplicateUsingHashTable(arr) {
    let existingNumbers = {}
    for(let i = 0; i < arr.length; i++) {
        if(existingNumbers[arr[i]] === undefined) {
            existingNumbers[arr[i]] = 1
        } else {
            return true
        }
    } 
    return false
}