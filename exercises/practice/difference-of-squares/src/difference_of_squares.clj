(ns difference-of-squares)

(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))
(defn sum-of-squares [n]
  (/ (* n (inc n) (* (+ n n 1) 2)) 6))
(defn square-of-sum [n]
  (let [sum (/ (* n (inc n)) 2)]
    (* sum sum)))
