# Note

### 二分法

* 左闭右闭的情况下，循环判断条件应该为`left <= right`,区间改变情况应该为`left = mid + 1`,`right = mid - 1`.
* 左闭右开的情况下，循环判断条件应该为`left < right`,区间改变情况应该为`left = mid + 1`,`right = mid`.

####左闭右闭

    while(left <= right) {
        mid = left + ((right - left) >> 1);
        if(arr[mid] > arr[left]) {
            left = mid + 1;
        } else if(arr[mid] < arr[left]) {
            right = mid - 1;
        }
    }

####左闭右开

    while(left < right) {
        mid = left + ((right - left) >> 1);
        if(arr[mid] > arr[left]) {
            left = mid + 1;
        } else if(arr[mid] < arr[left]) {
            right = mid;
        }
    }