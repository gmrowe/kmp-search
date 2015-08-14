(ns famgam.kmp-search-test
  (:require [clojure.test :refer :all]
            [famgam.kmp-search :refer :all]))

(deftest knp-compile-test
  (let [w "abcdabd"
        compiled (kmp-compile w)]
    (is (= w (:word compiled)))
    (is (= [-1 0 0 0 0 1 2] (:skip-table compiled)))
    (is (= (count w) (count (:skip-table compiled))))))

(deftest kmp-search-test
  (testing "kmp-search should return the start index of all matches"
    (let [s "abcabcabcdabca"
          p (kmp-compile "abca")]
      (is (= [0 3 10] (kmp-search s p)))))
  (testing "kmp-search should work on vecotrs too"
    (let [v [1 2 3 2 3 2 3 4 2 3 2]
          p (kmp-compile [2 3 2])]
      (is (= [1 3 8] (kmp-search v p))))))
