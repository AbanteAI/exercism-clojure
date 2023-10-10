(ns prime-factors)

(defn of [n]
  (loop [factors []
         divisor 2
         num n]
    (cond
      (< num 2) factors
      (zero? (mod num divisor)) (recur (conj factors divisor) divisor (/ num divisor))
      :else (recur factors (inc divisor) num))))
