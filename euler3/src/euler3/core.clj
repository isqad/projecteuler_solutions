(ns euler3.core
  (:gen-class))

(defn smallest-divider
  [n]
  (loop [c 2
         square (* c c)]
    (when (> square n) n)
    (if (= (rem n c) 0)
      c
      (recur (inc c) (* c c)))))

(defn prime?
  [n]
  (if (= 1 n)
    true
    (= (smallest-divider n) n)))

(defn abs
  [n]
  (if (= n 0)
    0
    (do (if (> n 0)
          n
          (- 0 n)))))

(defn improve
  [guess x]
  ((fn [x y] (/ (+ x y) 2)) guess (/ x guess)))

(defn sqrt-iter
  [guess x]
  (if (< (abs (- (* guess guess) x)) 0.001)
    guess
    (recur (improve guess x) x)))

(defn sqrt
  [n]
  (sqrt-iter 1.0 n))

(defn biggest-prime-divider
  "Biggest prime divider"
  [n]
  (if (prime? n)
    n
    (loop [k (int (sqrt n))]
      (if (and (= 0 (rem n k)) (prime? k))
        k
        (recur (dec k))))))
