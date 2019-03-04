'''
This problem was asked by Amazon.
Given an integer k and a string s, find the length of the longest substring that
contains at most k distinct characters.
For example, given s = "abcba" and k = 2, the longest substring with k distinct
characters is "bcb".
'''

def k_distinct(str, k):
    assert(len(str) >= k)

    start_idx, end_idx, max_len = 0, k, k
    while end_idx < len(str):
        end_idx += 1

        while True:
            distinct_chars = len(set(str[start_idx:end_idx]))
            if distinct_chars <= k:
                break
            
            start_idx += 1
        
        max_len = max(max_len, end_idx - start_idx)
    
    return max_len


if __name__ == "__main__":
    str = "abcba"
    k = 2
    print(k_distinct(str, k))