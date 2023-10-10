(ns strain)

(defn keep [coll pred]
  (lazy-seq
    (when-let [s (seq coll)]
      (if (pred (first s))
        (cons (first s) (keep (rest s) pred))
        (keep (rest s) pred)))))

(defn discard [coll pred]
  (keep coll (fn [item] (not (pred item)))))
