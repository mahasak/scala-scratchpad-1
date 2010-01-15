package haystack

/*
http://en.wikipedia.org/wiki/KMP_algorithm
algorithm kmp_search:
    input:
        an array of characters, S (the text to be searched)
        an array of characters, W (the word sought)
    output:
        an integer (the zero-based position in S at which W is found)

    define variables:
        an integer, m ← 0 (the beginning of the current match in S)
        an integer, i ← 0 (the position of the current character in W)
        an array of integers, T (the table, computed elsewhere)

    while m + i is less than the length of S, do:
        if W[i] = S[m + i],
            let i ← i + 1
            if i equals the length of W,
                return m
        otherwise,
            let m ← m + i - T[i],
            if T[i] is greater than -1,
                let i ← T[i]

    (if we reach here, we have searched all of S unsuccessfully)
    return the length of S

 */
class Haystack {
  def needlesIn(problem: (Int, String,String)): List[Int] = List() 

}