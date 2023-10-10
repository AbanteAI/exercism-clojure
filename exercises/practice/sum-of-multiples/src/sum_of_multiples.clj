(ns sum-of-multiples)

(defn sum-of-multiples [level base-values]
  (let [multiples (->> (seq base-values)
                       (mapcat #(range % level %))
                       (distinct))]
    (reduce + multiples)))
