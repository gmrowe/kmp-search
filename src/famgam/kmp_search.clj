(ns famgam.kmp-search)

(defn kmp-compile [w]
  {:word w
   :skip-table
     (loop [t [-1 0]
            cnd 0]
       (cond
        (>= (count t) (count w)) t
        (= (nth w (dec (count t))) (nth w cnd))
          (recur (conj t (inc cnd)) (inc cnd))
        (> cnd 0) (recur t (nth t cnd))
        :else (recur (conj t 0) cnd)))})

(defn kmp-search [s p]
  (let [w (:word p)
        t (:skip-table p)]
    (loop [m 0
           i 0
           res []]
      (cond
       (>= (+ m i) (count s))  res
       (= (nth w i) (nth s (+ m i)))
         (if (= i (dec (count w))) ;; MATCH!
           (recur (inc m) 0 (conj res m))
           (recur  m (inc i) res))
       (> (nth t i) -1) (recur (- (+ m i) (nth t i)) (nth t i) res)
       :else (recur (inc m) 0 res) ))))


