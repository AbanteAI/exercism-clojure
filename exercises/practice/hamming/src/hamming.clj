(ns hamming)

(defn distance [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    nil
    (count (filter true? (map not= strand1 strand2))))
