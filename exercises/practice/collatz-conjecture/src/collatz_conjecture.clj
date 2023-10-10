(ns collatz-conjecture)

(defn collatz [num]
  (if (<= num 0)
    (throw (IllegalArgumentException. "Input must be a positive integer"))
    (loop [n num steps 0]
      (if (= n 1)
        steps
        (recur (if (even? n) (/ n 2) (+ (* 3 n) 1)) (inc steps))))))
