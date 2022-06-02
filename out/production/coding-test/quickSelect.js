class QuickSelectableArray {
    get array() {
        return this._array;
    }

    constructor(array) {
        this._array = array
    }

    partition(left_pointer, right_pointer) {
        const pivot_poisition = right_pointer
        let pivot = this._array[pivot_poisition]

        right_pointer -= 1

        while(true) {
            while(this._array[left_pointer] < pivot) {
                left_pointer += 1
            }

            while(this._array[right_pointer] > pivot) {
                right_pointer -= 1
            }

            if (left_pointer >= right_pointer){
                break;
            } else {
                this.swap(left_pointer, right_pointer)
            }
        }

        this.swap(left_pointer, pivot_poisition)
        return left_pointer
    }

    swap(pointer_1, pointer_2) {
        const temp = this._array[pointer_1]
        this._array[pointer_1] = this._array[pointer_2]
        this._array[pointer_2] = temp
    }

    quickselect(k_th_lowest_value, left_index, right_index) {
        // 하위 배열의 셀이 하나라면 찾고있던 값을 찾은 것이다.
        if(right_index - left_index <= 0) {
            return this._array[left_index]
        }

        const pivot_position = this.partition(left_index, right_index)

        // 찾으려는 값의 인덱스가 분할 과정을 거친 후의 피벗 인덱스보다 작다면 피벗의 왼쪽 배열에 재귀적으로 퀵 셀렉트를 진행해서 분할 과정을 다시 한다.
        if(k_th_lowest_value < pivot_position) {
            return this.quickselect(k_th_lowest_value, left_index, pivot_position - 1)
        } else if (k_th_lowest_value > pivot_position) {
            return this.quickselect(k_th_lowest_value, pivot_position + 1, right_index)
        } else { // 분할 후 피벗의 인덱스가 k번째 작은 값과 같으면 값을 찾은 것이므로 반환한다.
            return this._array[pivot_position]
        }
    }
}

const array1 = [1, 5, 3, 6, 8, 4, 7, 10, 11, 9]
const quick_selectable_array = new QuickSelectableArray(array1)
const k_th = 5
console.log(quick_selectable_array.quickselect(k_th - 1, 0, array1.length - 1))
console.log(quick_selectable_array._array)