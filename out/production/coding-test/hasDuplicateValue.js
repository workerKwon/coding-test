function hasDuplicateValue(arr) {
    let existingNumbers = []
    for(let i of arr) {
        if(existingNumbers[i] === undefined) {
            existingNumbers[i] = 1
        } else {
            return true
        }
    }
    // for(let i = 0 ; i < arr.length; i++) {
    //     if(existingNumbers[arr[i]] === undefined) {
    //         existingNumbers[arr[i]] = 1
    //     } else {
    //         return true
    //     }
    // }
    return false
}



const arr1 = [1,2,3,4]
console.log(hasDuplicateValue(arr1))

const arr2 = [1,2,3,3]
console.log(hasDuplicateValue(arr2))