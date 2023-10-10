(ns accumulate)

(defn accumulate [coll f]
  (loop [input coll
         output []]
    (if (empty? input)
      output
      (recur (rest input) (conj output (f (first input)))))))
