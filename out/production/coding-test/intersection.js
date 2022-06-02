function intersection(first_arr, second_arr) {
    let new_arr = []
    for(let i of first_arr) {
        for(let j of second_arr) {
            if(i === j) {
                new_arr.push(j)
                break
            }
        }
    }
    return new_arr
}

const f_arr = [1,3,4,6]
const s_arr = [2,4,5,6]

console.log(intersection(f_arr, s_arr))

// break를 걸어서 배열 끝까지 비교하는 것을 막는다.
// break가 있던 없던 빅오로는 O(N2)이지만 break를 걸어서 불필요한 비교를 막는것은 중요한 최적화이다.