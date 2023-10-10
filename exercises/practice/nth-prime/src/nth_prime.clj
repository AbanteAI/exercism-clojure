(ns nth-prime)
(defn is-prime?
  "Check if a number is prime."
  [n]
  (cond
    (< n 2) false
    (= n 2) true
    :else (not (some #(zero? (mod n %)) (range 2 (inc (Math/sqrt n)))))))

(defn nth-prime 
  "Returns the prime number in the nth position."
  [n] ;; <- arglist goes here
  (when (zero? n)
    (throw (IllegalArgumentException. "There is no zeroth prime")))
  (loop [i 2 count 0]
    (if (= count n)
      (dec i)
      (recur (inc i) (if (is-prime? i) (inc count) count))))
  )
