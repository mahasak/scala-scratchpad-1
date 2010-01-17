package haystack


class Haystack {

  def needlesIn(S: String, W: String): List[Int] = {
    var pos = -1
    var matches = List[Int]()
    do {
      pos = findMatch(S, W, pos+1)
      matches = pos :: matches
    } while (pos < S.length)

    matches.tail.reverse
  }

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
  def findMatch(S: String, W: String, start: Int): Int = {
    var m = start
    var i = 0
    val T = buildTable(W)
    while ((m + i) < S.length) {
        if (W.charAt(i) == S.charAt(m + i)) {
            i += 1
            if (i == W.length) return m
        }
        else {
            m = m + i - T(i)
            if (T(i) > -1) i = T(i)
        }
    }
    return S.length
  }

  
  /*
  algorithm kmp_table:
    input:
        an array of characters, W (the word to be analyzed)
        an array of integers, T (the table to be filled)
    output:
        nothing (but during operation, it populates the table)

    define variables:
        an integer, pos ← 2 (the current position we are computing in T)
        an integer, cnd ← 0 (the zero-based index in W of the next character of the current candidate substring)

    (the first few values are fixed but different from what the algorithm might suggest)
    let T[0] ← -1, T[1] ← 0

    while pos is less than the length of W, do:
        (first case: the substring continues)
        if W[pos - 1] = W[cnd], let T[pos] ← cnd + 1, pos ← pos + 1, cnd ← cnd + 1

        (second case: it doesn't, but we can fall back)
        otherwise, if cnd > 0, let cnd ← T[cnd]

        (third case: we have run out of candidates.  Note cnd = 0)
        otherwise, let T[pos] ← 0, pos ← pos + 1

  */
  def buildTable(W: String): Array[Int] = {
    var T = new Array[Int](W.length)
    T(0) = -1
    T(1) = 0
    var pos = 2
    var cnd = 0

    while (pos < W.length) {
      if (W.charAt(pos -1) == W.charAt(cnd)) {
        T(pos) = cnd+1
        pos += 1; cnd += 1
      }
      else if (cnd > 0) {
        cnd = T(cnd)
      }
      else {
        T(pos) = 0
        pos += 1
      }
    }
    return T
  }

}
