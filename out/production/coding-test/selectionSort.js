function selectionSort(arr) {
    for(let i = 0; i < arr.length; i++) {
        let lowestNumberIndex = i
        for(let j = i+1; j < arr.length; j++) {
            if(arr[lowestNumberIndex] > arr[j]){
                lowestNumberIndex = j
            }
        }
        if(lowestNumberIndex !== i) {
            const temp = arr[i]
            arr[i] = arr[lowestNumberIndex]
            arr[lowestNumberIndex] = temp
        }
    }

    return arr
}

const arr = [8,4,5,2,9,3,1]
console.log(selectionSort(arr))

// 시간 복잡도는 버블정렬과 마찬가지로 O(N2)
// 근데 실제로는 선택정렬이 대략 2배정도 더 빠르다

//        N크기의 배열에서    1 패스스루
// 버블 정렬은 최악의 경우 | 비교-교환, 비교-교환, 비교-교환, ..........
// 선택 정렬은 최악의 경우 | 비교, 비교, 비교, .............., 교환