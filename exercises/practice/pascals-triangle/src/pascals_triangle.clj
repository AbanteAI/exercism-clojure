(ns pascals-triangle)

(defn triangle [n]
  (->> (iterate (fn [row]
                  (conj (mapv + (cons 0 row) (conj row 0)) 1))
                [1])
       (take n)))

(defn row [n]
  (nth (triangle (inc n)) (dec n)))
