function insertion_sort(arr) {
    for(let i = 1; i < arr.length; i++) {
        let empty_position = i
        let temp_value = arr[i]

        while(empty_position > 0 && arr[empty_position - 1] > temp_value) {
            arr[empty_position] = arr[empty_position - 1]
            empty_position -= 1
        }

        arr[empty_position] = temp_value
    }
    return arr
}

const list = [4,3,7,1,5]
console.log(insertion_sort(list))

// 1. 배열의 인덱스 1의 값을 변수에 저장하고 인덱스 1의 값을 삭제한다.
// 2. 저장해놓은 값을 삭제한 인덱스의 왼쪽에 있는 값들과 비교해서 저장한값(삭제한 인덱스의 값)이 작으면 왼쪽에 있는 값을 비어있는 인덱스로 옮겨준다.
// 3. 옮기면 새롭게 빈 인덱스가 생기고 저장한 값(삭제한 인덱스의 값)과 그 다음 왼쪽의 값과 비교한다.
// 4.  2,3을 반복한다
// 5. 저장한 값(삭제한 인덱스의 값)이 비교하는 왼쪽의 값보다 크다면 비어있는 인덱스에 저장한 값(삭제한 인덱스의 값)을 넣고 패스스루를 끝낸다.
// 6. 저장해놓을 인덱스를 1씩 늘려가며 위 과정을 반복한다.