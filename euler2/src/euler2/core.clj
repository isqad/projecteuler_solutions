(ns euler2.core
  (:gen-class))

(defn fib-seq
  [n]
  (loop [a 1
         b 2
         result [1]]
    (if (>= b n)
      result
      (recur b (+ a b) (conj result b)))))

(defn even-fib-seq-sum
  [n]
  (reduce + 0 (filter even? (fib-seq n))))