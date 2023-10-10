(ns all-your-base)

(defn validate-input [base-a digits base-b]
  (when (or (< base-a 2) (< base-b 2))
    (throw (IllegalArgumentException. "Bases must be greater than 1")))
  (when (some #(or (< % 0) (>= % base-a)) digits)
    (throw (IllegalArgumentException. "Digits must be within the base range")))
  (when (and (seq digits) (= (first digits) 0))
    (throw (IllegalArgumentException. "Digits cannot have leading zeros"))))
(defn convert [base-a digits base-b]
  (validate-input base-a digits base-b)
  (let [number-in-base-10 (reduce #(+ (* %1 base-a) %2) 0 digits)]
    (loop [remaining number-in-base-10 result []]
      (if (zero? remaining)
        (if (empty? result)
          [0]
          result)
        (recur (quot remaining base-b) (cons (mod remaining base-b) result))))))
      (if (zero? remaining)
        (if (empty? result)
          [0]
          result)
        (recur (quot remaining base-b) (cons (mod remaining base-b) result))))))
