// newArray 라는 배열 공간을 하나 더 만들었다.
function makeUpperCase(array) {
    const newArray = []
    for(let i = 0; i < array.length; i++) {
        newArray.push(array[i].toUpperCase())
    }
    return newArray
}

// 변수를 만들지 않고 파라미터를 바로 변경해서 반환했다.
function makeUpperCaseSpaceComplexity(array) {
    for(let i = 0; i < array.length; i++) {
        array[i] = array[i].toUpperCase()
    }
    return array
}

const arr = ['a', 'b', 'c', 'd']
console.log(makeUpperCaseSpaceComplexity(arr))