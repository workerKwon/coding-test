function bubble_sort(list) {
    let unsorted_until_index = list.length - 1
    let sorted = false

    while(!sorted) {
        sorted = true
        for(let i = 0; i < unsorted_until_index; i++) {
            if(list[i] > list[i+1]){
                sorted = false
                const temp = list[i+1]
                list[i+1] = list[i]
                list[i] = temp
            }
        }
        unsorted_until_index -= 1
    }
}

let arr = [65, 45, 55, 35, 15, 25, 10]
bubble_sort(arr)
console.log(arr)