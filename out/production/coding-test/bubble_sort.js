function bubble_sort(list) {
    let unsorted_until_index = list.length - 1 // 어느 인덱스까지 정렬이 안됐는지 표시(처음에는 맨마지막 인덱스까지 안됐기 때문에 length - 1)
    let sorted = false // 정렬이 완료 됐는지 표시

    while(!sorted) { // 정렬이 안됐다면 반복
        sorted = true // 어떤 교환도 생기지 않는다면 배열이 완전히 정렬된 상태라는 뜻으로 sorted가 true로 while 반복문이 끝날것이다.
        for(let i = 0; i < unsorted_until_index; i++) { // 정렬이 안됀 index까지 비교, 교환을 반복
            if(list[i] > list[i+1]) {
                sorted = false // 교환이 발생하는 상황이면 완전히 정렬되지 않은 상태로 sorted를 false로 바꿔준다.
                const temp = list[i+1] // 값을 교환해준다.
                list[i+1] = list[i]
                list[i] = temp
            }
        }
        unsorted_until_index -= 1 // 한번 패스스루가 끝나면 맨 마지막 index에는 가장 큰 수가 들어가게 됨으로, 맨 마지막 index는 정렬된 상태이다
        // 한번 패스스루가 끝날 때마다 정렬된 index를 -1 해준다.
    }
}

let arr = [65, 45, 55, 35, 15, 25, 10]
bubble_sort(arr)
console.log(arr)