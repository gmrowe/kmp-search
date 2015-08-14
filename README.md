# kmp-search

A clojure library for performing Knuth Morris Pratt search of vectors, strings and lists.

## Usage

```clojure
(require '[famgam.kmp-search :as kmp])

(def string-pattern "abr")

; Pattern must be compiled before use in a search string
(def compiled-string-pattern (kmp/kmp-compile string-pattern))

; Search for occourances of the pattern in a larger string
(kmp/kmp-search "abracadabra" compiled-string-pattern)
;=> [0 7]

; It works on other collection types too
(def vec-pattern [1 3 3 7])

(kmp/kmp-search [0 1 3 1 3 3 7 5 9] (kmp/kmp-compile vec-pattern))
;=> [3]
```
