class SortableArray {
    get array() {
        return this._array
    }

    // 정렬할 배열 초기화
    constructor(array) {
        this._array = array
    }

    // 분할 과정(피벗보다 작은 모든 수는 피벗의 왼쪽에, 피벗보다 큰 모든 수는 피벗의 오른쪽에 배치하는 과정)
    partition(left_pointer, right_pointer) {
        // 가장 오른쪽에 있는 수를 피벗으로 둔다.
        const pivot_position = right_pointer
        let pivot = this._array[pivot_position]

        // 오른쪽 포인터는 피벗의 한칸 왼쪽으로 옮긴다.
        right_pointer -= 1

        //왼쪽 포인터의 인덱스가 오른쪽 포인터의 인덱스보다 크거나 같아지면 멈춘다.
        while (true) {
            // 왼쪽 포인터의 값과 피벗을 비교해서 왼쪽 포인터의 값이 피벗보다 작으면 포인터를 오른쪽으로 이동하고 
            // 같거나 커지면 왼쪽 포인터를 멈춘다.
            while (this._array[left_pointer] < pivot) {
                left_pointer += 1
            }

            // 오른쪽 포인터의 값과 피벗을 비교해서 오른쪽 포인터의 값이 피벗보다 크면 포인터를 왼쪽으로 이동하고 
            // 같거나 작아지면 오른쪽 포인터의 이동을 멈춘다.
            while(this._array[right_pointer] > pivot) {
                right_pointer -= 1
            }

            /**
             * 왼쪽 포인터의 인덱스가 오른쪽 포인터의 인덱스보다 크거나 같아지면 반복을 멈춘다.
             * 그게 아닌데 두 포인터가 멈추면 포인터의 값들끼리 자리를 바꾼다(스왑) 그리고 위 과정을 반복한다.
             */
            if(left_pointer >= right_pointer) break;
            else this.swap(left_pointer, right_pointer)
        }

        // 왼쪽 포인터의 인덱스가 오른쪽 포인터의 인덱스보다 크거나 같아지면 왼쪽 포인터의 값과 피벗의 자리를 서로 바꾼다.
        this.swap(left_pointer, pivot_position)
        // 그리고 자리가 바뀌었으면 이제 왼쪽 포인터가 피벗이었던 것이 된다. 그 왼쪽 포인터 인덱스를 반환한다.
        return left_pointer
    }

    swap(pointer_1, pointer_2) {
        const temp = this._array[pointer_1]
        this._array[pointer_1] = this._array[pointer_2]
        this._array[pointer_2] = temp
    }

    quicksort(left_index, right_index) {
        // 기저조건으로 배열의 길이가 1 혹은 0일 경우 퀵 정렬을 멈춘다.
        if(right_index - left_index <= 0) {
            return
        }

        // 분할 후 정렬된 피벗의 위치를 가져온다.
        const pivot_position = this.partition(left_index, right_index)
        // 정렬된 피벗을 기준으로 왼쪽 배열과 오른쪽 배열에 재귀적으로 퀵 정렬을 진행한다.
        this.quicksort(left_index, pivot_position - 1)
        this.quicksort(pivot_position + 1, right_index)
    }
}

const array = [0,5,2,1,6,3,4,9,7]
const sortable_array = new SortableArray(array)
sortable_array.quicksort(0, array.length - 1)
console.log(sortable_array._array)
