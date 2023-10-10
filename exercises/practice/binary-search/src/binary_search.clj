(ns binary-search)

(defn search-for [target sorted-list]
  (loop [start 0
         end (dec (count sorted-list))]
    (if (> start end)
      -1
      (let [mid (middle start end)]
        (cond
          (= (nth sorted-list mid) target) mid
          (< (nth sorted-list mid) target) (recur (inc start) end)
          :else (recur start (dec end)))))))

(defn middle [start end]
  (quot (+ start end) 2))
