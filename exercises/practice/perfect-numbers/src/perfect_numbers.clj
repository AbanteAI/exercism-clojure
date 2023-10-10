(ns perfect-numbers)

(defn factors [num]
  (filter #(zero? (mod num %)) (range 1 (inc (/ num 2)))))
(defn aliquot-sum [num]
  (reduce + (factors num)))
(defn classify [num]
  (let [aliquot (aliquot-sum num)]
    (when (neg? num) (throw (IllegalArgumentException. "Number must be positive")))
    (cond
      (= aliquot num) :perfect
      (> aliquot num) :abundant
      :else :deficient)))
