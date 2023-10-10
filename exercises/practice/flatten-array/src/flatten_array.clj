(ns flatten-array)

(defn flatten [arr]
  (loop [input arr, output []]
    (if (empty? input)
      output
      (let [elem (first input)]
        (if (coll? elem)
          (recur (concat elem (rest input)) output)
          (recur (rest input) (if (nil? elem) output (conj output elem))))))))