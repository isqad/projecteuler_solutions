(ns euler1.core
  (:gen-class))

(defn euler-coll
  [n]
  (let [coll (rest (range (inc n)))]
    (loop [[num & rest] coll
           result []]
      (if (empty? rest)
        result
        (do (if (or (= 0 (rem num 3)) (= 0 (rem num 5)))
              (recur rest (conj result num))
              (recur rest result)))))))

(defn euler-sum
  [n]
  (reduce + 0 (euler-coll n)))
