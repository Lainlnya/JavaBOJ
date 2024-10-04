function solution(n, times) {
    let end = Math.max(...times) * n;
    let start = 1;
    
    while (start <= end) {
        let mid = Math.floor((start + end) / 2);
        let count = 0;
        for (time of times) {
            count += Math.floor(mid / time);
        }
        
        if (count >= n) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return end + 1;
}